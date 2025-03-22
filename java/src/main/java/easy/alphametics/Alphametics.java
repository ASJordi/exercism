package easy.alphametics;

import java.util.*;

public class Alphametics {
    private final String equation;
    private final List<String> leftTerms = new ArrayList<>();
    private String rightTerm = "";
    private final Set<Character> uniqueLetters = new HashSet<>();
    private final Set<Character> leadingLetters = new HashSet<>();

    Alphametics(String userInput) {
        this.equation = userInput.replaceAll("\\s+", "");
        parseEquation();
    }

    private void parseEquation() {
        String[] parts = equation.split("==");
        if (parts.length != 2) throw new IllegalArgumentException("Invalid equation format");

        String left = parts[0];
        rightTerm = parts[1];

        if (!rightTerm.isEmpty()) {
            leadingLetters.add(rightTerm.charAt(0));
            for (char c : rightTerm.toCharArray()) {
                uniqueLetters.add(c);
            }
        }

        String[] terms = left.split("\\+");
        for (String term : terms) {
            leftTerms.add(term);
            if (!term.isEmpty()) {
                leadingLetters.add(term.charAt(0));
                for (char c : term.toCharArray()) {
                    uniqueLetters.add(c);
                }
            }
        }
    }

    Map<Character, Integer> solve() throws UnsolvablePuzzleException {
        List<Character> letters = new ArrayList<>(uniqueLetters);
        int[] values = new int[letters.size()];
        boolean[] used = new boolean[10];

        if (findSolution(letters, values, used, 0)) {
            Map<Character, Integer> result = new HashMap<>();
            for (int i = 0; i < letters.size(); i++) {
                result.put(letters.get(i), values[i]);
            }
            return result;
        }

        throw new UnsolvablePuzzleException();
    }

    private boolean findSolution(List<Character> letters, int[] values, boolean[] used, int index) {
        if (index == letters.size()) {
            return isValidSolution(letters, values);
        }

        char currentLetter = letters.get(index);
        boolean isLeadingLetter = leadingLetters.contains(currentLetter);

        for (int digit = 0; digit <= 9; digit++) {
            if (isLeadingLetter && digit == 0) continue;

            if (!used[digit]) {
                used[digit] = true;
                values[index] = digit;

                if (findSolution(letters, values, used, index + 1)) return true;

                used[digit] = false;
            }
        }

        return false;
    }

    private boolean isValidSolution(List<Character> letters, int[] values) {
        Map<Character, Integer> letterToValue = new HashMap<>();
        for (int i = 0; i < letters.size(); i++) {
            letterToValue.put(letters.get(i), values[i]);
        }

        long sum = 0;
        for (String term : leftTerms) {
            long termValue = 0;
            for (char c : term.toCharArray()) {
                termValue = termValue * 10 + letterToValue.get(c);
            }
            sum += termValue;
        }

        long rightValue = 0;
        for (char c : rightTerm.toCharArray()) {
            rightValue = rightValue * 10 + letterToValue.get(c);
        }

        return sum == rightValue;
    }
}