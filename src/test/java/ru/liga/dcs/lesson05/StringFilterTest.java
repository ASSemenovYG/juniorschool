package ru.liga.dcs.lesson05;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringFilterTest {

    private final StringFilter01 stringFilter = new StringFilter01();

    /**
     * Тестирует фильтрацию строк, которые начинаются с определенной буквы.
     */
    @Test
    public void testFilterStrings_StartsWithLetter() {
        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry");
        Predicate<String> startsWithA = str -> str.startsWith("a");

        List<String> result = stringFilter.filterStrings(strings, startsWithA);
        assertThat(result).containsExactly("apple", "apricot");
    }

    /**
     * Тестирует фильтрацию строк по длине.
     */
    /**
     * Тестирует фильтрацию строк по длине.
     */
    @Test
    public void testFilterStrings_StringLength() {
        List<String> strings = Arrays.asList("apple", "banana", "apricot", "cherry");
        Predicate<String> lengthGreaterThanFive = str -> str.length() > 5;

        List<String> result = stringFilter.filterStrings(strings, lengthGreaterThanFive);
        assertThat(result).containsExactly("banana", "apricot", "cherry"); // Ожидаемый результат: "banana" и "apricot"
    }

    /**
     * Тестирует фильтрацию с пустым списком.
     */
    @Test
    public void testFilterStrings_EmptyList() {
        List<String> strings = Arrays.asList();
        Predicate<String> anyCondition = str -> true;

        List<String> result = stringFilter.filterStrings(strings, anyCondition);
        assertThat(result).isEmpty();
    }

    /**
     * Тестирует поведение фильтра при null в качестве аргументов.
     */
    @Test
    public void testFilterStrings_NullArguments() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringFilter.filterStrings(null, null);
        });
    }
}
