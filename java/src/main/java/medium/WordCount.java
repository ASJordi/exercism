package medium;

import java.util.*;

public class WordCount {

    private final String PATTERN = "'?[^\\w+'?]'?|'$";

    public Map<String, Integer> phrase(String input) {

        Map<String, Integer> wordsCount = new HashMap<>();

        List<String> words = new ArrayList<>(Arrays.asList(input.toLowerCase()
                .replaceAll(PATTERN, " ")
                .split(" ")));

        words.removeIf(String::isEmpty);

        for (String w : words) {
            wordsCount.merge(w, 1, Integer::sum);
        }

        return wordsCount;
    }

}
