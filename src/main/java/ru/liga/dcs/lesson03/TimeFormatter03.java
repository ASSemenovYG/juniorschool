package ru.liga.dcs.lesson03;

/**
 * Класс для работы с форматированием времени.
 */
public class TimeFormatter03 {

    /**
     * Конвертирует секунды в форматированное время (чч:мм:сс).
     *
     * @param seconds Количество секунд.
     * @return Строка времени в формате чч:мм:сс.
     */
    public static String convertSecondsToTime(int seconds) {
        if (seconds < 0)
            throw new IllegalArgumentException("Количество секунд не может быть отрицательным! seconds = " + seconds);
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600) / 60, seconds % 60);
    }
}
