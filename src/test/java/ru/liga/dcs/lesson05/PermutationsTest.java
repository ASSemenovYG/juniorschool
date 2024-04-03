package ru.liga.dcs.lesson05;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {

    @Test
    public void testGenerateAllPermutations_EmptyString() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("");
        assertThat(permutations).containsExactly("");
    }

    @Test
    public void testGenerateAllPermutations_SingleCharacter() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("a");
        assertThat(permutations).containsExactly("a");
    }

    @Test
    public void testGenerateAllPermutations_ThreeCharacters() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("abc");
        assertThat(permutations).containsExactlyInAnyOrder("abc", "acb", "bac", "bca", "cab", "cba");
    }

    @Test
    public void testGenerateAllPermutations_FourCharacters() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("abcd");
        assertThat(permutations).containsExactlyInAnyOrder("abcd", "abdc", "acbd", "acdb", "adbc", "adcb",
                                                           "bacd", "badc", "bcad", "bcda", "bdac", "bdca",
                                                           "cabd", "cadb", "cbad", "cbda", "cdab", "cdba",
                                                           "dabc", "dacb", "dbac", "dbca", "dcab", "dcba");
    }

    @Test
    public void testGenerateAllPermutations_ElevenCharacters_Count() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("abcdefghijk");
        assertThat(permutations.size()).isEqualTo(39916800);
    }

    @Test
    public void testGenerateAllPermutations_TwelveCharacters_Count() {
        Permutations04 permutationGenerator = new Permutations04();
        List<String> permutations = permutationGenerator.generateAllPermutations("abcdefghijkl");
        assertThat(permutations.size()).isEqualTo(479001600);
    }


}
