package easy;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DifferenceOfSquaresCalculator {

    public int computeSquareOfSumTo (int input) {

        int sum = 0;
        ArrayList<Integer> numbers = IntStream.rangeClosed(1, input).boxed().collect(Collectors.toCollection(ArrayList::new));

        for (int number : numbers) {
            sum += number;
        }

        return (int) Math.pow(sum, 2);
    }

    public int computeSumOfSquaresTo (int input) {
        final int[] sum = {0};
        ArrayList<Integer> numbers = IntStream.rangeClosed(1, input).boxed().collect(Collectors.toCollection(ArrayList::new));

        numbers.forEach((number) -> {
            sum[0] += Math.pow(number, 2);
        });

        return sum[0];
    }

    public int computeDifferenceOfSquares (int input) {
        return computeSquareOfSumTo(input) - computeSumOfSquaresTo(input);
    }

}
