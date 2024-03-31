package ru.liga.dcs.lesson08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LevenshteinCalculator04Test {

    @Test
    void calculateDistance_exceptionFirstStringNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            LevenshteinCalculator04.calculateDistance(null, "test");
        });
    }

    @Test
    void calculateDistance_exceptionSecondStringNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            LevenshteinCalculator04.calculateDistance("test", null);
        });
    }

    @Test
    void calculateDistance_exceptionBothStringsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            LevenshteinCalculator04.calculateDistance(null, null);
        });
    }

    @Test
    void calculateDistance_oneUnit() {
        Assertions.assertEquals(1, LevenshteinCalculator04.calculateDistance("vest", "test"));
    }

    @Test
    void calculateDistance_threeUnits() {
        Assertions.assertEquals(3, LevenshteinCalculator04.calculateDistance("Текст", "Торт"));
        Assertions.assertEquals(3, LevenshteinCalculator04.calculateDistance("строка", "собака"));
    }

    @Test
    void calculateDistance_sixUnits() {
        Assertions.assertEquals(6, LevenshteinCalculator04.calculateDistance("bodybuilder", "stringbuilder"));
    }

    @Test
    void calculateDistance_tenUnits() {
        Assertions.assertEquals(10, LevenshteinCalculator04.calculateDistance("кандибобер", "абракадабра"));
    }

}