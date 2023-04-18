package medium;

import java.util.*;

public class BracketChecker {

    private String brackets;

    public BracketChecker (String str) {
        this.brackets = str;
    }

    public boolean areBracketsMatchedAndNestedCorrectly () {
        char[] bracketChars = this.brackets.toCharArray();
        Stack<Character> stack = new Stack<>();
        char[] open = {'(', '[', '{'};
        char[] close = {')', ']', '}'};
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        for (int i = 0; i < bracketChars.length; i++) {
            char bracket = bracketChars[i];

            if (contains(open, bracket)) {
                stack.push(bracket);
            } else if (contains(close, bracket)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();

                if (last != pairs.get(bracket)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean contains(char[] arr, char c) {
        for (char x : arr) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

}
