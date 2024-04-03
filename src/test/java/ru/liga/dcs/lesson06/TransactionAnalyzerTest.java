package ru.liga.dcs.lesson06;

import org.junit.jupiter.api.Test;
import org.junit.Before;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class TransactionAnalyzerTest {

    private List<Transaction> transactions;
    private static final double THRESHOLD_AMOUNT = 10000.00;
    private Date nightTime;
    private Date dayTime;

    @Before
    public void setup() {
        Calendar calendar = new GregorianCalendar();
        // Устанавливаем время на ночное (например, 2:00 ночи)
        calendar.set(Calendar.HOUR_OF_DAY, 2);
        nightTime = calendar.getTime();
        // Устанавливаем время на дневное (например, 14:00)
        calendar.set(Calendar.HOUR_OF_DAY, 14);
        dayTime = calendar.getTime();

        transactions = Arrays.asList(
            new Transaction(5000.00, dayTime, "USA", "USA"), // Обычная транзакция
            new Transaction(15000.00, dayTime, "USA", "USA"), // Сумма выше порога
            new Transaction(5000.00, nightTime, "USA", "USA"), // Необычное время
            new Transaction(5000.00, dayTime, "France", "USA"), // Разные страны
            new Transaction(15000.00, nightTime, "France", "USA") // Все условия сразу
        );
    }

    @Test
    public void testDetectSuspiciousTransactions_HighAmount() {
        List<Transaction> result = TransactionAnalyzer03.detectSuspiciousTransactions(transactions, THRESHOLD_AMOUNT);
        assertThat(result).contains(transactions.get(1), transactions.get(4));
    }

    @Test
    public void testDetectSuspiciousTransactions_NightTime() {
        List<Transaction> result = TransactionAnalyzer03.detectSuspiciousTransactions(transactions, THRESHOLD_AMOUNT);
        assertThat(result).contains(transactions.get(2), transactions.get(4));
    }

    @Test
    public void testDetectSuspiciousTransactions_DifferentCountries() {
        List<Transaction> result = TransactionAnalyzer03.detectSuspiciousTransactions(transactions, THRESHOLD_AMOUNT);
        assertThat(result).contains(transactions.get(3), transactions.get(4));
    }

    @Test
    public void testDetectSuspiciousTransactions_AllConditions() {
        List<Transaction> result = TransactionAnalyzer03.detectSuspiciousTransactions(transactions, THRESHOLD_AMOUNT);
        assertThat(result).contains(transactions.get(4));
    }

    @Test
    public void testDetectSuspiciousTransactions_NoSuspiciousTransactions() {
        List<Transaction> allNormalTransactions = Arrays.asList(
            new Transaction(5000.00, dayTime, "USA", "USA"),
            new Transaction(8000.00, dayTime, "USA", "USA")
        );
        List<Transaction> result = TransactionAnalyzer03.detectSuspiciousTransactions(allNormalTransactions, THRESHOLD_AMOUNT);
        assertThat(result).isEmpty();
    }

    // Дополнительные тесты могут быть добавлены для проверки разных сценариев
}
