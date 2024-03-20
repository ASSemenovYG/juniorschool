package ru.liga.dcs.lesson07.kata;

public class Student {
    private final String name;
    private final double grade;

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

    public String getNameAndGrade() {
        return this.name + ": " + this.grade;
    }
}
