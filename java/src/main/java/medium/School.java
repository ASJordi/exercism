package medium;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class School {

    private final Map<Integer, List<String>> map;

    public School() {
        this.map = new LinkedHashMap<>();
    }

    boolean add(String student, int grade) {

        for (List<String> students : this.map.values()) {
            if (students.contains(student)) return false;
        }

        this.map.computeIfAbsent(grade, k -> new LinkedList<>()).add(student);
        this.map.get(grade).sort(String::compareTo);

        return true;
    }

    List<String> roster() {
        List<String> result = new LinkedList<>();

        this.map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> result.addAll(entry.getValue()));

        return result;
    }

    List<String> grade(int grade) {
        return this.map.getOrDefault(grade, List.of());
    }
}