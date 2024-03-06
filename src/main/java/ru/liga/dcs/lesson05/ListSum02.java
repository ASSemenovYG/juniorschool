package ru.liga.dcs.lesson05;

import java.util.List;

public class ListSum02 {

    /**
     * Суммирует все числа в списке.
     *
     * @param numbers список целых чисел
     * @return сумма чисел
     */
    public int sumList(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .sum();
    }
}
