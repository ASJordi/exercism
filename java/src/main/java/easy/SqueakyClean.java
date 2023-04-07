package easy;

public class SqueakyClean {

    public static String clean (String identifier) {

        StringBuilder output = new StringBuilder();
        boolean prev = false;

        for (char ch : identifier.toCharArray()) {
            if (ch == ' ') output.append("_");
            else if (Character.isISOControl(ch)) output.append("CTRL");
            else if (Character.isLetter(ch) && (ch < 'α' || ch > 'ω')) output.append( !prev ? ch : Character.toUpperCase(ch));
            prev = ch == '-';
        }

        return output.toString();
    }

}
