package ru.liga.dcs.lesson01;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DuplicateRemover01Test extends TestCase {
    private DuplicateRemover01 duplicateRemover01;

    @Before
    public void setUp() {
        duplicateRemover01 = new DuplicateRemover01();
    }

    @Test
    public void testRemoveDuplicates_AllUnique() {
        List<String> original = Arrays.asList("Apple", "Banana", "Orange");
        List<String> result = duplicateRemover01.removeDuplicates(original);
        assertEquals(Arrays.asList("Apple", "Banana", "Orange"), result);
    }

    @Test
    public void testRemoveDuplicates_SomeDuplicates() {
        List<String> original = Arrays.asList("Apple", "Banana", "Apple", "Orange", "Banana");
        List<String> result = duplicateRemover01.removeDuplicates(original);
        assertEquals(Arrays.asList("Apple", "Banana", "Orange"), result);
    }

    @Test
    public void testRemoveDuplicates_EmptyList() {
        List<String> original = Arrays.asList();
        List<String> result = duplicateRemover01.removeDuplicates(original);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void testRemoveDuplicates_NullList() {
        List<String> result = duplicateRemover01.removeDuplicates(null);
        assertEquals(null, result);
    }

}