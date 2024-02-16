package ru.liga.dcs.lesson02;

import java.util.regex.Pattern;

public class CharacterCounter01 {

    /**
     * Подсчитывает количество вхождений заданного символа в строку.
     *
     * @param str строка, в которой осуществляется поиск.
     * @param ch  символ, количество вхождений которого нужно подсчитать.
     * @return количество вхождений символа в строку.
     */
    public int countCharacterOccurrences(String str, char ch) {
        return (int) Pattern.compile(String.valueOf(ch)).matcher(str).results().count();
    }
}
