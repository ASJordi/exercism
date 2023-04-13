package easy;

public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double rate = 221.0 * speed;

        if (speed >= 5 && speed <= 8) {
            rate *= 0.9;
        } else if (speed == 9) {
            rate *= 0.8;
        } else if (speed == 10) {
            rate *= 0.77;
        }

        return rate;
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}

