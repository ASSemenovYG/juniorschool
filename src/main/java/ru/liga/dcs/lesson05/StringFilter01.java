package ru.liga.dcs.lesson05;

import java.util.List;
import java.util.function.Predicate;

public class StringFilter01 {

    /**
     * Фильтрует список строк, оставляя только те, которые удовлетворяют заданному условию.
     *
     * @param strings   список строк
     * @param condition условие для фильтрации
     * @return отфильтрованный список
     */
    public List<String> filterStrings(List<String> strings, Predicate<String> condition) {
        if (strings == null) {
            throw new IllegalArgumentException("List of strings cannot be null!");
        }

        return strings.stream()
                .filter(condition)
                .toList();
    }
}
