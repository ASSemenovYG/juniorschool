package ru.liga.dcs.lesson03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Тесты для класса TemperatureConverter.
 */
public class TemperatureConverterTest {

    @Test
    public void testCelsiusToFahrenheit_ZeroCelsius() {
        double result = TemperatureConverter01.celsiusToFahrenheit(0);
        assertThat(result).isEqualTo(32);
    }

    @Test
    public void testCelsiusToFahrenheit_BoilingPoint() {
        double result = TemperatureConverter01.celsiusToFahrenheit(100);
        assertThat(result).isEqualTo(212);
    }

    @Test
    public void testCelsiusToFahrenheit_FreezingPoint() {
        double result = TemperatureConverter01.celsiusToFahrenheit(-40);
        assertThat(result).isEqualTo(-40);
    }

    @Test
    public void testCelsiusToFahrenheit_RandomValue() {
        double result = TemperatureConverter01.celsiusToFahrenheit(30);
        assertThat(result).isCloseTo(86, within(0.01));
    }

    @Test
    public void testCelsiusToFahrenheit_NegativeValue() {
        double result = TemperatureConverter01.celsiusToFahrenheit(-20);
        assertThat(result).isEqualTo(-4);
    }
}
