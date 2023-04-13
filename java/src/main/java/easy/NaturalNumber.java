package easy;

public class NaturalNumber {

    private int num;

    public NaturalNumber(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.num = num;
    }

    public Classification getClassification() {
        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            return Classification.PERFECT;
        } else if (sum > num) {
            return Classification.ABUNDANT;
        } else {
            return Classification.DEFICIENT;
        }
    }

}
