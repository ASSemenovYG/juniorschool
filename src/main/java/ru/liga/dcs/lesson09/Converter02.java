package ru.liga.dcs.lesson09;

/**
 * Класс Converter содержит методы для различных преобразований.
 */
public class Converter02 {

    /**
     * Преобразует десятичное число в двоичную строку.
     * Этот метод преобразует положительное целое число, представленное в десятичной системе счисления,
     * в его строковое представление в двоичной системе счисления.
     *
     * <p>Примеры использования:
     * <blockquote><pre>
     *     Converter converter = new Converter();
     *     String binaryString = converter.decimalToBinary(10);    // Возвращает "1010"
     *     binaryString = converter.decimalToBinary(255);          // Возвращает "11111111"
     *     binaryString = converter.decimalToBinary(1024);         // Возвращает "10000000000"
     *     binaryString = converter.decimalToBinary(0);            // Возвращает "0"
     * </pre></blockquote></p>
     *
     * @param decimalNumber положительное целое число для преобразования.
     * @return Строка, представляющая двоичное число.
     * <p>
     * + нужно покрыть тестами
     */
    public String decimalToBinary(int decimalNumber) {
        return Integer.toBinaryString(decimalNumber);
    }
}
