package ru.liga.dcs.lesson08;


public class NumberProcessor01 {

    /**
     * Calculates the average of an array of numbers.
     *
     * @param numbers array of numbers
     * @return average of the numbers
     */
    public static double calculateAverage(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }

        return (double) sum / numbers.length;
    }
}
