package medium;

import java.util.Arrays;

public class WordProblemSolver {

    public static int solve(final String wordProblem) throws IllegalArgumentException {
        String p = "What\\sis\\s-?\\d+(\\s(((divided\\sby)|(multiplied\\sby)|(plus)|(minus))\\s-?\\d+))*\\?";

        if (!wordProblem.matches(p)) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        } else {

            String words[] = Arrays.stream(wordProblem.replaceAll("((What)|(is)|(by)|\\?)", "").trim().split(" ")).filter(word -> !word.isEmpty()).toArray(String[]::new);
            int result = Integer.parseInt(words[0]);

            for (int i = 1; i < words.length; i = i + 2) {
                result = compute(result, words[i], Integer.parseInt(words[i+1]));
            }

            return result;
        }

    }

    static int compute(int n1, String operator, int n2){
        switch(operator){
            case "plus":
                return n1+n2;
            case "minus":
                return n1-n2;
            case "multiplied":
                return n1*n2;
            case "divided":
                return n1/n2;
        }
        throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
    }

}
