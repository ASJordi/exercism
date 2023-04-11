package easy;

import java.util.Arrays;

public class ResistorColor {

    public int colorCode(String color) {
        String [] colors = colors();
        return Arrays.asList(colors).indexOf(color);
    }

    public String[] colors() {
        String[] colors = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        return colors;
    }

}
