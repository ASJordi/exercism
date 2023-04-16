package easy;

import java.util.HashMap;
import java.util.Map;

public class SpaceAge {
    private final Map<String, Double> age = new HashMap<>();
    private final double ageInSeconds;

    public SpaceAge(long ageInSeconds) {
        this.ageInSeconds = ageInSeconds;
        double ageOnEarth = getSeconds() / 31557600;
        age.put("EARTH", ageOnEarth);
        age.put("MERCURY", ageOnEarth / 0.2408467);
        age.put("VENUS", ageOnEarth / 0.61519726);
        age.put("MARS", ageOnEarth / 1.8808158);
        age.put("JUPITER", ageOnEarth / 11.862615);
        age.put("SATURN", ageOnEarth / 29.447498);
        age.put("URANUS", ageOnEarth / 84.016846);
        age.put("NEPTUNE", ageOnEarth / 164.79132);
    }

    public double getSeconds() {
        return ageInSeconds;
    }

    public double onEarth() {
        return age.get("EARTH");
    }

    public double onMercury() {
        return age.get("MERCURY");
    }

    public double onVenus() {
        return age.get("VENUS");
    }

    public double onMars() {
        return age.get("MARS");
    }

    public double onJupiter() {
        return age.get("JUPITER");
    }

    public double onSaturn() {
        return age.get("SATURN");
    }

    public double onNeptune() {
        return age.get("NEPTUNE");
    }

    public double onUranus() {
        return age.get("URANUS");
    }

}