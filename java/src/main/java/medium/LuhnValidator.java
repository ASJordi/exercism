package medium;

public class LuhnValidator {

    public static boolean isValid(String creditCardNumber) {
        creditCardNumber = creditCardNumber.replaceAll(" ", "");

        if (!creditCardNumber.matches("[0-9]+")) return false;

        if (creditCardNumber.length() <= 1) return false;

        int sum = 0;
        boolean doubleDigit = false;

        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(creditCardNumber.charAt(i));
            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            doubleDigit = !doubleDigit;
        }

        return sum % 10 == 0;
    }

}
