package ru.liga.dcs.leetcode;

import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/palindrome-number/">Leetcode</a>
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else return Objects.equals(String.valueOf(x), new StringBuilder().append(x).reverse().toString());
    }
}
