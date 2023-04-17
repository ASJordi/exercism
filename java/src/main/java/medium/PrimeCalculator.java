package medium;

import java.util.ArrayList;

public class PrimeCalculator {

    public int nth (int nth) {
        ArrayList<Integer> primes = new ArrayList<>();

        if (nth == 0) throw new IllegalArgumentException();

        for (int i = 1; primes.size() < nth; i++) {
            if (isPrime(i)) primes.add(i);
        }

        return primes.get(nth - 1);
    }

    public boolean isPrime (int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}
