package ru.liga.dcs.lesson09;

/**
 * Класс TriangleUtils содержит утилитные методы для работы с треугольниками.
 */
public class TriangleUtils01 {

    /**
     * Проверяет, могут ли три стороны образовать треугольник.
     * <p>
     * Для того чтобы три стороны могли образовать треугольник,
     * сумма длин любых двух сторон должна быть больше длины третьей стороны.
     *
     * <p>Примеры использования:
     * <blockquote><pre>
     *     TriangleUtils utils = new TriangleUtils();
     *     boolean result = utils.canFormTriangle(3, 4, 5); // Возвращает true
     *     result = utils.canFormTriangle(1, 2, 3);         // Возвращает false
     *     result = utils.canFormTriangle(5, 5, 5);         // Возвращает true
     * </pre></blockquote></p>
     *
     * @param a Длина первой стороны треугольника.
     * @param b Длина второй стороны треугольника.
     * @param c Длина третьей стороны треугольника.
     * @return true, если стороны могут образовать треугольник, иначе false.
     * <p>
     * + тесты
     */
    public boolean canFormTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}
