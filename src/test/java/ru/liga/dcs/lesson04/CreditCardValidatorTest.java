package ru.liga.dcs.lesson04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

public class CreditCardValidatorTest {

    @Test
    public void testIsValidCreditCardNumber_Valid() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("4539578763621486")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_Invalid() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("4539578763621487")).isFalse();
    }

    @Test
    public void testIsValidCreditCardNumber_Empty() {
        Throwable thrown = catchThrowable(() -> CreditCardValidator04.isValidCreditCardNumber(""));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("только цифры");
    }

    @Test
    public void testIsValidCreditCardNumber_Null() {
        Throwable thrown = catchThrowable(() -> CreditCardValidator04.isValidCreditCardNumber(null));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("только цифры");
    }

    @Test
    public void testIsValidCreditCardNumber_ContainsLetters() {
        Throwable thrown = catchThrowable(() -> CreditCardValidator04.isValidCreditCardNumber("4539a578763621486"));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("только цифры");
    }

    @Test
    public void testIsValidCreditCardNumber_SpecialCharacters() {
        Throwable thrown = catchThrowable(() -> CreditCardValidator04.isValidCreditCardNumber("4539-5787-6362-1486"));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class)
                          .hasMessageContaining("только цифры");
    }
    @Test
    public void testIsValidCreditCardNumber_ValidVisa() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("4539578763621486")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidMasterCard() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("5500005555555559")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidAmericanExpress() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("371449635398431")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidDiscover() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("6011111111111117")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidDinersClub() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("30569309025904")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidJCB() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("3530111333300000")).isTrue();
    }


    @Test
    public void testIsValidCreditCardNumber_ValidHabr() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("5062821234567892")).isTrue();
    }

    @Test
    public void testIsValidCreditCardNumber_ValidShortNumber() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("4222222222222")).isTrue(); // Visa 13 цифр
    }

    @Test
    public void testIsValidCreditCardNumber_ValidLongNumber() {
        assertThat(CreditCardValidator04.isValidCreditCardNumber("4012888888881881811881")).isFalse(); // Невалидный, но длинный номер
    }

}
