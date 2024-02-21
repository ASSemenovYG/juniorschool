package ru.liga.dcs.lesson03;

import java.util.regex.Pattern;

/**
 * Класс для выполнения различных операций со строками.
 */
public class StringUtilities02 {

    /**
     * Подсчитывает количество латинских гласных букв (aeiou) в строке.
     *
     * @param str Строка для анализа.
     * @return Количество гласных букв в строке.
     */
    public static int countVowels(String str) {
        return (str == null) ? 0 : (int) Pattern.compile("[aeiou]", Pattern.CASE_INSENSITIVE).matcher(str).results().count();
    }
}
