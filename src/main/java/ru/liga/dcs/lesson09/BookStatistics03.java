package ru.liga.dcs.lesson09;

import ru.liga.dcs.lesson09.domain.WordFrequency;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Класс BookStatistics предназначен для анализа текстовых файлов,
 * особенно больших литературных произведений, и вычисления статистики
 * по частоте встречаемости слов длиной более пяти символов.
 * Этот класс читает текстовый файл, обрабатывает его содержимое и
 * идентифицирует десять самых часто встречающихся слов длиной более
 * пяти символов, предоставляя их в виде списка объектов WordFrequency.
 * <p>
 * Пример использования:
 * <pre>
 * {@code
 * BookStatistics stats = new BookStatistics();
 * List<WordFrequency> topWords = stats.analyzeBook("path/to/book.txt");
 * topWords.forEach(System.out::println);
 * }
 * </pre>
 * <p>
 * Путь к файлу для анализа должен быть указан в виде строки.
 * Результатом работы метода analyzeBook является список объектов WordFrequency,
 * каждый из которых содержит слово и количество его вхождений в тексте.
 * <p>
 * Тестовые данные:
 * Тестовый файл для анализа (например, "voina-i-mir.txt") должен находиться
 * в каталоге ресурсов тестов, обычно это "src/test/resources/" в структуре проекта.
 * Убедитесь, что файл имеет соответствующий текст для анализа.
 * <p>
 * !!! Для этого класса необходимо написать тесты
 * <br/>
 * !!! Использовать потоковое чтение
 */
public class BookStatistics03 {

    private final String filePath;
    private final List<String> lines;
    private final Map<String, Integer> words = new HashMap<>();
    private static final int WORD_LENGTH_THRESHOLD = 5;
    private static final int RESULT_LIST_MAX_SIZE = 10;

    /**
     * @param filePath Путь к файлу
     */
    public BookStatistics03(String filePath) {
        this.filePath = filePath;
        this.lines = null;
    }

    /**
     * @param lines Лист стрингов (строк)
     */
    public BookStatistics03(List<String> lines) {
        this.filePath = null;
        this.lines = lines;
    }

    /**
     * Анализирует заданный текстовый файл и возвращает статистику
     * по десяти самым часто встречающимся словам длиной более пяти символов.
     *
     * @return Список объектов WordFrequency, представляющих десять
     * самых часто встречающихся слов и их частоту.
     */
    public List<WordFrequency> analyzeBook() {
        words.clear();
        if (filePath != null) {
            return analyzeBookFromFile();
        }
        return analyzeFromListOfStrings();
    }

    private List<WordFrequency> analyzeFromListOfStrings() {
        if (lines == null || lines.isEmpty()) {
            return Collections.emptyList();
        }

        for (String line : lines) {
            parseLine(line);
        }
        return getListOfFrequencies();
    }

    private List<WordFrequency> analyzeBookFromFile() {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty!");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                parseLine(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return getListOfFrequencies();
    }

    private void parseLine(String line) {
        if (line == null || line.isEmpty()) {
            return;
        }

        List<String> lineWords = Pattern.compile("[^\\s!\"#$%&'()*+,\\-./:;<=>?@\\[\\]^_`{|}\\\\]+", Pattern.MULTILINE)
                .matcher(line)
                .results()
                .map(MatchResult::group)
                .toList()
                .stream()
                .filter(s -> s.length() > WORD_LENGTH_THRESHOLD)
                .toList();

        for (String word : lineWords) {
            words.put(word, words.getOrDefault(word, 0) + 1);
        }
    }

    private List<WordFrequency> getListOfFrequencies() {
        List<WordFrequency> wordFrequencies = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            wordFrequencies.add(new WordFrequency(entry.getKey(), entry.getValue()));
        }
        return wordFrequencies.stream()
                .sorted(Comparator.comparingInt(WordFrequency::getFrequency).reversed())
                .limit(RESULT_LIST_MAX_SIZE)
                .toList();
    }
}
