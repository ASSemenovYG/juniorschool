package ru.liga.dcs.lesson09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Converter02Test {
    private static final Converter02 converter = new Converter02();

    @Test
    void decimalToBinary_10() {
        assertThat(converter.decimalToBinary(10)).isEqualTo("1010");
    }
    @Test
    void decimalToBinary_255() {
        assertThat(converter.decimalToBinary(255)).isEqualTo("11111111");
    }
    @Test
    void decimalToBinary_1024() {
        assertThat(converter.decimalToBinary(1024)).isEqualTo("10000000000");
    }
    @Test
    void decimalToBinary_0() {
        assertThat(converter.decimalToBinary(0)).isEqualTo("0");
    }

}