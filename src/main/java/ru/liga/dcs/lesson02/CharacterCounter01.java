package ru.liga.dcs.lesson02;

public class CharacterCounter01 {

    /**
     * Подсчитывает количество вхождений заданного символа в строку.
     *
     * @param str строка, в которой осуществляется поиск.
     * @param ch  символ, количество вхождений которого нужно подсчитать.
     * @return количество вхождений символа в строку.
     */
    public int countCharacterOccurrences(String str, char ch) {
        String symbol = String.valueOf(ch);
        int symbolCount = 0;
        while (str.contains(symbol)) {
            symbolCount++;
            str = str.substring(str.indexOf(symbol) + 1);
            if (str.indexOf(symbol) == str.length() - 1) break;
        }
        return symbolCount;
    }
}
