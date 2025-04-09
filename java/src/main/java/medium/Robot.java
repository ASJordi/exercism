package medium;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

public class Robot {

    private String name;
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int DIGITS = 10;
    private static final Set<String> USED_NAMES = new HashSet<>();

    public Robot() {
        generateName();
    }

    String getName() {
        return this.name;
    }

    void reset() {
        if (this.name != null) USED_NAMES.remove(this.name);
        generateName();
    }

    private void generateName() {
        String newName;
        do {
            StringBuilder nameBuilder = new StringBuilder();

            for (int i = 0; i < 2; i++) {
                nameBuilder.append(LETTERS.charAt(RANDOM.nextInt(LETTERS.length())));
            }

            for (int i = 0; i < 3; i++) {
                nameBuilder.append(RANDOM.nextInt(DIGITS));
            }

            newName = nameBuilder.toString();
        } while (USED_NAMES.contains(newName));

        USED_NAMES.add(newName);
        this.name = newName;
    }
}