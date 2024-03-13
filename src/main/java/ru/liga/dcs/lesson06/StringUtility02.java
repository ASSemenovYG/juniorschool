package ru.liga.dcs.lesson06;

import java.util.List;

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
        //TODO: Переделать так, чтобы проходил тест testCanFormString_invalidCaseSameSizeTargetDifferentDoubledLetters
        List<Character> originalChars = original.chars().mapToObj(c -> (char) c).toList();
        List<Character> targetChars = target.chars().mapToObj(c -> (char) c).toList();
        return targetChars.containsAll(originalChars) && target.length() <= original.length();
    }
}
