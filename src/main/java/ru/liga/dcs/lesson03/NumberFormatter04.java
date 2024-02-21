package ru.liga.dcs.lesson03;

/**
 * Класс для форматирования чисел.
 */
public class NumberFormatter04 {

    /**
     * Форматирует число, дополняя его лидирующими нулями.
     * Для отрицательных чисел считает - тоже символом входящим в totalLength
     *
     * @param number      Число для форматирования.
     * @param totalLength Желаемая длина результата.
     * @return Строковое представление числа, дополненное лидирующими нулями.
     */
    public static String padNumberWithLeadingZeros(int number, int totalLength) {
        String num = String.valueOf(number);
        if (num.length() >= totalLength) {
            return num;
        }

        int countLeadingZeros = totalLength - num.length();
        StringBuilder sb = new StringBuilder();

        if (num.startsWith("-")) {
            sb.append("-").append("0".repeat(countLeadingZeros)).append(num.substring(1));
        } else {
            sb.append("0".repeat(countLeadingZeros)).append(num);
        }

        return sb.toString();
    }
}
