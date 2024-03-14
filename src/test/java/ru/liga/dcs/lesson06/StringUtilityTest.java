package ru.liga.dcs.lesson06;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilityTest {

    @Test
    public void testCanFormString_validCase() {
        assertThat(StringUtility02.canFormString("abcd", "dcba")).isTrue();
    }

    @Test
    public void testCanFormString_invalidCase() {
        assertThat(StringUtility02.canFormString("abcd", "abce")).isFalse();
    }

    @Test
    public void testCanFormString_emptyStrings() {
        assertThat(StringUtility02.canFormString("", "")).isTrue();
    }

    @Test(expected = NullPointerException.class)
    public void testCanFormString_nullInput() {
        StringUtility02.canFormString(null, "abc");
    }

    // Можно добавить дополнительные тесты для проверки других сценариев
    @Test
    public void testCanFormString_invalidCaseSameLetterTwice() {
        assertThat(StringUtility02.canFormString("abcd", "abcdd")).isFalse();
    }

    @Test
    public void testCanFormString_invalidCaseSameLetterTwiceAndSmallerTarget() {
        assertThat(StringUtility02.canFormString("abcd", "add")).isFalse();
    }

    @Test
    public void testCanFormString_invalidCaseSameLetterTwiceAndSameSizeTarget() {
        assertThat(StringUtility02.canFormString("abcd", "addd")).isFalse();
    }

    @Test
    public void testCanFormString_invalidCaseSameSizeTargetDifferentDoubledLetters() {
        assertThat(StringUtility02.canFormString("abbd", "abdd")).isFalse();
    }

    @Test
    public void testCanFormString_validCaseSameSizeDoubledLetters() {
        assertThat(StringUtility02.canFormString("abbd", "bdba")).isTrue();
    }

    @Test
    public void testCanFormString_validCaseWithSpace() {
        assertThat(StringUtility02.canFormString("ab bd", "b dba")).isTrue();
    }

    @Test
    public void testCanFormString_invalidCaseWithSpace() {
        assertThat(StringUtility02.canFormString("ab bd", "b db a")).isFalse();
    }
}
