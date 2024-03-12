package ru.liga.dcs.lesson05;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Абстрактный класс, представляющий алгоритм. Класс реализует интерфейс Runnable,
 * что позволяет алгоритмам выполняться в потоках.
 */
abstract class Algorithm implements Runnable {
    private final String name;

    /**
     * Конструктор создает новый экземпляр Algorithm с указанным именем.
     *
     * @param name Имя алгоритма.
     */
    public Algorithm(String name) {
        this.name = name;
    }

    /**
     * Возвращает имя алгоритма.
     *
     * @return Имя алгоритма.
     */
    public String getName() {
        return name;
    }
}


/**
 * Класс, предоставляющий функционал для сравнения алгоритмов.
 */
public class AlgorithmComparator07 {

    /**
     * Сравнивает производительность списка алгоритмов.
     * Возвращаемый результат — это карта, связывающая имя алгоритма с его временем выполнения.
     *
     * @param algorithms Список алгоритмов для сравнения.
     * @return Карта с именами алгоритмов и их временами выполнения.
     */
    public static Map<String, Long> compare(List<Algorithm> algorithms) {
        Map<String, Long> results = new HashMap<>();
        for (Algorithm algorithm : algorithms) {
            results.put(algorithm.getName(), timer(algorithm));
        }
        return results;
    }

    private static long timer(Runnable method) {
        long time = System.nanoTime();
        method.run();
        time = System.nanoTime() - time;
        return TimeUnit.NANOSECONDS.convert(time, TimeUnit.NANOSECONDS);
    }
}
