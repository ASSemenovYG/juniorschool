package ru.liga.dcs.lesson07.task;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

import java.util.Arrays;
import java.util.List;

public class EmployeeNamesDepartmentsTest {

    private List<Employee> employees;

    @Before
    public void setUp() {
        employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "HR"),
                new Employee("Charlie", "IT"),
                new Employee("Diana", "IT")
        );
    }

    @Test
    public void testGetEmployeeNamesByDepartment() {
        List<String> hrEmployees = EmployeeNamesDepartments01.getEmployeeNamesByDepartment(employees, "HR");
        List<String> itEmployees = EmployeeNamesDepartments01.getEmployeeNamesByDepartment(employees, "IT");

        Assertions.assertThat(hrEmployees).containsExactlyInAnyOrder("Alice", "Bob");
        Assertions.assertThat(itEmployees).containsExactlyInAnyOrder("Charlie", "Diana");
    }

    @Test
    public void testGetEmployeeNamesByDepartmentEmpty() {
        List<String> marketingEmployees = EmployeeNamesDepartments01.getEmployeeNamesByDepartment(employees, "Marketing");
        Assertions.assertThat(marketingEmployees).isEmpty();
    }
}
