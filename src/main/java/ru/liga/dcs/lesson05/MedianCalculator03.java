package ru.liga.dcs.lesson05;

import java.util.Arrays;

/**
 * Класс для расчёта медианы массива чисел.
 */
public class MedianCalculator03 {

    /**
     * Вычисляет медиану данного массива чисел.
     *
     * @param numbers массив чисел, для которого нужно вычислить медиану.
     * @return медиана массива чисел.
     * @throws IllegalArgumentException если массив null или пуст.
     */
    public double calculateMedian(double[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("numbers array cannot be null!");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("numbers array cannot be empty!");
        }
        return (Arrays.stream(numbers).sum() / Arrays.stream(numbers).count());
    }
}