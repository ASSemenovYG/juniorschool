package ru.liga.dcs.lesson07.task;

public class SaleRecord {
    private final String product;
    private final double amount;
    private final String category; // Новое поле

    // Конструктор, геттеры и сеттеры
    public SaleRecord(String product, double amount, String category) {
        this.product = product;
        this.amount = amount;
        this.category = category;
    }

    // ... геттеры и сеттеры ...
    public String getCategory() {
        return category;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }
}
