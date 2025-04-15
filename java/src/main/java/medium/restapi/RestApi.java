package medium.restapi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class RestApi {

    private final String KEY_USERS = "users";
    private List<User> users;

    RestApi(User... users) {
        this.users = new ArrayList<>(Arrays.asList(users));
    }

    String get(String url) {
        return "/users".equals(url) ? new JSONObject().put(KEY_USERS, this.users).toString() : "";
    }

    String get(String url, JSONObject payload) {
        if ("/users".equals(url) && payload.has(KEY_USERS)) {
            JSONArray requestedUsers = payload.getJSONArray(KEY_USERS);
            return getUsersByNames(requestedUsers);
        }
        return "";
    }

    String post(String url, JSONObject payload) {
        if ("/add".equals(url)) {
            return addUser(payload);
        } else if ("/iou".equals(url)) {
            return createIOU(payload);
        }
        return "";
    }

    private String getUsersByNames(JSONArray requestedUsers) {
        List<String> names = new ArrayList<>();

        for (int i = 0; i < requestedUsers.length(); i++) {
            names.add(requestedUsers.getString(i));
        }

        List<User> filteredUsers = users.stream()
                .filter(user -> names.contains(user.name()))
                .sorted(Comparator.comparing(User::name))
                .collect(Collectors.toList());

        return createUsersResponse(filteredUsers);
    }

    private String addUser(JSONObject payload) {
        String name = payload.getString("user");
        User newUser = User.builder().setName(name).build();
        users.add(newUser);

        return createUserJson(newUser).toString();
    }

    private String createIOU(JSONObject payload) {
        String lenderName = payload.getString("lender");
        String borrowerName = payload.getString("borrower");
        double amount = payload.getDouble("amount");

        User lender = findUserByName(lenderName);
        User borrower = findUserByName(borrowerName);

        List<User> updatedUsers = processIou(lender, borrower, amount);

        return createUsersResponse(updatedUsers);
    }

    private List<User> processIou(User lender, User borrower, double amount) {
        double borrowerOwesToLender = getDebtAmount(borrower, lender.name());
        double lenderOwesToBorrower = getDebtAmount(lender, borrower.name());

        User.Builder lenderBuilder = User.builder().setName(lender.name());
        User.Builder borrowerBuilder = User.builder().setName(borrower.name());

        copyExistingIous(lender, lenderBuilder, borrower.name());
        copyExistingIous(borrower, borrowerBuilder, lender.name());

        double netAmount;

        if (lenderOwesToBorrower > 0) {
            netAmount = amount - lenderOwesToBorrower;
            if (netAmount > 0) {
                borrowerBuilder.owes(lender.name(), netAmount);
                lenderBuilder.owedBy(borrower.name(), netAmount);
            } else if (netAmount < 0) {
                lenderBuilder.owes(borrower.name(), -netAmount);
                borrowerBuilder.owedBy(lender.name(), -netAmount);
            }
        } else {
            borrowerBuilder.owes(lender.name(), borrowerOwesToLender + amount);
            lenderBuilder.owedBy(borrower.name(), borrowerOwesToLender + amount);
        }

        User newLender = lenderBuilder.build();
        User newBorrower = borrowerBuilder.build();
        updateUserInList(newLender);
        updateUserInList(newBorrower);

        List<User> affectedUsers = new ArrayList<>();
        affectedUsers.add(newLender);
        affectedUsers.add(newBorrower);
        affectedUsers.sort(Comparator.comparing(User::name));

        return affectedUsers;
    }

    private double getDebtAmount(User user, String creditorName) {
        return user.owes().stream()
                .filter(iou -> iou.name.equals(creditorName))
                .mapToDouble(iou -> iou.amount)
                .sum();
    }

    private void copyExistingIous(User user, User.Builder builder, String excludeName) {

        user.owes().stream()
                .filter(iou -> !iou.name.equals(excludeName))
                .forEach(iou -> builder.owes(iou.name, iou.amount));

        user.owedBy().stream()
                .filter(iou -> !iou.name.equals(excludeName))
                .forEach(iou -> builder.owedBy(iou.name, iou.amount));

    }

    private User findUserByName(String name) {
        return users.stream()
                .filter(u -> u.name().equals(name))
                .findFirst()
                .orElse(null);
    }

    private void updateUserInList(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).name().equals(updatedUser.name())) {
                users.set(i, updatedUser);
                return;
            }
        }
    }

    private String createUsersResponse(List<User> userList) {
        JSONObject response = new JSONObject();
        JSONArray usersArray = new JSONArray();

        for (User user : userList) {
            usersArray.put(createUserJson(user));
        }

        response.put(KEY_USERS, usersArray);
        return response.toString();
    }

    private JSONObject createUserJson(User user) {
        JSONObject userJson = new JSONObject();
        userJson.put("name", user.name());

        JSONObject owes = new JSONObject();
        for (Iou iou : user.owes()) {
            owes.put(iou.name, iou.amount);
        }
        userJson.put("owes", owes);

        JSONObject owedBy = new JSONObject();
        for (Iou iou : user.owedBy()) {
            owedBy.put(iou.name, iou.amount);
        }

        userJson.put("owedBy", owedBy);

        double totalOwed = user.owes().stream().mapToDouble(iou -> iou.amount).sum();
        double totalOwedBy = user.owedBy().stream().mapToDouble(iou -> iou.amount).sum();
        userJson.put("balance", totalOwedBy - totalOwed);

        return userJson;
    }
}