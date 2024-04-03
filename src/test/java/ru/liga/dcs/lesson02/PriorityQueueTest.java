package ru.liga.dcs.lesson02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.jupiter.api.Test;


public class PriorityQueueTest {

    private PriorityQueue03<Integer> queue;

    @Before
    public void setUp() {
        queue = new PriorityQueue03<>();
    }

    @Test
    public void testInsertAndExtractMax() {
        queue.insert(3, 1);
        queue.insert(4, 2);
        queue.insert(5, 1);

        assertEquals(Integer.valueOf(3), queue.extractMax());
        assertEquals(Integer.valueOf(5), queue.extractMax());
        assertEquals(Integer.valueOf(4), queue.extractMax());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.insert(1, 1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testExtractMaxFromEmptyQueue() {
        assertNull(queue.extractMax());
    }

    @Test
    public void testInsertAndExtractFourIterations() {
        queue.insert(1, 1);
        queue.insert(3, 3);
        queue.insert(4, 4);
        queue.insert(6, 6);
        queue.insert(2, 2);

        assertFalse(queue.isEmpty());
        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(2), queue.extractMax());
        assertEquals(Integer.valueOf(3), queue.extractMax());

        queue.insert(1, 1);

        assertFalse(queue.isEmpty());
        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(4), queue.extractMax());
        assertFalse(queue.isEmpty());

        queue.insert(7, 7);

        assertEquals(Integer.valueOf(6), queue.extractMax());
        assertEquals(Integer.valueOf(7), queue.extractMax());

        assertNull(queue.extractMax());
        assertTrue(queue.isEmpty());

        queue.insert(10, 1);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testInsertAndExtractSamePriority() {
        queue.insert(1, 1);
        queue.insert(13, 1);
        queue.insert(12, 1);

        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(13), queue.extractMax());
        assertEquals(Integer.valueOf(12), queue.extractMax());
        assertNull(queue.extractMax());
    }

    @Test
    public void testInsertAndExtractSameItemAndPriority() {
        queue.insert(1, 1);
        queue.insert(1, 1);
        queue.insert(1, 1);
        queue.insert(4, 1);
        queue.insert(4, 4);

        assertFalse(queue.isEmpty());
        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(1), queue.extractMax());
        assertEquals(Integer.valueOf(4), queue.extractMax());
        assertEquals(Integer.valueOf(4), queue.extractMax());
        assertNull(queue.extractMax());
    }
}


