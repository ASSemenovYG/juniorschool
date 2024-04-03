package ru.liga.dcs.lesson04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {

    @Test
    public void testConvertCurrency_Normal() {
        BigDecimal result = CurrencyConverter03.convertCurrency(new BigDecimal("100"), new BigDecimal("0.85"));
        assertThat(result).isEqualTo(new BigDecimal("85.00"));
    }

    @Test
    public void testConvertCurrency_HighPrecisionRate() {
        BigDecimal result = CurrencyConverter03.convertCurrency(new BigDecimal("100"), new BigDecimal("0.857634"));
        assertThat(result).isEqualTo(new BigDecimal("85.76"));
    }

    @Test
    public void testConvertCurrency_ZeroAmount() {
        BigDecimal result = CurrencyConverter03.convertCurrency(BigDecimal.ZERO, new BigDecimal("1.5"));
        assertThat(result).isEqualTo(new BigDecimal("0.00"));
    }

    @Test
    public void testConvertCurrency_NullAmount() {
        Throwable thrown = catchThrowable(() -> CurrencyConverter03.convertCurrency(null, new BigDecimal("1.5")));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    public void testConvertCurrency_NullExchangeRate() {
        Throwable thrown = catchThrowable(() -> CurrencyConverter03.convertCurrency(new BigDecimal("100"), null));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testConvertCurrency_ZeroExchangeRate() {
        Throwable thrown = catchThrowable(() -> CurrencyConverter03.convertCurrency(new BigDecimal("100"), BigDecimal.ZERO));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    // Остальные тесты остаются без изменений

    @Test
    public void testConvertCurrency_NegativeAmount() {
        BigDecimal negativeAmount = new BigDecimal("-100");
        Throwable thrown = catchThrowable(() -> CurrencyConverter03.convertCurrency(negativeAmount, new BigDecimal("1.5")));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Сумма не должна быть отрицательной: " + negativeAmount);
    }

    @Test
    public void testConvertCurrency_NegativeExchangeRate() {
        BigDecimal negativeRate = new BigDecimal("-1.5");
        Throwable thrown = catchThrowable(() -> CurrencyConverter03.convertCurrency(new BigDecimal("100"), negativeRate));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Курс обмена должен быть больше нуля: " + negativeRate);
    }

}
