package ru.liga.dcs.lesson8;

/**
 * Класс LevenshteinCalculator предоставляет функцию для вычисления расстояния Левенштейна.
 * Расстояние Левенштейна - это минимальное количество односимвольных изменений (вставки, удаление, замена),
 * необходимых для преобразования одной строки в другую. Этот класс предоставляет статический метод
 * для вычисления этого расстояния для двух строк.
 */
public class LevenshteinCalculator04 {

    /**
     * Вычисляет расстояние Левенштейна между двумя строками.
     * Алгоритм использует динамическое программирование для минимизации вычислительной сложности,
     * храня результаты в двумерном массиве.
     *
     * @param str1 Первая строка. Не может быть null.
     * @param str2 Вторая строка. Не может быть null.
     * @return Расстояние Левенштейна между str1 и str2.
     * @throws IllegalArgumentException если одна из строк null.
     */
    public static int calculateDistance(String str1, String str2) {
        if (str1 == null || str2 == null) {
            throw new IllegalArgumentException("Strings must not be null");
        }

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
                            dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1));
                }
            }
        }

        return dp[str1.length()][str2.length()];
    }
}
