package medium;

import java.util.*;

public class Anagram {

    private String word;
    private ArrayList<String> anagrams = new ArrayList<>();

    public Anagram (String str) {
        this.word = str;
    }

    public List match(List<String> candidates) {

        word = word.toLowerCase();
        char[] sortedWord = word.toCharArray();
        Arrays.sort(sortedWord);

        for (String c: candidates) {

            String temp = c.toLowerCase();
            if (temp.equals(this.word)) continue;

            char[] sortedCandidate = c.toLowerCase().toCharArray();
            Arrays.sort(sortedCandidate);

            if (Arrays.equals(sortedCandidate, sortedWord)) {
                anagrams.add(c);
            }
        }

        return this.anagrams;
    }


}
