package ru.liga.dcs.badcode.lesson08;

import java.util.List;

public class City {
    private String name;
    private long population;
    private List<Address> addresses;

    public City(String name, long population, List<Address> addresses) {
        this.name = name;
        this.population = population;
        this.addresses = addresses;
    }


    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public List<Address> getAddresses() {
        return addresses;
    }
}
