package ru.liga.dcs.lesson04;

import ru.liga.dcs.lesson04.domain.Category;
import ru.liga.dcs.lesson04.domain.MarketingImportance;
import ru.liga.dcs.lesson04.domain.Product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * Класс для анализа маркетинговых данных о продуктах в магазине.
 */
public class MarketingAnalyzer05 {

    private final List<Product> products;

    /**
     * Конструктор, создающий анализатор маркетинга на основе списка продуктов.
     *
     * @param products список продуктов
     */
    public MarketingAnalyzer05(List<Product> products) {
        this.products = products;
    }

    /**
     * Вычисляет среднюю цену продуктов в указанной категории.
     *
     * @param category категория продуктов
     * @return средняя цена продуктов в указанной категории
     */
    public double calculateAveragePriceByCategory(Category category) {
        int count = countProductsByCategory(category);

        if (count == 0)
            return 0.0;

        return calculateProductSumByCategory(category) / count;
    }

    /**
     * Находит самый дорогой продукт в указанной категории.
     *
     * @param category категория продуктов
     * @return самый дорогой продукт в указанной категории
     */
    public Product findMostExpensiveProductByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .max(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    /**
     * Находит самый дешевый продукт в указанной категории.
     *
     * @param category категория продуктов
     * @return самый дешевый продукт в указанной категории
     */
    public Product findCheapestProductByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null);
    }

    /**
     * Вычисляет важность каждой категории продуктов в магазине на основе их количества и средней стоимости.
     *
     * @return объект MarketingImportance, содержащий карту важности категорий
     */
    public MarketingImportance calculateCategoryImportance() {
        HashMap<Category, Double> importanceMap = new HashMap<>();
        for (Product product : products) {
            if (!importanceMap.containsKey(product.getCategory())) {
                importanceMap.put(
                        product.getCategory(),
                        countProductsByCategory(product.getCategory()) * calculateAveragePriceByCategory(product.getCategory())
                );
            }
        }
        return new MarketingImportance(importanceMap);
    }

    /**
     * Вычисляет количество продуктов в указанной категории
     *
     * @param category категория продуктов
     * @return количество продуктов в категории
     */
    private int countProductsByCategory(Category category) {
        return (int) products.stream()
                .filter(product -> product.getCategory() == category)
                .count();
    }

    /**
     * Вычисляет сумму цен продуктов в указанной категории
     *
     * @param category категория продуктов
     * @return сумма цен продуктов в категории
     */
    private double calculateProductSumByCategory(Category category) {
        return products.stream()
                .filter(product -> product.getCategory() == category)
                .mapToDouble(Product::getPrice)
                .sum();
    }

}
