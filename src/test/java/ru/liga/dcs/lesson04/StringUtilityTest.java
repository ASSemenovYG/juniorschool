package ru.liga.dcs.lesson04;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilityTest {

    @Test
    public void testCountWords_NormalCase() {
        assertThat(StringUtility01.countWords("hello world")).isEqualTo(2);
    }

    @Test
    public void testCountWords_LeadingAndTrailingSpaces() {
        assertThat(StringUtility01.countWords(" hello ")).isEqualTo(1);
    }

    @Test
    public void testCountWords_MultipleSpaces() {
        assertThat(StringUtility01.countWords("one  two   three")).isEqualTo(3);
    }

    @Test
    public void testCountWords_EmptyString() {
        assertThat(StringUtility01.countWords("")).isEqualTo(0);
    }

    @Test
    public void testCountWords_NullString() {
        assertThat(StringUtility01.countWords(null)).isEqualTo(0);
    }

    @Test
    public void testCountWords_SingleWord() {
        assertThat(StringUtility01.countWords("word")).isEqualTo(1);
    }

    @Test
    public void testCountWords_SpacesOnly() {
        assertThat(StringUtility01.countWords("   ")).isEqualTo(0);
    }
}
