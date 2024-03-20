package ru.liga.dcs.lesson07.task;

import java.util.List;
import java.util.Optional;


/**
 * findFirst
 * filter
 * noneMatch
 * allMatch
 * anyMatch
 */
public class SalesInsights02 {

    /**
     * Находит первую продажу продукта из заданной категории.
     *
     * @param sales    список продаж
     * @param category категория продукта
     * @return первую запись о продаже из категории
     */
    public static Optional<SaleRecord> findFirstSaleInCategory(List<SaleRecord> sales, String category) {
        return Optional.empty();
    }

    /**
     * Проверяет, все ли продажи превышают заданный порог.
     *
     * @param sales     список продаж
     * @param threshold порог суммы продажи
     * @return true, если все продажи превышают порог
     */
    public static boolean areAllSalesAboveThreshold(List<SaleRecord> sales, double threshold) {
        return false;
    }

    /**
     * Проверяет, есть ли хотя бы одна продажа в заданной категории.
     *
     * @param sales    список продаж
     * @param category категория продукта
     * @return true, если есть хотя бы одна продажа в категории
     */
    public static boolean isAnySaleInCategory(List<SaleRecord> sales, String category) {
        return false;
    }

    /**
     * Проверяет, отсутствуют ли продажи продуктов с заданной максимальной суммой.
     *
     * @param sales     список продаж
     * @param maxAmount максимальная сумма продажи
     * @return true, если нет продаж с данной максимальной суммой
     */
    public static boolean areNoSalesWithMaxAmount(List<SaleRecord> sales, double maxAmount) {
        return false;
    }
}
