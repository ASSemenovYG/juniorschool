package ru.liga.dcs.leetcode;

/**
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two, if there exists an integer x such that n == 2x.
 * Follow up: Could you solve it without loops/recursion?
 * https://leetcode.com/problems/power-of-two/
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        //математическое решение через логарифм почему-то не прошло, валится на n = 536870912 (2^29)
        //return ((Math.log(n) / Math.log(2)) % 1 == 0);
        return (n > 0) && Integer.bitCount(n) == 1;
    }

}
