package easy;

import java.util.Arrays;

public class BirdWatcher {

    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        this.birdsPerDay[birdsPerDay.length - 1] = getToday() + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int birds : birdsPerDay) {
            if (birds == 0) return true;
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int numOfBirds = 0;

        if (numberOfDays > birdsPerDay.length) return Arrays.stream(birdsPerDay).sum();

        for (int i = 0; i < numberOfDays; i++) {
            numOfBirds += birdsPerDay[i];
        }

        return numOfBirds;
    }

    public int getBusyDays() {
        int numOfBusyDays = 0;

        for (int birds : birdsPerDay) {
            if (birds >= 5) numOfBusyDays += 1;
        }

        return numOfBusyDays;
    }

}
