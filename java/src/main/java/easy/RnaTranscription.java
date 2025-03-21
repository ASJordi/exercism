package easy;

public class RnaTranscription {

    String transcribe(String dnaStrand) {
        if (dnaStrand.isBlank()) return "";

        StringBuilder result = new StringBuilder();

        for (char c : dnaStrand.toCharArray()) {
            switch (c) {
                case 'G' -> result.append("C");
                case 'C' -> result.append("G");
                case 'T' -> result.append("A");
                case 'A' -> result.append("U");
                default -> result.append(c);
            }
        }

        return result.toString();
    }

}
