package ru.liga.dcs.lesson02;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CharacterCounterTest {

    @Test
    public void testCountCharacterOccurrences() {
        CharacterCounter01 counter = new CharacterCounter01();

        assertThat(counter.countCharacterOccurrences("Привет, как дела?", 'а')).isEqualTo(2);
        assertThat(counter.countCharacterOccurrences("Hello, world!", 'z')).isEqualTo(0);
        assertThat(counter.countCharacterOccurrences("Java", 'J')).isEqualTo(1);
        assertThat(counter.countCharacterOccurrences("mississippi", 'i')).isEqualTo(4);
        assertThat(counter.countCharacterOccurrences("", 'a')).isEqualTo(0);
    }

    // Дополнительные тесты могут быть добавлены здесь
}
