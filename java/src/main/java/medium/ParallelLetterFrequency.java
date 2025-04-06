package medium;

import java.util.Map;
import java.util.concurrent.*;

public class ParallelLetterFrequency {

    private final String[] input;

    ParallelLetterFrequency(String[] texts) {
        this.input = texts;
    }

    Map<Character, Integer> countLetters() {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
        ForkJoinPool pool = new ForkJoinPool();

        pool.invoke(new LetterCountTask(input, map, 0, input.length));
        return map;
    }

    private static class LetterCountTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 10;
        private final String[] input;
        private final ConcurrentHashMap<Character, Integer> map;
        private final int start, end;

        LetterCountTask(String[] input, ConcurrentHashMap<Character, Integer> map, int start, int end) {
            this.input = input;
            this.map = map;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            if (end - start <= THRESHOLD) {
                for (int i = start; i < end; i++) {
                    for (char letter : input[i].toLowerCase().toCharArray()) {
                        if (Character.isLetter(letter)) {
                            map.merge(letter, 1, Integer::sum);
                        }
                    }
                }
            } else {
                int mid = (start + end) / 2;
                LetterCountTask leftTask = new LetterCountTask(input, map, start, mid);
                LetterCountTask rightTask = new LetterCountTask(input, map, mid, end);
                invokeAll(leftTask, rightTask);
            }
            return null;
        }
    }
}
