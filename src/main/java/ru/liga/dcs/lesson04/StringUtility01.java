package ru.liga.dcs.lesson04;

import java.util.regex.Pattern;

public class StringUtility01 {

    /**
     * Подсчет количества слов в строке.
     * <p>
     * Слова разделены одним или несколькими пробелами. Подряд идущие пробелы считаются одним разделителем.
     * <p>
     *
     * @param str Строка для подсчета слов. Может быть {@code null} или пустой.
     * @return Количество слов в строке. Возвращает 0 для {@code null} или пустой строки.
     */
    public static int countWords(String str) {
        if (str == null) {
            return 0;
        }
        return (int) Pattern.compile("\\S+").matcher(str).results().count();
    }
}
