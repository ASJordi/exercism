package easy;

public class ElonsToyCar {

    private int drivenDistance;
    private int remainingBattery;

    public ElonsToyCar() {
        this.drivenDistance = 0;
        this.remainingBattery = 100;
    }

    public static ElonsToyCar buy() {
        return new ElonsToyCar();
    }

    public String distanceDisplay() {
        return String.format("Driven %d meters", this.drivenDistance);
    }

    public String batteryDisplay() {
        return (this.remainingBattery == 0) ? "Battery empty" : String.format("Battery at %d%%", this.remainingBattery);
    }

    public void drive() {
        if (this.remainingBattery > 0){
            this.drivenDistance += 20;
            this.remainingBattery--;
        }
    }

}
