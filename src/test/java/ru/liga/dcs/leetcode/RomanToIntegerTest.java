package ru.liga.dcs.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanToIntegerTest {

    private RomanToInteger romanToInteger;

    @Before
    public void setUp() throws Exception {
        romanToInteger = new RomanToInteger();
    }

    @Test
    public void testRomanToInt() {
        assertThat(romanToInteger.romanToInt("III")).isEqualTo(3);
        assertThat(romanToInteger.romanToInt("LVIII")).isEqualTo(58);
        assertThat(romanToInteger.romanToInt("MCMXCIV")).isEqualTo(1994);
        assertThat(romanToInteger.romanToInt("IV")).isEqualTo(4);
    }
}