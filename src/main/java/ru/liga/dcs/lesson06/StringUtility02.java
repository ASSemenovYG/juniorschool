package ru.liga.dcs.lesson06;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StringUtility02 {
    /**
     * Проверяет, можно ли составить целевую строку (target) перестановкой символов исходной строки (original).
     * <p>
     * Эта функция учитывает количество вхождений каждого символа в обеих строках. Она возвращает true, если целевая строка
     * может быть составлена из символов исходной строки, и false в противном случае.
     * <p>
     * Обратите внимание, что сравнение символов регистрозависимо.
     *
     * @param original исходная строка, из символов которой может быть составлена целевая строка.
     * @param target   целевая строка, которую нужно попытаться составить.
     * @return true если целевая строка может быть составлена из исходной, иначе false.
     * @throws NullPointerException если одна из строк (или обе) равна null.
     */
    public static boolean canFormString(String original, String target) {
        Map<Character, Integer> originalCharsMap = getCharacterMap(original.chars().mapToObj(c -> (char) c).toList());

        boolean result = true;
        for (Map.Entry<Character, Integer> entry : getCharacterMap(target.chars().mapToObj(c -> (char) c).toList()).entrySet()) {
            result = result && Objects.equals(originalCharsMap.get(entry.getKey()), entry.getValue());
        }
        return result;
    }

    private static Map<Character, Integer> getCharacterMap(List<Character> characterList) {
        Map<Character, Integer> characterMap = new Hashtable<>();
        for (Character c : characterList) {
            characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
        }
        return characterMap;
    }
}
