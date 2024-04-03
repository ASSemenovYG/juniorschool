package ru.liga.dcs.lesson06;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TextUtilityTest {

    @Test
    public void testFindLongestWord_withLongestAtTheEnd() {
        assertThat(TextUtility01.findLongestWord("The quick brown fox")).isEqualTo("quick");
    }

    @Test
    public void testFindLongestWord_withLongestInTheMiddle() {
        assertThat(TextUtility01.findLongestWord("jumps over the lazy dog")).isEqualTo("jumps");
    }

    @Test
    public void testFindLongestWord_withOneWord() {
        assertThat(TextUtility01.findLongestWord("Hello")).isEqualTo("Hello");
    }

    @Test
    public void testFindLongestWord_withEmptyString() {
        assertThat(TextUtility01.findLongestWord("")).isEqualTo("");
    }

    @Test
    public void testFindLongestWord_withAllEqualLength() {
        assertThat(TextUtility01.findLongestWord("a bb ccc dddd eeee fff gg h")).isEqualTo("dddd");
    }

    @Test
    public void testFindLongestWord_withNull() {
        assertThat(TextUtility01.findLongestWord(null)).isEqualTo("");
    }

    // Дополнительные тесты могут быть добавлены для проверки разных сценариев
}
