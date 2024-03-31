package ru.liga.dcs.lesson08;

import java.time.LocalTime;

public class TimeInterval03 {
    private final LocalTime start;
    private final LocalTime end;

    public TimeInterval03(LocalTime start, LocalTime end) {
        if (start.isAfter(end)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        this.start = start;
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }


    /**
     * Проверяет перекрытие с другим временным интервалом
     *
     * @param other другой интервал
     * @return тру если перекрытие есть
     */
    public boolean overlapsWith(TimeInterval03 other) {
        return this.end.isAfter(other.start) && this.start.isBefore(other.end);
    }
}
