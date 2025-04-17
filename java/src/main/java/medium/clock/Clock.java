package medium.clock;

import java.util.Objects;

public class Clock {
    private int hours;
    private int minutes;

    public Clock(int hours, int minutes) {
        normalizeTime(hours * 60 + minutes);
    }

    public void add(int minutes) {
        normalizeTime(this.hours * 60 + this.minutes + minutes);
    }

    private void normalizeTime(int totalMinutes) {
        while (totalMinutes < 0) totalMinutes += 24 * 60;

        this.hours = (totalMinutes / 60) % 24;
        this.minutes = totalMinutes % 60;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Clock other = (Clock) obj;
        return hours == other.hours && minutes == other.minutes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hours, minutes);
    }
}