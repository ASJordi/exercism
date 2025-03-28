package medium;

public class Bob {

    String hey(String input) {

        input = input.trim();
        boolean isYelling = !input.equals(input.toLowerCase()) && input.equals(input.toUpperCase());
        boolean isQuestion = input.endsWith("?");
        boolean isSilent = input.isBlank();

        if (isSilent) return "Fine. Be that way!";
        if (isYelling && isQuestion) return "Calm down, I know what I'm doing!";
        if (isYelling) return "Whoa, chill out!";
        if (isQuestion) return "Sure.";

        return "Whatever.";

    }
}