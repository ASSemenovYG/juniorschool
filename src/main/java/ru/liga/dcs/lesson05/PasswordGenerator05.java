package ru.liga.dcs.lesson05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Класс для генерации и проверки сложности пароля.
 */
public class PasswordGenerator05 {

    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()_+";
    private static final int MINIMUM_LENGTH = 8;
    private static final List<String> CHARACTERS = new ArrayList<>() {
        {
            add(LOWER_CASE);
            add(UPPER_CASE);
            add(DIGITS);
            add(SPECIAL_CHARACTERS);
        }
    };


    /**
     * Генерирует случайный сложный пароль заданной длины.
     *
     * @param length длина генерируемого пароля.
     * @return сгенерированный сложный пароль.
     */
    public String generateStrongPassword(int length) {
        if (length < MINIMUM_LENGTH) {
            throw new IllegalArgumentException("Длина сложного пароля не может быть меньше " + MINIMUM_LENGTH + " ! Запрошенная длина: " + length);
        }

        StringBuilder password = new StringBuilder();
        do {
            for (int i = 0; i < length; i++) {
                password.append(getRandomChar());
            }
        } while (!isPasswordStrong(password.toString()));
        return password.toString();
    }

    /**
     * Проверяет, является ли пароль сложным. Сложный пароль должен быть не менее
     * 8 символов в длину и содержать как минимум одну цифру, одну прописную букву,
     * одну строчную букву и один специальный символ.
     *
     * @param password пароль для проверки
     * @return true, если пароль сложный; иначе false
     */
    public boolean isPasswordStrong(String password) {
        if (password.length() < MINIMUM_LENGTH) {
            return false;
        }

        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (LOWER_CASE.contains(String.valueOf(ch))) {
                hasLower = true;
            } else if (UPPER_CASE.contains(String.valueOf(ch))) {
                hasUpper = true;
            } else if (DIGITS.contains(String.valueOf(ch))) {
                hasDigit = true;
            } else if (SPECIAL_CHARACTERS.contains(String.valueOf(ch))) {
                hasSpecial = true;
            }
        }

        return hasLower && hasUpper && hasDigit && hasSpecial;
    }

    private char getRandomChar() {
        Random r = new Random();
        String characterString = CHARACTERS.get(r.nextInt(CHARACTERS.size()));
        return characterString.charAt(r.nextInt(characterString.length()));
    }
}
