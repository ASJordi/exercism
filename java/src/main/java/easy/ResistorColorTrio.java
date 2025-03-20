package easy;

import java.util.Map;

public class ResistorColorTrio {

    Map<String, String> colorMap = Map.of(
        "black", "0",
        "brown", "1",
        "red", "2",
        "orange", "3",
        "yellow", "4",
        "green", "5",
        "blue", "6",
        "violet", "7",
        "grey", "8",
        "white", "9"
    );

    String label(String[] colors) {
        var base = colorMap.get(colors[0]) + colorMap.get(colors[1]);
        var zeros = "0".repeat(Integer.parseInt(colorMap.get(colors[2])));
        var number = Long.parseLong(base + zeros);

        if (number < 1_000) return number + " ohms";
        else if (number < 1_000_000) return number / 1000 + " kiloohms";
        else if (number < 1_000_000_000) return number / 1000000 + " megaohms";
        else return number / 1000000000 + " gigaohms";
    }

}
