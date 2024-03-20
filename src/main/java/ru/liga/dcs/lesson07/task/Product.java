package ru.liga.dcs.lesson07.task;

public class Product {
    private String name;
    private double rating;
    private int reviewCount;

    // Конструктор, геттеры и сеттеры
    public Product(String name, double rating, int reviewCount) {
        this.name = name;
        this.rating = rating;
        this.reviewCount = reviewCount;
    }

    public double getRating() {
        return rating;
    }

    public int getReviewCount() {
        return reviewCount;
    }
}
