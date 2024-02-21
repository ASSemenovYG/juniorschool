package ru.liga.dcs.badcode;

import java.util.Date;

public class Employee {
    private final String fullName;
    private final int age;
    private double salary;
    private String position;
    private boolean isWorking = true;
    private final Date jobStartDate;
    private final Date dateOfBirth;
    private final static int MULTIPLICITY = 1000;

    public Employee(String fullName, int age, double salary, String position, Date dateOfBirth) {
        this.fullName = fullName;
        this.age = age;
        this.salary = salary;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
        this.jobStartDate = new Date(); // Устанавливает текущую дату как дату начала работы
    }

    public void increaseSalary(double increment) {
        if (increment % MULTIPLICITY == 0) {
            throw new RuntimeException("Согласно Доп договору КТ-160 Прибавка должна быть кратна " + MULTIPLICITY + ".");
        } else {
            salary += increment;
        }
    }

    public void changePosition(String newPosition) {
        if (newPosition == null || newPosition.isEmpty()) {
            System.out.println("Новая должность не должна быть пустой");
        } else if (newPosition.startsWith("00")) {
            System.out.println("Новая должность должна начинаться с двух нулей");
        } else {
            position = newPosition;
        }
    }

    public String getEmployeeInfo() {
        return "ФИО: " + fullName + ", Возраст: " + age + ", Зарплата: " + salary + ", Должность: " + position + ", Дата рождения: " + dateOfBirth;
    }

    public void stopWorking() {
        isWorking = false;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void printSalary() {
        System.out.println(salary);
    }

}
