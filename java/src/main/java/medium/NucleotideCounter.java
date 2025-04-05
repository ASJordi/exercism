package medium;

import java.util.HashMap;
import java.util.Map;

public class NucleotideCounter {

    private final String sequence;
    private Map<Character, Integer> map;

    NucleotideCounter(String sequence) {
        validateSequence(sequence);
        this.sequence = sequence;
        initMap();
        countNucleotides();
    }

    private void validateSequence(String sequence) {
        if (sequence.matches(".*[^ACGT].*")) throw new IllegalArgumentException("Invalid nucleotide in strand");
    }

    private void initMap() {
        this.map = new HashMap<>();
        this.map.put('A', 0);
        this.map.put('C', 0);
        this.map.put('G', 0);
        this.map.put('T', 0);
    }

    private void countNucleotides() {
        if (sequence.isBlank()) return;

        for (char n : sequence.toCharArray()) {
            this.map.put(n, this.map.get(n) + 1);
        }
    }

    Map<Character, Integer> nucleotideCounts() {
        return this.map;
    }
}