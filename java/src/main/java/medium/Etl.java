package medium;

import java.util.*;

public class Etl {

    Map<String, Integer> transform(Map<Integer, List<String>> old) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (var entry : old.entrySet()) {
            for (var value : entry.getValue()) {
                map.put(value.toLowerCase(), entry.getKey());
            }
        }

        return map;
    }

}
