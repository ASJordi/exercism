package easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static java.util.Map.entry;

public class ProteinTranslator { // Protein Translation

    private static Map<String, String> codons = Map.ofEntries(
            entry("AUG", "Methionine"),
            entry("UUU", "Phenylalanine"), entry("UUC", "Phenylalanine"),
            entry("UUA", "Leucine"), entry("UUG", "Leucine"),
            entry("UCU", "Serine"), entry("UCC", "Serine"), entry("UCA", "Serine"), entry("UCG", "Serine"),
            entry("UAU", "Tyrosine"), entry("UAC", "Tyrosine"),
            entry("UGU", "Cysteine"), entry("UGC", "Cysteine"),
            entry("UGG", "Tryptophan"),
            entry("UAA", "STOP"), entry("UAG", "STOP"), entry("UGA", "STOP")
    );

    List<String> translate(String rnaSequence) {
        if (rnaSequence.isBlank()) return List.of();

        List<String> proteins = new ArrayList<>();
        String[] codons = rnaSequence.split("(?<=\\G...)");

        for (String codon : codons) {
            if (!ProteinTranslator.codons.containsKey(codon)) throw new IllegalArgumentException("Invalid codon");
            String protein = ProteinTranslator.codons.get(codon);
            if (protein.equals("STOP")) break;
            proteins.add(protein);
        }

        return proteins;
    }
}
