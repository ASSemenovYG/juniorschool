package ru.liga.dcs.lesson07.kata;

import java.util.Objects;

public class Book {
    private final String title;
    private final int yearOfPublication;

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
        if (getClass() != o.getClass()) {
            return false;
        }
        Book other = (Book) o;
        return Objects.equals(this.title, other.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
