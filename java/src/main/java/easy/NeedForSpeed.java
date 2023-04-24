package easy;

public class NeedForSpeed {

    private int batteryDrain;
    private int speed;
    private int distanceDriven;
    private int remainingBattery = 100;

    public NeedForSpeed(int speed, int batteryDrain){
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    public boolean batteryDrained() {
        return this.remainingBattery < this.batteryDrain;
    }

    public int distanceDriven() {
        return this.distanceDriven;
    }

    public void drive() {
        if(!batteryDrained()){
            this.distanceDriven = this.distanceDriven + this.speed;
            this.remainingBattery = this.remainingBattery - this.batteryDrain;
        }

    }

    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50,4);
    }

}

class RaceTrack {

    private int distance;

    public RaceTrack(int distance){
        this.distance = distance;
    }

    public boolean tryFinishTrack(NeedForSpeed car) {

        while(!car.batteryDrained()){
            car.drive();
        }

        return car.distanceDriven() >= this.distance;
    }
}
