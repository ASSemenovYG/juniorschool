package ru.liga.dcs.lesson06;

import java.util.HashMap;
import java.util.Map;

public class PatientParser05 {
    private static final String DATA_STRING_NAME_PARAMETER = "Имя";
    private static final String DATA_STRING_AGE_PARAMETER = "Возраст";
    private static final String DATA_STRING_WEIGHT_PARAMETER = "Вес";
    private static final String DATA_STRING_HEIGHT_PARAMETER = "Рост";
    private static final String DATA_STRING_PARAMETERS_DELIMITER = ";";
    private static final String DATA_STRING_PARAMETER_NAME_VALUE_DELIMITER = ":";

    /**
     * Метод для парсинга строки и создания объекта пациента.
     *
     * @param data строка с данными о пациенте в формате "Имя:Иван;Возраст:35;Вес:80;Рост:1.75"
     * @return объект пациента
     */
    public Patient parsePatientData(String data) {
        Map<String, String> patientParametersMap = new HashMap<>();
        for (String patientParameter : data.split(DATA_STRING_PARAMETERS_DELIMITER)) {
            String[] parameter = patientParameter.split(DATA_STRING_PARAMETER_NAME_VALUE_DELIMITER);
            patientParametersMap.put(parameter[0], parameter[1]);
        }
        return new Patient(
                patientParametersMap.get(DATA_STRING_NAME_PARAMETER),
                Integer.parseInt(patientParametersMap.get(DATA_STRING_AGE_PARAMETER)),
                Double.parseDouble(patientParametersMap.get(DATA_STRING_WEIGHT_PARAMETER)),
                Double.parseDouble(patientParametersMap.get(DATA_STRING_HEIGHT_PARAMETER))
        );
    }
}
