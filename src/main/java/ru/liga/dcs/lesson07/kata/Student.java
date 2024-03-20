package ru.liga.dcs.lesson07.kata;

public class Student {
    private String name;
    private double grade;

    /**
     * Конструктор класса Student.
     *
     * @param name  Имя студента.
     * @param grade Оценка студента.
     */
    public Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}
