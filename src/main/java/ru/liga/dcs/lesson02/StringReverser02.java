package ru.liga.dcs.lesson02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringReverser02 {

    /**
     * Переворачивает порядок слов в предложении.
     *
     * @param sentence строка, в которой нужно перевернуть слова.
     * @return строка с перевернутыми словами.
     */
    public String reverseWords(String sentence) {
        List<String> sentenceParts = Pattern.compile("\\s+|\\S+")
                .matcher(sentence)
                .results()
                .map(MatchResult::group).toList();
        List<String> reversedSentence = new ArrayList<>();
        for (int i = sentenceParts.size() - 1; i >= 0; i--) reversedSentence.add(sentenceParts.get(i));
        return reversedSentence.stream().map(Objects::toString).collect(Collectors.joining(""));
    }
}
