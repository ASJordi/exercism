package medium;

import java.util.HashSet;

public class IsogramChecker {

    public boolean isIsogram(String phrase) {
        return phrase.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .allMatch(new HashSet<>()::add);
    }

}
