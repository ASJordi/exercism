package medium;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flattener {

    public static List<Object> flatten(List<Object> list) {
        return list
                .stream()
                .flatMap(e -> e instanceof List ?
                        Flattener.flatten((List<Object>) e).stream() :
                        Stream.of(e))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
