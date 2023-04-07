package easy;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber (int n) {

        char digits [] = String.valueOf(n).toCharArray();
        int sum = 0;

        for (char digit : digits) {
            sum += (int) Math.pow(Character.getNumericValue(digit), digits.length);
        }

        return (n == sum) ? true : false;

    }

}
