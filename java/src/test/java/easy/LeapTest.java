package easy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

public class LeapTest {

    private Leap leap;

    @BeforeEach
    public void setup() {
        leap = new Leap();
    }

    @Test
    public void testYearNotDivBy4InCommonYear() {
        assertFalse(leap.isLeapYear(2015));
    }

    @Test
    public void testYearDivBy2NotDivBy4InCommonYear() {
        assertFalse(leap.isLeapYear(1970));
    }

    @Test
    public void testYearDivBy4NotDivBy100InLeapYear() {
        assertTrue(leap.isLeapYear(1996));
    }

    @Test
    public void testYearDivBy4And5InLeapYear() {
        assertTrue(leap.isLeapYear(1960));
    }

    @Test
    public void testYearDivBy100NotDivBy400InCommonYear() {
        assertFalse(leap.isLeapYear(2100));
    }

    @Test
    public void testYearDivBy100NotDivBy3IsNotLeapYear() {
        assertFalse(leap.isLeapYear(1900));
    }

    @Test
    public void testYearDivBy400InLeapYear() {
        assertTrue(leap.isLeapYear(2000));
    }

    @Test
    public void testYearDivBy400NotDivBy125IsLeapYear() {
        assertTrue(leap.isLeapYear(2400));
    }

    @Test
    public void testYearDivBy200NotDivBy400InCommonYear() {
        assertFalse(leap.isLeapYear(1800));
    }

}
