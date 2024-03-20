package ru.liga.dcs.lesson07.kata;

import java.util.Objects;

public class Book {
    private String title;
    private int yearOfPublication;

    // Конструктор, геттеры и сеттеры...

    public Book(String title, int yearOfPublication) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        return false;//НАПИШИТЕ ТУТ КОД СРАВНЕНИЯ ОБЪЕКТОВ
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
