package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class RemoteControlCompetitionTest {

    @Test
    @Tag("task:1")
    @DisplayName("The ProductionRemoteControlCar is an instance of the RemoteControlCar interface")
    public void productionRccIsRemoteControlCar() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        assertTrue(productionCar instanceof RemoteControlCar);
    }

    @Test
    @Tag("task:1")
    @DisplayName("The ExperimentalRemoteControlCar is an instance of the RemoteControlCar interface")
    public void experimentalRccIsRemoteControlCar() {
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        assertTrue(experimentalCar instanceof RemoteControlCar);
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getDistanceTravelled method of the ProductionRemoteControlCar returns 10 after driving once")
    public void productionCarTravels10UnitsPerDrive() {
        ProductionRemoteControlCar car = new ProductionRemoteControlCar();
        assertEquals(0, car.getDistanceTravelled());
        car.drive();
        assertEquals(10, car.getDistanceTravelled());
    }

    @Test
    @Tag("task:2")
    @DisplayName("The getDistanceTravelled method of the ExperimentalRemoteControlCar returns 20 after driving once")
    public void experimentalCarTravels20UnitsPerDrive() {
        ExperimentalRemoteControlCar car = new ExperimentalRemoteControlCar();
        assertEquals(0, car.getDistanceTravelled());
        car.drive();
        assertEquals(20, car.getDistanceTravelled());
    }

    @Test
    @Tag("task:3")
    @DisplayName("The TestTrack.race method uses the drive method on the remote control car")
    public void race() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) productionCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        TestTrack.race((RemoteControlCar) experimentalCar);
        assertEquals(20, experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled());
    }

    @Test
    @Tag("task:4")
    @DisplayName("The ProductionRemoteControlCar implements the Comparable interface")
    public void ensureCarsAreComparable() {
        assertTrue(Comparable.class.isAssignableFrom(ProductionRemoteControlCar.class));
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getRankedCars returns a list of two cars sorted by number of victories")
    public void rankTwoCars() {
        var carOne = new ProductionRemoteControlCar();
        carOne.setNumberOfVictories(3);
        var carTwo = new ProductionRemoteControlCar();
        carTwo.setNumberOfVictories(2);

        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(carOne);
        unsortedCars.add(carTwo);

        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);

        assertEquals(3, rankings.get(0).getNumberOfVictories());
        assertEquals(2, rankings.get(1).getNumberOfVictories());
    }

    @Test
    @Tag("task:4")
    @DisplayName("The getRankedCars returns a list of multiple cars sorted by number of victories")
    public void rankManyCars() {
        var a = new ProductionRemoteControlCar();
        a.setNumberOfVictories(0);
        var b = new ProductionRemoteControlCar();
        b.setNumberOfVictories(3);
        var c = new ProductionRemoteControlCar();
        c.setNumberOfVictories(5);
        var d = new ProductionRemoteControlCar();
        d.setNumberOfVictories(7);
        var e = new ProductionRemoteControlCar();
        e.setNumberOfVictories(2);
        var f = new ProductionRemoteControlCar();
        f.setNumberOfVictories(1);

        List<ProductionRemoteControlCar> unsortedCars = new ArrayList<>();
        unsortedCars.add(a);
        unsortedCars.add(b);
        unsortedCars.add(c);
        unsortedCars.add(d);
        unsortedCars.add(e);
        unsortedCars.add(f);

        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(unsortedCars);

        assertEquals(7, rankings.get(0).getNumberOfVictories());
        assertEquals(5, rankings.get(1).getNumberOfVictories());
        assertEquals(3, rankings.get(2).getNumberOfVictories());
        assertEquals(2, rankings.get(3).getNumberOfVictories());
        assertEquals(1, rankings.get(4).getNumberOfVictories());
        assertEquals(0, rankings.get(5).getNumberOfVictories());
    }

}
