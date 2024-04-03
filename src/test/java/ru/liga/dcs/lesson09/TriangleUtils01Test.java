package ru.liga.dcs.lesson09;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleUtils01Test {

    private static final TriangleUtils01 triangleUtils = new TriangleUtils01();
    @Test
    void canFormTriangle_345_True() {
        assertThat(triangleUtils.canFormTriangle(3, 4, 5)).isTrue();
    }
    @Test
    void canFormTriangle_123_False() {
        assertThat(triangleUtils.canFormTriangle(1, 2, 3)).isFalse();
    }
    @Test
    void canFormTriangle_555_True() {
        assertThat(triangleUtils.canFormTriangle(5, 5, 5)).isTrue();
    }
}