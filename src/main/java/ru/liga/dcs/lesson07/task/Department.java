package ru.liga.dcs.lesson07.task;

import java.util.List;

public class Department {
    private final String name;
    private final List<Employee> employees;

    // Конструктор, геттеры и сеттеры
    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
