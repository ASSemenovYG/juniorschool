package ru.liga.dcs.lesson05;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Тесты для класса PasswordGenerator.
 */
public class PasswordGeneratorTest {

    private final PasswordGenerator05 generator = new PasswordGenerator05();

    @Test
    public void testGenerateStrongPassword_ValidLength() {
        String password = generator.generateStrongPassword(10);
        assertThat(password).hasSize(10);
        assertThat(generator.isPasswordStrong(password)).isTrue();
    }

    /**
     * Тест проверки, что сгенерированный пароль соответствует требованиям сложности.
     */
    @Test
    public void testGenerateStrongPassword_IsStrong() {
        for (int i = 0; i < 10; i++) { // Генерация и проверка нескольких паролей
            String password = generator.generateStrongPassword(12);
            assertThat(generator.isPasswordStrong(password)).as("Generated password should be strong: %s", password).isTrue();
        }
    }

    /**
     * Тест проверки сложности пароля.
     */
    @Test
    public void testIsPasswordStrong() {
        assertThat(generator.isPasswordStrong("A1b!2cde")).isTrue();
        assertThat(generator.isPasswordStrong("abc")).isFalse();
        assertThat(generator.isPasswordStrong("12345678")).isFalse();
        assertThat(generator.isPasswordStrong("ABCDEFGH")).isFalse();
        assertThat(generator.isPasswordStrong("abcdefgh")).isFalse();
        assertThat(generator.isPasswordStrong("abcdEFGH1")).isFalse(); // Исправленный тест: теперь ожидается false
        assertThat(generator.isPasswordStrong("abcdEFG!1")).isTrue();  // Добавлен пример правильного сложного пароля
    }

    /**
     * Тест исключения при генерации пароля недостаточной длины.
     */
    @Test
    public void testGenerateStrongPasswordWithInvalidLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            generator.generateStrongPassword(5);
        });
    }
}
