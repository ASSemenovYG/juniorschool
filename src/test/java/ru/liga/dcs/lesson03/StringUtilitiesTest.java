package ru.liga.dcs.lesson03;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 * Тесты для класса StringUtilities.
 */
public class StringUtilitiesTest {

    @Test
    public void testCountVowels_WithVowels() {
        int result = StringUtilities02.countVowels("hello");
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void testCountVowels_WithoutVowels() {
        int result = StringUtilities02.countVowels("rhythm");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCountVowels_CaseSensitivity() {
        int result = StringUtilities02.countVowels("AEIOUaeiou");
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testCountVowels_EmptyString() {
        int result = StringUtilities02.countVowels("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void testCountVowels_NullString() {
        int result = StringUtilities02.countVowels(null);
        assertThat(result).isEqualTo(0);
    }
}
