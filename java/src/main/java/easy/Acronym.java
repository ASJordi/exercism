package easy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Acronym {
    String acronym;
    Acronym(String phrase) {
        this.acronym = Arrays.stream(phrase
                        .replaceAll("'", "")
                        .replaceAll("[-_]", " ")
                        .replaceAll("( )+", " ")
                        .toUpperCase().split(" "))
                .map(s -> s.charAt(0))
                .filter(s -> Character.isLetter(s))
                .map(s -> s.toString())
                .collect(Collectors.joining());
    }
    String get() {
        return this.acronym;
    }
}
