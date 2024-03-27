package ru.liga.dcs.lesson08;

public class StringFormatter02 {

    /**
     * Преобразует каждое четное по порядку слово в предложении в верхний регистр.
     * Слова в предложении разделяются пробелами. Порядок слов определяется начиная с 1,
     * так что первое слово считается нечетным, второе - четным, и так далее.
     *
     * @param sentence Предложение для форматирования. Не может быть null или пустой строкой.
     * @return Отформатированное предложение с четными словами в верхнем регистре.
     * @throws IllegalArgumentException если предложение null или пустое.
     */
    public static String capitalizeEvenWords(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence cannot be null or empty");
        }

        String[] words = sentence.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                result.append(words[i].toUpperCase());
            } else {
                result.append(words[i]);
            }
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}