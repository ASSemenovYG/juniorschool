package ru.liga.dcs.lesson07.kata;

import java.util.List;

public class Author {
    private String name;
    private List<Book> books;

    // Конструктор, геттеры и сеттеры...

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
