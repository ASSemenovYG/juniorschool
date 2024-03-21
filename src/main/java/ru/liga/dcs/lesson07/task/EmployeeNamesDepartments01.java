package ru.liga.dcs.lesson07.task;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Утилитный класс для работы с сотрудниками.
 * Stream#filter and Stream#map
 */
public class EmployeeNamesDepartments01 {

    /**
     * Фильтрует список сотрудников по департаменту и возвращает список их имен.
     *
     * @param employees  список сотрудников
     * @param department название департамента
     * @return список имен сотрудников из данного департамента
     */
    public static List<String> getEmployeeNamesByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> Objects.equals(employee.getDepartment(), department))
                .map(Employee::getName)
                .collect(Collectors.toList());
    }
}
