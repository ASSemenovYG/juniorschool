package ru.liga.dcs.lesson06;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

/**
 * Класс для тестирования парсинга данных о пациенте и расчета их индекса массы тела.
 */
public class PatientAndBMITest {

    /**
     * Тест проверяет корректность парсинга строки с данными о пациенте.
     */
    @Test
    public void testParsePatientData() {
        String patientDataString = "Имя:Иван;Возраст:35;Вес:80;Рост:1.75";
        PatientParser05 patientParser = new PatientParser05();

        Patient patient = patientParser.parsePatientData(patientDataString);

        assertThat(patient.getName()).isEqualTo("Иван");
        assertThat(patient.getAge()).isEqualTo(35);
        assertThat(patient.getWeight()).isEqualTo(80);
        assertThat(patient.getHeight()).isEqualTo(1.75);
    }

    /**
     * Тест проверяет корректность расчета ИМТ для пациента.
     */
    @Test
    public void testCalculateBMI() {
        Patient patient = new Patient("Иван", 35, 80, 1.75);
        BmiCalculator05 bmiCalculator = new BmiCalculator05();

        double bmi = bmiCalculator.calculateBMI(patient);

        assertThat(bmi).isEqualTo(26.12, offset(0.01));
    }

    /**
     * Тест проверяет, что ИМТ пациента находится в заданном диапазоне.
     */
    @Test
    public void testBMIRange() {
        Patient patient = new Patient("Мария", 40, 65, 1.65);
        BmiCalculator05 bmiCalculator = new BmiCalculator05();

        double bmi = bmiCalculator.calculateBMI(patient);

        assertThat(bmi).isBetween(23.86, 24.24);
    }

    @Test
    public void testParseAndCalculateBMI() {
        String patientDataString = "Имя:Иван;Возраст:35;Вес:80;Рост:1.75";
        PatientParser05 patientParser = new PatientParser05();
        BmiCalculator05 bmiCalculator = new BmiCalculator05();

        Patient patient = patientParser.parsePatientData(patientDataString);
        double bmi = bmiCalculator.calculateBMI(patient);

        // Ожидаемый ИМТ Ивана равен 26.12 (с округлением до двух знаков)
        assertThat(bmi).isEqualTo(26.12, offset(0.01));
    }

}
