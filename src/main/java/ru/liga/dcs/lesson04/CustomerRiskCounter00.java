package ru.liga.dcs.lesson04;

import ru.liga.dcs.lesson04.domain.Customer00;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс для подсчета количества клиентов по категориям риска.
 */
public class CustomerRiskCounter00 {

    /**
     * Подсчитывает количество клиентов в каждой категории риска.
     *
     * @param customers Список клиентов.
     * @return Map, где ключ - это категория риска, а значение - количество клиентов в этой категории.
     */
    public static Map<String, Integer> countCustomersByRiskCategory(List<Customer00> customers) {
        Map<String, Integer> riskCategoryCount = new HashMap<>();
        for (Customer00 customer : customers) {
            if (riskCategoryCount.isEmpty() || !riskCategoryCount.containsKey(customer.getRiskCategory())) {
                riskCategoryCount.put(customer.getRiskCategory(), 1);
            } else {
                riskCategoryCount.replace(customer.getRiskCategory(), riskCategoryCount.get(customer.getRiskCategory()) + 1);
            }
        }

        return riskCategoryCount;
    }
}
