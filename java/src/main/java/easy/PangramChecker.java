package easy;

public class PangramChecker {

    public boolean isPangram(String input) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for (char c : alphabet.toCharArray()) {
            if (input.toLowerCase().indexOf(c) == -1) return false;
        }

        return true;
    }

}
