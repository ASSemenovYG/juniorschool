package ru.liga.dcs.lesson07.task;

public class Student {
    private final String name;
    private final int yearOfAdmission;

    // Конструктор, геттеры и сеттеры
    public Student(String name, int yearOfAdmission) {
        this.name = name;
        this.yearOfAdmission = yearOfAdmission;
    }

    public String getName() {
        return name;
    }

    public int getYearOfAdmission() {
        return yearOfAdmission;
    }
}
