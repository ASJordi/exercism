package medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PigLatinTranslator {

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    private static final String AY = "ay";

    public String translate(String phrase) {
        if (phrase == null || phrase.isEmpty()) return "";

        return Arrays.stream(phrase.split("\\s+"))
                .map(this::translateWord)
                .collect(Collectors.joining(" "));
    }

    private String translateWord(String word) {
        if (startsWithVowel(word) || word.startsWith("xr") || word.startsWith("yt")) return word + AY;

        int quPosition = word.indexOf("qu");
        if (quPosition >= 0 && quPosition < 2) {
            if (quPosition == 0) return word.substring(2) + "qu" + AY;
            else return word.substring(3) + word.substring(0, 3) + AY;
        }

        int firstVowelPos = findFirstVowelPos(word);

        int yPosition = word.indexOf('y');
        if (yPosition > 0 && (firstVowelPos == -1 || yPosition < firstVowelPos)) return word.substring(yPosition) + word.substring(0, yPosition) + AY;

        if (firstVowelPos > 0) return word.substring(firstVowelPos) + word.substring(0, firstVowelPos) + AY;

        return word + AY;
    }

    private boolean startsWithVowel(String word) {
        return !word.isEmpty() && VOWELS.contains(word.charAt(0));
    }

    private int findFirstVowelPos(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (VOWELS.contains(word.charAt(i))) return i;
        }

        return -1;
    }
}