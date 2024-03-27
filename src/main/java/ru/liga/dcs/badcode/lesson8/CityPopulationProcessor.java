package ru.liga.dcs.badcode.lesson8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CityPopulationProcessor {
    private static List<City> data;


    public void setDataForProcess(List<City> data) {
        this.data = data;
    }

    public static AtomicInteger processData() {
        AtomicInteger countFiveStoryBuildings = new AtomicInteger();
        data.stream()
                .filter(city -> city.getPopulation() > 1_000_000)
                .forEach(city -> {
                    city.getAddresses().forEach(address -> {
                        if (address.getFloors() == 5) {
                            countFiveStoryBuildings.incrementAndGet();
                        }
                    });
                });
        return countFiveStoryBuildings;
    }
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City("New York", 8_398_748, Arrays.asList(new Address("Main St", 123, 10), new Address("Broadway", 789, 20))),
                new City("Los Angeles", 3_990_456, Arrays.asList(new Address("Sunset Blvd", 456, 5), new Address("Hollywood Blvd", 321, 4))),
                new City("San Francisco", 883_305, Arrays.asList(new Address("Market St", 233, 3), new Address("Castro St", 100, 2)))
        );

        CityPopulationProcessor cityPopulationProcessor = new CityPopulationProcessor();
        cityPopulationProcessor.setDataForProcess(cities);

        System.out.println("Number of five-story buildings in cities with a population over 1 million: "
                + cityPopulationProcessor.processData().get());

    }
}

