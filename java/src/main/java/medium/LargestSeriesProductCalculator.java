package medium;

import java.util.ArrayList;
import java.util.List;

public class LargestSeriesProductCalculator {

    private String input;

    LargestSeriesProductCalculator(String input) {

        if (!input.matches("^[0-9]*$")) throw new IllegalArgumentException("String to search may only contain digits.");
        this.input = input;

    }

    long calculateLargestProductForSeriesLength(int n) {

        if (n > this.input.length()) throw new IllegalArgumentException("Series length must be less than or equal to the length of the string to search.");
        if (n < 0) throw new IllegalArgumentException("Series length must be non-negative.");

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            if (i + n <= input.length()) list.add(calculateProduct(input.substring(i, i + n)));
        }

        return list.stream().max(Long::compareTo).get();

    }

    private long calculateProduct(String sub) {

        long product = 1;

        for (char c : sub.toCharArray()) {
            product *= Character.getNumericValue(c);
        }

        return product;

    }
}
