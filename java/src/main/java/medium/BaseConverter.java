package medium;

public class BaseConverter {

    private final int originalBase;
    private final int[] originalDigits;

    BaseConverter(int originalBase, int[] originalDigits) {
        if (originalBase < 2) throw new IllegalArgumentException("Bases must be at least 2.");

        if (originalDigits != null) {
            for (int digit : originalDigits) {
                if (digit < 0) throw new IllegalArgumentException("Digits may not be negative.");
                if (digit >= originalBase) throw new IllegalArgumentException("All digits must be strictly less than the base.");
            }
        }

        this.originalBase = originalBase;
        this.originalDigits = originalDigits;
    }

    int[] convertToBase(int newBase) {

        if (newBase < 2) throw new IllegalArgumentException("Bases must be at least 2.");

        if (originalDigits == null || originalDigits.length == 0 || isAllZeros(originalDigits)) return new int[]{0};

        int decimalValue = 0;
        for (int digit : originalDigits) {
            decimalValue = decimalValue * originalBase + digit;
        }

        if (decimalValue == 0) return new int[]{0};

        int temp = decimalValue;
        int length = 0;
        while (temp > 0) {
            temp /= newBase;
            length++;
        }

        int[] result = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            result[i] = decimalValue % newBase;
            decimalValue /= newBase;
        }

        return result;
    }

    private boolean isAllZeros(int[] digits) {

        for (int digit : digits) {
            if (digit != 0) return false;
        }

        return true;
    }
}