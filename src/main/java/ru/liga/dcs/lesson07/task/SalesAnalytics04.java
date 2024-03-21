package ru.liga.dcs.lesson07.task;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Stream#count, Stream#max and Stream#min
 */
public class SalesAnalytics04 {

    /**
     * Подсчитывает количество продаж продуктов из заданной категории.
     *
     * @param sales    список продаж
     * @param category категория продукта
     * @return количество продаж в данной категории
     */
    public static long countSalesByCategory(List<SaleRecord> sales, String category) {
        return sales.stream()
                .filter(saleRecord -> Objects.equals(saleRecord.getCategory(), category))
                .count();
    }

    /**
     * Находит максимальную сумму продажи среди продуктов заданной категории.
     *
     * @param sales    список продаж
     * @param category категория продукта
     * @return максимальная сумма продажи в категории
     */
    public static Optional<Double> getMaxSaleAmountInCategory(List<SaleRecord> sales, String category) {
        return sales.stream()
                .filter(saleRecord -> Objects.equals(saleRecord.getCategory(), category))
                .map(SaleRecord::getAmount)
                .max(Comparator.naturalOrder());
    }

    /**
     * Находит минимальную сумму продажи среди продуктов, превышающих заданный порог.
     *
     * @param sales     список продаж
     * @param threshold минимальная сумма продажи
     * @return минимальная сумма продажи выше порога
     */
    public static Optional<Double> getMinSaleAmountAboveThreshold(List<SaleRecord> sales, double threshold) {
        return sales.stream()
                .map(SaleRecord::getAmount)
                .filter(amount -> amount > threshold)
                .min(Comparator.naturalOrder());
    }
}
