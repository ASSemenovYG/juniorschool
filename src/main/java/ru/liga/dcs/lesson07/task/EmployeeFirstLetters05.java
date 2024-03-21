package ru.liga.dcs.lesson07.task;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeFirstLetters05 {

    private static final int RESULT_MAX_CHARACTERS = 5;

    /**
     * Stream#sorted, Stream#distinct, Stream#limit and Stream#flatMap Stream#map
     * <p>
     * Получает список уникальных первых букв имён сотрудников из всех отделов,
     * отсортированных в алфавитном порядке, и возвращает первые 5 букв.
     *
     * @param departments список отделов
     * @return список первых букв имён
     */
    public static List<Character> getFirstLettersOfEmployeeNames(List<Department> departments) {
        return departments.stream()
                .map(Department::getEmployees)
                .flatMap(Collection::stream)
                .map(Employee::getName)
                .map(s -> s.charAt(0))
                .distinct()
                .sorted()
                .limit(RESULT_MAX_CHARACTERS)
                .collect(Collectors.toList());
    }
}
