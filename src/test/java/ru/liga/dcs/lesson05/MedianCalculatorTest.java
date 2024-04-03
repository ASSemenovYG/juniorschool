package ru.liga.dcs.lesson05;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для класса MedianCalculator.
 */
public class MedianCalculatorTest {

    private final MedianCalculator03 calculator = new MedianCalculator03();

    /**
     * Тестирует вычисление медианы для массива с нечетным количеством элементов.
     */
    @Test
    public void testCalculateMedianWithOddNumberOfElements() {
        double[] numbers = {1, 3, 5};
        double median = calculator.calculateMedian(numbers);
        assertThat(median).isEqualTo(3);
    }

    /**
     * Тестирует вычисление медианы для массива с четным количеством элементов.
     */
    @Test
    public void testCalculateMedianWithEvenNumberOfElements() {
        double[] numbers = {1, 2, 3, 4};
        double median = calculator.calculateMedian(numbers);
        assertThat(median).isEqualTo(2.5);
    }

    /**
     * Тестирует вычисление медианы для пустого массива.
     * Ожидается исключение IllegalArgumentException.
     */
    @Test
    public void testCalculateMedianWithEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            double[] numbers = {};
            calculator.calculateMedian(numbers);
        });
    }

    /**
     * Тестирует вычисление медианы для массива null.
     * Ожидается исключение IllegalArgumentException.
     */
    @Test
    public void testCalculateMedianWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateMedian(null);
        });
    }
}