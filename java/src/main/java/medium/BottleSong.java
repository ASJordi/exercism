package medium;

public class BottleSong {

    String recite(int startBottles, int takeDown) {
        StringBuilder song = new StringBuilder();

        for (int i = 0; i < takeDown; i++) {
            int currentBottles = startBottles - i;

            song.append(bottleVerse(currentBottles));

            if (i < takeDown - 1) song.append("\n");
        }

        return song.toString();
    }

    private String bottleVerse(int bottleCount) {
        String currentBottles = numberToText(bottleCount, true);
        String nextBottles = numberToText(bottleCount - 1, false);

        String currentBottlePhrase = bottleCount == 1 ? "bottle hanging" : "bottles hanging";

        String nextBottlePhrase = (bottleCount - 1) == 1 ? "bottle hanging" : "bottles hanging";

        return String.format(
                "%s green %s on the wall,\n" +
                        "%s green %s on the wall,\n" +
                        "And if one green bottle should accidentally fall,\n" +
                        "There'll be %s green %s on the wall.\n",
                currentBottles, currentBottlePhrase,
                currentBottles, currentBottlePhrase,
                nextBottles, nextBottlePhrase
        );
    }

    private String numberToText(int number, boolean capitalize) {
        String text = switch (number) {
            case 0 -> "no";
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            case 4 -> "four";
            case 5 -> "five";
            case 6 -> "six";
            case 7 -> "seven";
            case 8 -> "eight";
            case 9 -> "nine";
            case 10 -> "ten";
            default -> String.valueOf(number);
        };

        return capitalize ? text.substring(0, 1).toUpperCase() + text.substring(1) : text;
    }
}