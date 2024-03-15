package ru.liga.dcs.lesson06;

public class BmiCalculator05 {
    private static final int BMI_HEIGHT_POW_VALUE = 2;

    /**
     * Метод для расчета индекса массы тела (ИМТ) по данным пациента.
     * ИМТ = m/h^2
     * m - масса тела в кг
     * h - высота в метрах
     *
     * @param patient объект пациента
     * @return значение ИМТ
     */
    public double calculateBMI(Patient patient) {
        return patient.getWeight() / Math.pow(patient.getHeight(), BMI_HEIGHT_POW_VALUE);
    }
}
