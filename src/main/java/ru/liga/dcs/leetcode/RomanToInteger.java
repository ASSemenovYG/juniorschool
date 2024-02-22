package ru.liga.dcs.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer/">RomanToInteger</a>
 */
public class RomanToInteger {

    private final static Map<String, Integer> ROMAN_NUMS = new HashMap<>() {
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
            put("IV", 4);
            put("IX", 9);
            put("XL", 40);
            put("XC", 90);
            put("CD", 400);
            put("CM", 900);
        }
    };

    public int romanToInt(String s) {
        int result = 0;
        for (int i = s.length(); i > 0; i--) {
            if (ROMAN_NUMS.get(s.substring(Math.max((i - 2), 0), i)) != null) {
                result += ROMAN_NUMS.get(s.substring(Math.max((i - 2), 0), i));
                i--;
            } else result += ROMAN_NUMS.get(s.substring(Math.max((i - 1), 0), i));
        }
        return result;
    }
}
