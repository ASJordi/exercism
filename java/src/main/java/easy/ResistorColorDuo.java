package easy;

import java.util.ArrayList;
import java.util.Arrays;

public class ResistorColorDuo {

    public int value(String[] colors) {
        ArrayList<String> colorsList = new ArrayList<>(Arrays.asList("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"));
        String res = "";

        for (int i = 0; i < 2; i++) {
            res += colorsList.indexOf(colors[i]);
        }

        return Integer.parseInt(res);
    }

}
