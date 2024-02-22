package ru.liga.dcs.leetcode;

import junit.framework.TestCase;

public class IsPalindromeTest extends TestCase {

    private IsPalindrome isPalindrome;

    public void setUp() throws Exception {
        isPalindrome = new IsPalindrome();
    }

    public void testIsPalindrome() {
        assertTrue(isPalindrome.isPalindrome(121));
        assertFalse(isPalindrome.isPalindrome(-121));
        assertFalse(isPalindrome.isPalindrome(10));
    }
}