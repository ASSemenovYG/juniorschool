package ru.liga.dcs.leetcode;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest extends TestCase {

    private TwoSum twoSum;

    @Before
    public void setUp() throws Exception {
        twoSum = new TwoSum();
    }

    @Test
    public void testTwoSum() {
        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(new int[]{3, 3}, 6));
        assertArrayEquals(new int[]{0, 3}, twoSum.twoSum(new int[]{0, 4, 3, 0}, 0));
        assertArrayEquals(new int[]{1, 2}, twoSum.twoSum(new int[]{3, 2, 4}, 6));
        assertArrayEquals(new int[]{2, 4}, twoSum.twoSum(new int[]{-1, -2, -3, -4, -5}, -8));
    }
}