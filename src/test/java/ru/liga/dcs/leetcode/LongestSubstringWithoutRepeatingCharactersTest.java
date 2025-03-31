package ru.liga.dcs.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void lengthOfLongestSubstring_abcabcbb() {
        LongestSubstringWithoutRepeatingCharacters testClass = new LongestSubstringWithoutRepeatingCharacters();

        int result1 = testClass.lengthOfLongestSubstring("abcabcbb");
        assertThat(result1).isEqualTo(3);
    }

    @Test
    void lengthOfLongestSubstring_dvdf() {
        LongestSubstringWithoutRepeatingCharacters testClass = new LongestSubstringWithoutRepeatingCharacters();

        int result1 = testClass.lengthOfLongestSubstring("dvdf");
        assertThat(result1).isEqualTo(3);
    }

    @Test
    void lengthOfLongestSubstring_bbbbb() {
        LongestSubstringWithoutRepeatingCharacters testClass = new LongestSubstringWithoutRepeatingCharacters();

        int result1 = testClass.lengthOfLongestSubstring("bbbbb");
        assertThat(result1).isEqualTo(1);
    }

    @Test
    void lengthOfLongestSubstring_pwwkew() {
        LongestSubstringWithoutRepeatingCharacters testClass = new LongestSubstringWithoutRepeatingCharacters();

        int result1 = testClass.lengthOfLongestSubstring("pwwkew");
        assertThat(result1).isEqualTo(3);
    }
}