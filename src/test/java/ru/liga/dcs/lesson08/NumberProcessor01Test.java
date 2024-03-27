package ru.liga.dcs.lesson08;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberProcessor01Test {
    @Test(expected = IllegalArgumentException.class)
    public void calculateAverage_nullInputs() {
        NumberProcessor01.calculateAverage(null);
    }

    @Test
    public void calculateAverage_SameInputs() {
        assertThat(NumberProcessor01.calculateAverage(new int[]{2, 2, 2})).isEqualTo(2);
    }

    @Test
    public void calculateAverage_OneInputIsDifferent() {
        assertThat(NumberProcessor01.calculateAverage(new int[]{2, 2, 5})).isEqualTo(3);
    }

    @Test
    public void calculateAverage_MaxIntInput_Valid() {
        assertThat(NumberProcessor01.calculateAverage(new int[]{Integer.MAX_VALUE})).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    public void calculateAverage_MaxValuePlusOne_Valid() {
        assertThat(NumberProcessor01.calculateAverage(new int[]{Integer.MAX_VALUE, 1})).isLessThan(0);
    }

    @Test
    public void calculateAverage_MaxValueAndMixValue_Valid() {
        assertThat(NumberProcessor01.calculateAverage(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE})).isEqualTo(-0.5);
    }
}