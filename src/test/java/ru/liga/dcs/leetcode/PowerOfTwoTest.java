package ru.liga.dcs.leetcode;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class PowerOfTwoTest extends TestCase {

    private PowerOfTwo powerOfTwo;

    @Before
    public void setUp() throws Exception {
        powerOfTwo = new PowerOfTwo();
    }

    @Test
    public void testIsPowerOfTwo() {
        assertTrue(powerOfTwo.isPowerOfTwo(1));
        assertTrue(powerOfTwo.isPowerOfTwo(16));
        assertFalse(powerOfTwo.isPowerOfTwo(3));
        assertTrue(powerOfTwo.isPowerOfTwo(536870912));
    }
}