package ru.liga.dcs.lesson07.task;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentAnalytics03 {

    /**
     * groupingBy
     * <p>
     * Группирует студентов по году поступления.
     *
     * @param students список студентов
     * @return карта группировки студентов по году поступления
     */
    public static Map<Integer, List<Student>> groupStudentsByYearOfAdmission(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getYearOfAdmission));
    }
}
