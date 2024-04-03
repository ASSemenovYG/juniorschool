package ru.liga.dcs.lesson09;

import org.junit.jupiter.api.Test;
import ru.liga.dcs.lesson09.domain.WordFrequency;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BookStatistics03Test {

    @Test
    void analyzeBook_fromRealFile() {
        BookStatistics03 bs = new BookStatistics03("src/test/resources/voina-i-mir.txt");
        List<WordFrequency> topWords = bs.analyzeBook();
        topWords.forEach(System.out::println);
    }

    @Test
    void analyzeBook_fromList() {
        BookStatistics03 bs = new BookStatistics03(Arrays.asList(
                "чики чикияу чикияу чикиряу",
                "скажи зачем, а потом и почему",
                "бобер курва я пердоле"
        ));
        List<WordFrequency> topWords = bs.analyzeBook();
        topWords.forEach(System.out::println);
        assertThat(topWords.size()).isEqualTo(4);
    }

    @Test
    void analyzeBook_grobSong() {
        BookStatistics03 bs = new BookStatistics03("src/test/resources/russkoe_pole_experimentov.txt");
        List<WordFrequency> topWords = bs.analyzeBook();
        topWords.forEach(System.out::println);
        List<String> words = topWords.stream()
                .map(WordFrequency::getWord)
                .toList();
        assertThat(words)
                .contains("Русское", "экпериментов", "пахнет", "нефтью");
    }
}