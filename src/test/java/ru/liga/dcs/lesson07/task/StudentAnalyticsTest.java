package ru.liga.dcs.lesson07.task;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class StudentAnalyticsTest {

    private List<Student> students;

    @Before
    public void setUp() {
        students = Arrays.asList(
            new Student("Alice", 2018),
            new Student("Bob", 2019),
            new Student("Charlie", 2018),
            new Student("Diana", 2020)
        );
    }

    @Test
    public void testGroupStudentsByYearOfAdmission() {
        Map<Integer, List<Student>> groupedStudents = StudentAnalytics03.groupStudentsByYearOfAdmission(students);

        Assertions.assertThat(groupedStudents)
                  .hasSize(3)
                  .containsKeys(2018, 2019, 2020)
                  .satisfies(map -> {
                      Assertions.assertThat(map.get(2018)).hasSize(2);
                      Assertions.assertThat(map.get(2019)).hasSize(1);
                      Assertions.assertThat(map.get(2020)).hasSize(1);
                  });
    }
}
