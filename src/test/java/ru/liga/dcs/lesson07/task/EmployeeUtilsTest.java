package ru.liga.dcs.lesson07.task;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class EmployeeUtilsTest {

    private List<Department> departments;

    @Before
    public void setUp() {
        Department hr = new Department("HR", Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Arnold", "HR")
        ));
        Department it = new Department("IT", Arrays.asList(
            new Employee("Charlie", "IT"),
            new Employee("Catherine", "IT")
        ));
        Department marketing = new Department("Marketing", Arrays.asList(
            new Employee("Bob", "Marketing"),
            new Employee("Bill", "Marketing")
        ));

        departments = Arrays.asList(hr, it, marketing);
    }

    @Test
    public void testGetFirstLettersOfEmployeeNames() {
        List<Character> firstLetters = EmployeeFirstLetters05.getFirstLettersOfEmployeeNames(departments);
        Assertions.assertThat(firstLetters).containsExactly('A', 'B', 'C');
    }
}
