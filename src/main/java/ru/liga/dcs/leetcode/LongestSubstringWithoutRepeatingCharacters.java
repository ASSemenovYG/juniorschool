package ru.liga.dcs.leetcode;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        StringBuilder sbCurr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (sbCurr.indexOf(s.substring(i, i + 1)) >= 0) {
                maxLength = Math.max(maxLength, sbCurr.length());
                sbCurr.delete(0, sbCurr.length());
                sbCurr.append(s, s.substring(0, i).lastIndexOf(s.substring(i, i + 1)) + 1, i + 1);
            } else {
                sbCurr.append(s.charAt(i));
            }
        }
        return Math.max(maxLength, sbCurr.length());
    }
}
