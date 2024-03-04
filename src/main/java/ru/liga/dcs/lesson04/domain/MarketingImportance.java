package ru.liga.dcs.lesson04.domain;

import java.util.Map;

/**
 * Класс, представляющий важность категорий продуктов для маркетингового анализа.
 * Важность категории определяется как произведение количества продуктов в категории и медианной стоимости этих продуктов.
 * Чем больше количество продуктов в категории и чем выше их средняя стоимость (медианная), тем выше их важность для магазина.
 */
public class MarketingImportance {
    private final Map<Category, Double> importanceMap;

    /**
     * Создает новый экземпляр класса с заданной картой важности категорий.
     *
     * @param importanceMap карта важности категорий, где ключ - категория, значение - коэффициент важности
     */
    public MarketingImportance(Map<Category, Double> importanceMap) {
        this.importanceMap = importanceMap;
    }

    /**
     * Получает карту важности категорий.
     *
     * @return карта важности категорий, где ключ - категория, значение - коэффициент важности
     */
    public Map<Category, Double> getImportanceMap() {
        return importanceMap;
    }
}
