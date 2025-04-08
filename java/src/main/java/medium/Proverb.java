package medium;

public class Proverb {

    private String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        if (this.words.length == 0) return "";
        if (this.words.length == 1) return "And all for the want of a " + this.words[0] + ".";

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.words.length - 1; i++) {
            sb.append("For want of a ").append(words[i]).append(" the ").append(words[i + 1]).append(" was lost.\n");
        }

        sb.append("And all for the want of a ").append(this.words[0]).append(".");

        return sb.toString();
    }

}
