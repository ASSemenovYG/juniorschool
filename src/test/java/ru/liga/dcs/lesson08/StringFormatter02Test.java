package ru.liga.dcs.lesson08;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringFormatter02Test {

    @Test(expected = IllegalArgumentException.class)
    public void capitalizeEvenWords_nullString() {
        StringFormatter02.capitalizeEvenWords(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void capitalizeEvenWords_emptyString() {
        StringFormatter02.capitalizeEvenWords("");
    }

    @Test
    public void capitalizeEvenWords_singleWord() {
        assertEquals("test", StringFormatter02.capitalizeEvenWords("test"));
    }

    @Test
    public void capitalizeEvenWords_twoWords() {
        assertEquals("second TEST", StringFormatter02.capitalizeEvenWords("second test"));
    }

    @Test
    public void capitalizeEvenWords_threeWords() {
        assertEquals("i LOVE candies", StringFormatter02.capitalizeEvenWords("i love candies"));
    }

    @Test
    public void capitalizeEvenWords_Shakespeare() {
        assertEquals("To BE, or NOT to BE, that IS the QUESTION", StringFormatter02.capitalizeEvenWords("To be, or not to be, that is the question"));
    }
}