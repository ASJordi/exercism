package medium;

public class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        if (stringToVerify == null || stringToVerify.isEmpty()) return false;

        String isbn = stringToVerify.replace("-", "");
        if (isbn.length() != 10) return false;

        for (int i = 0; i < 9; i++) {
            if (!Character.isDigit(isbn.charAt(i))) return false;
        }

        char lastChar = isbn.charAt(9);
        if (lastChar != 'X' && !Character.isDigit(lastChar)) return false;

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += Character.getNumericValue(isbn.charAt(i)) * (10 - i);
        }

        if (isbn.charAt(9) == 'X') sum += 10;
        else sum += Character.getNumericValue(isbn.charAt(9));

        return sum % 11 == 0;
    }
}