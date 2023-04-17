package easy;

import java.util.*;

public class HighScores {

    private final List<Integer> scores;

    public HighScores(List<Integer> highScores) {
        this.scores = highScores;
    }

    public List<Integer> scores() {
        return this.scores;
    }

    public Integer latest() {
        return this.scores.get(scores.size() - 1);
    }

    public Integer personalBest() {
        return scores.stream().max(Comparator.naturalOrder()).orElse(0);
    }

    List<Integer> personalTopThree() {
        return scores.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
    }

}
