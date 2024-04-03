package ru.liga.dcs.badcode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.liga.dcs.badcode.lesson08.Address;
import ru.liga.dcs.badcode.lesson08.City;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {

        List<City> cities = Arrays.asList(
                new City("New York", 8_398_748, Arrays.asList(new Address("Main St", 123, 10), new Address("Broadway", 789, 20))),
                new City("Los Angeles", 3_990_456, Arrays.asList(new Address("Sunset Blvd", 456, 5), new Address("Hollywood Blvd", 321, 4))),
                new City("San Francisco", 883_305, Arrays.asList(new Address("Market St", 233, 3), new Address("Castro St", 100, 2)))
        );

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(cities));

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
