package ru.liga.dcs.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/longest-common-prefix/">LongestCommonPrefix</a>
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int i = 1;
        boolean match = true;
        while (match && i <= strs[0].length()) {
            String regex = "^" + strs[0].substring(0, i) + ".*";
            if (Arrays.stream(strs).allMatch(s -> s.matches(regex))) {
                result = strs[0].substring(0, i);
                i++;
            } else match = false;
        }
        return result;
    }
}
