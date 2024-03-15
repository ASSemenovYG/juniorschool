package ru.liga.dcs.lesson06;

import java.util.*;

public class TransactionAnalyzer03 {
    private static final int NIGHT_TIME_START_HOUR = 22;
    private static final int NIGHT_TIME_END_HOUR = 6;

    /**
     * Определяет подозрительные транзакции из списка на основе заданных критериев.
     * <p>
     * Подозрительная транзакция может быть определена по нескольким критериям:
     * - Сумма транзакции превышает заданный пороговый предел.
     * - Транзакция происходит в необычное время (например, в ночные часы).
     * - Транзакция происходит в стране, отличной от страны проживания клиента.
     * <p>
     * Метод возвращает список транзакций, которые соответствуют хотя бы одному из вышеуказанных критериев.
     *
     * @param transactions    список транзакций для анализа.
     * @param thresholdAmount пороговая сумма, выше которой транзакция считается подозрительной.
     * @return список подозрительных транзакций.
     * @throws NullPointerException если переданный список транзакций равен null.
     */
    public static List<Transaction> detectSuspiciousTransactions(List<Transaction> transactions, double thresholdAmount) {
        List<Transaction> result = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > thresholdAmount || !Objects.equals(t.getClientCountry(), t.getCountry()) || isNightTime(t.getTimestamp())) {
                result.add(t);
            }
        }
        return result;
    }

    private static boolean isNightTime(Date timestamp) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.HOUR_OF_DAY) >= NIGHT_TIME_START_HOUR || calendar.get(Calendar.HOUR_OF_DAY) <= NIGHT_TIME_END_HOUR;
    }

}
