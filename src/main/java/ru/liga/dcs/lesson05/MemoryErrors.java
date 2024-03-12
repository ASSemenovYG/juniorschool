package ru.liga.dcs.lesson05;

import java.util.ArrayList;
import java.util.List;

public class MemoryErrors {
    public void createOomError() {
        List<String> strings = new ArrayList<>();
        while (true) {
            strings.add("a".repeat(10000));
        }
    }

    public void createStackOverflowError() {
        createStackOverflowError();
    }
}
