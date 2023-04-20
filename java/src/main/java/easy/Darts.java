package easy;

public class Darts {

    public int score(double xOfDart, double yOfDart) {
        double dist = Math.hypot(xOfDart, yOfDart);
        if (dist <= 1) return 10;
        if (dist <= 5) return 5;
        if (dist <= 10) return 1;
        return 0;
    }

}
