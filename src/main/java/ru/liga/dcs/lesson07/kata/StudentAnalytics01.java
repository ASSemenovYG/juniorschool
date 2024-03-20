package ru.liga.dcs.lesson07.kata;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAnalytics01 {

    /**
     * Фильтрует список студентов по оценке и преобразует в список строк.
     *
     * Псевдокод:
     * 1. Преобразовать список студентов в поток (stream()).
     * 2. Фильтровать поток, оставляя только студентов с оценкой выше gradeThreshold (filter()).
     * 3. Преобразовать каждого студента в строку "Имя: Оценка" (map()).
     * 4. Собрать результаты преобразования в список (collect(Collectors.toList())).
     *
     * @param students        Список студентов.
     * @param gradeThreshold  Порог оценки.
     * @return Список строк с именами и оценками студентов.
     */
    public static List<String> filterAndTransformStudents(List<Student> students, double gradeThreshold) {
        return Collections.emptyList();
    }
}
