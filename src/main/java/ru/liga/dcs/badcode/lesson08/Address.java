package ru.liga.dcs.badcode.lesson08;

public class Address {
    private String street;
    private int houseNumber;
    private int floors;

    // Конструктор, геттеры и сеттеры...
    public Address(String street, int houseNumber, int floors) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

}
