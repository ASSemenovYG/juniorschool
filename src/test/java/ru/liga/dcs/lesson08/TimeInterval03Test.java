package ru.liga.dcs.lesson08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

class TimeInterval03Test {
    private final LocalTime midnight = LocalTime.MIDNIGHT;
    private final LocalTime nineAM = LocalTime.of(9, 0, 0);
    private final LocalTime noon = LocalTime.NOON;
    private final LocalTime sixPM = LocalTime.of(18, 0, 0);
    private final LocalTime maxTime = LocalTime.MAX;
    private TimeInterval03 nineAmToNoon;
    private TimeInterval03 noonToMidnight;
    private TimeInterval03 nineAmToSixPm;
    private TimeInterval03 sixPmToMidnight;

    @BeforeEach
    public void setup() {
        nineAmToNoon = new TimeInterval03(nineAM, noon);
        noonToMidnight = new TimeInterval03(noon, maxTime);
        nineAmToSixPm = new TimeInterval03(nineAM, sixPM);
        sixPmToMidnight = new TimeInterval03(sixPM, maxTime);
    }

    @Test
    void overlapsWith_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            new TimeInterval03(noon, midnight);
        });
    }

    @Test
    void overlapsWith_overlappingIntervals() {
        Assertions.assertTrue(noonToMidnight.overlapsWith(nineAmToSixPm));
    }

    @Test
    void overlapsWith_nonOverlappingIntervals() {
        Assertions.assertFalse(nineAmToNoon.overlapsWith(sixPmToMidnight));
    }

    @Test
    void overlapsWith_borderlineIntervals() {
        Assertions.assertFalse(nineAmToNoon.overlapsWith(noonToMidnight));
    }

    @Test
    void overlapsWith_overlappingOneSecond() {
        nineAmToNoon = new TimeInterval03(nineAM, noon.plusSeconds(1));
        Assertions.assertTrue(nineAmToNoon.overlapsWith(noonToMidnight));
    }
}