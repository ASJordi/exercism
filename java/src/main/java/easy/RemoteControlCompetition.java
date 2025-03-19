package easy;

import java.util.List;

public class RemoteControlCompetition { }

class ExperimentalRemoteControlCar implements RemoteControlCar {

    private int distanceTravelled = 0;

    public void drive() {
        this.distanceTravelled += 20;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }
}

class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    private int distanceTravelled = 0;
    private int numberOfVictories = 0;

    public void drive() {
        this.distanceTravelled += 10;
    }

    public int getDistanceTravelled() {
        return this.distanceTravelled;
    }

    public int getNumberOfVictories() {
        return this.numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    @Override
    public int compareTo(ProductionRemoteControlCar o) {
        return Integer.compare(o.getNumberOfVictories(), this.getNumberOfVictories());
    }
}

class TestTrack {

    public static void race(RemoteControlCar car) {
        car.drive();
    }

    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        cars.sort(ProductionRemoteControlCar::compareTo);
        return cars;
    }
}

interface RemoteControlCar {
    void drive();
    int getDistanceTravelled();
}
