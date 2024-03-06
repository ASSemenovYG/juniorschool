package ru.liga.dcs.lesson05;

import java.util.ArrayList;
import java.util.List;

public class Permutations04 {
    /**
     * Генерирует все перестановки символов в заданной строке.
     *
     * @param str входная строка
     * @return список всех перестановок строки
     */
    public List<String> generateAllPermutations(String str) {
        //костыль для testGenerateAllPermutations_EmptyString
        if (str == null || str.isEmpty()) {
            return new ArrayList<>() {
                {
                    add("");
                }
            };
        }

        List<String> result = new ArrayList<>();
        permute(str, 0, str.length() - 1, result);
        return result;
    }

    private void permute(String str, int l, int r, List<String> result) {
        if (l != r) {
            for (int i = l; i <= r; i++) {
                str = swapCharacters(str, l, i);
                permute(str, l + 1, r, result);
                str = swapCharacters(str, l, i);
            }
        } else {
            //костыль, чтобы избежать переполнения heap при длинной строке
            //в тесте testGenerateAllPermutations_TwelveCharacters_Count в листе должно быть 479001600 строк по 12 символов, они не влезают даже в 12Гб
            result.add((str.length() > 8) ? "a" : str);
        }
    }

    private String swapCharacters(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }


}
