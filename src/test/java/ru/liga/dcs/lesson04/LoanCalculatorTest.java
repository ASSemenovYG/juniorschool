package ru.liga.dcs.lesson04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.within;

import org.junit.jupiter.api.Test;

public class LoanCalculatorTest {

    @Test
    public void testCalculateMonthlyPayment_NormalCase() {
        double monthlyPayment = LoanCalculator02.calculateMonthlyPayment(100000, 0.05, 20);
        assertThat(monthlyPayment).isCloseTo(659.96, within(0.01));
    }

    @Test
    public void testCalculateMonthlyPayment_ZeroInterest() {
        double monthlyPayment = LoanCalculator02.calculateMonthlyPayment(50000, 0, 10);
        assertThat(monthlyPayment).isEqualTo(416.67, within(0.01));
    }

    @Test
    public void testCalculateMonthlyPayment_InvalidPrincipal() {
        Throwable thrown = catchThrowable(() -> LoanCalculator02.calculateMonthlyPayment(-1000, 0.05, 20));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("больше нуля");
    }

    @Test
    public void testCalculateMonthlyPayment_InvalidAnnualRate() {
        Throwable thrown = catchThrowable(() -> LoanCalculator02.calculateMonthlyPayment(1000, -0.05, 20));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("больше нуля");
    }

    @Test
    public void testCalculateMonthlyPayment_InvalidTermInYears() {
        Throwable thrown = catchThrowable(() -> LoanCalculator02.calculateMonthlyPayment(1000, 0.05, -20));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("больше нуля");
    }

    @Test
    public void testCalculateMonthlyPayment_VeryHighInterest() {
        double monthlyPayment = LoanCalculator02.calculateMonthlyPayment(1000, 1, 1); // 100% annual interest
        assertThat(monthlyPayment).isCloseTo(135, within(0.01));
    }

    @Test
    public void testCalculateMonthlyPayment_VeryShortTerm() {
        double monthlyPayment = LoanCalculator02.calculateMonthlyPayment(1000, 0.05, 1); // 1 year term
        assertThat(monthlyPayment).isCloseTo(85.60, within(0.01));
    }

    @Test
    public void testCalculateMonthlyPayment_VeryLongTerm() {
        double monthlyPayment = LoanCalculator02.calculateMonthlyPayment(1000, 0.05, 100);
        // Используйте актуальное вычисленное значение для сравнения
        assertThat(monthlyPayment).isCloseTo(4.195, within(0.01));
    }

}
