package ru.liga.dcs.lesson03;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


/**
 * Тесты для класса NumberFormatter.
 */
public class NumberFormatterTest {

    @Test
    public void testPadNumberWithLeadingZeros_LengthGreater() {
        String result = NumberFormatter04.padNumberWithLeadingZeros(123, 5);
        assertThat(result).isEqualTo("00123");
    }

    @Test
    public void testPadNumberWithLeadingZeros_LengthEqual() {
        String result = NumberFormatter04.padNumberWithLeadingZeros(12345, 5);
        assertThat(result).isEqualTo("12345");
    }

    @Test
    public void testPadNumberWithLeadingZeros_LengthLess() {
        String result = NumberFormatter04.padNumberWithLeadingZeros(123456, 5);
        assertThat(result).isEqualTo("123456");
    }

    @Test
    public void testPadNumberWithLeadingZeros_Zero() {
        String result = NumberFormatter04.padNumberWithLeadingZeros(0, 5);
        assertThat(result).isEqualTo("00000");
    }

    @Test
    public void testPadNumberWithLeadingZeros_NegativeNumber() {
        String result = NumberFormatter04.padNumberWithLeadingZeros(-123, 6);
        assertThat(result).isEqualTo("-00123");
    }
}
