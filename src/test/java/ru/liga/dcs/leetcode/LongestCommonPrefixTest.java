package ru.liga.dcs.leetcode;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LongestCommonPrefixTest {
    private LongestCommonPrefix longestCommonPrefix;

    @Before
    public void setUp() throws Exception {
        longestCommonPrefix = new LongestCommonPrefix();
    }

    @Test
    public void longestCommonPrefixMatchFirstTwo() {
        String[] testArray = {
                "flower", "flow", "flight"};
        assertThat(longestCommonPrefix.longestCommonPrefix(testArray)).isEqualTo("fl");
    }

    @Test
    public void longestCommonPrefixNoneMatch() {
        String[] testArray = {
                "dog","racecar","car"};
        assertThat(longestCommonPrefix.longestCommonPrefix(testArray)).isEqualTo("");
    }

    @Test
    public void longestCommonPrefixSingleWord() {
        String[] testArray = {
                "a"};
        assertThat(longestCommonPrefix.longestCommonPrefix(testArray)).isEqualTo("a");
    }

    @Test
    public void longestCommonPrefixKEK() {
        String[] testArray = {
                "KEKW", "KEKU", "KEKWTF", "KEKL", "KEKWait"};
        assertThat(longestCommonPrefix.longestCommonPrefix(testArray)).isEqualTo("KEK");
    }
}