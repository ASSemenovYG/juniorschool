package ru.liga.dcs.lesson07.kata;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class StudentAnalyticsTest {

    @Test
    public void testFilterAndTransformStudents() {
        List<Student> students = Arrays.asList(
            new Student("Alice", 4.5),
            new Student("Bob", 3.2),
            new Student("Charlie", 4.8)
        );

        List<String> result = StudentAnalytics01.filterAndTransformStudents(students, 4.0);
        List<String> expected = Arrays.asList("Alice: 4.5", "Charlie: 4.8");

        assertEquals(expected, result);
    }
}
