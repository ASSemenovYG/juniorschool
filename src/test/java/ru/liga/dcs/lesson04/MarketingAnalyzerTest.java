package ru.liga.dcs.lesson04;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import ru.liga.dcs.lesson04.domain.Category;
import ru.liga.dcs.lesson04.domain.MarketingImportance;
import ru.liga.dcs.lesson04.domain.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarketingAnalyzerTest {

    private MarketingAnalyzer05 analyzer;
    private Product product1;
    private Product product2;
    private Product product3;
    private Product product4;

    @Before
    public void setUp() {
        product1 = new Product("Product1", Category.ELECTRONICS, 100.0);
        product2 = new Product("Product2", Category.ELECTRONICS, 200.0);
        product3 = new Product("Product3", Category.GROCERIES, 50.0);
        product4 = new Product("Product4", Category.GROCERIES, 70.0);
        List<Product> products = Arrays.asList(product1, product2, product3, product4);
        analyzer = new MarketingAnalyzer05(products);
    }

    @Test
    public void testCalculateAveragePriceByCategory() {
        assertThat(analyzer.calculateAveragePriceByCategory(Category.ELECTRONICS)).isEqualTo(150.0);
        assertThat(analyzer.calculateAveragePriceByCategory(Category.GROCERIES)).isEqualTo(60.0);
        assertThat(analyzer.calculateAveragePriceByCategory(Category.CLOTHING)).isEqualTo(0.0);
    }

    @Test
    public void testFindMostExpensiveProductByCategory() {
        assertThat(analyzer.findMostExpensiveProductByCategory(Category.ELECTRONICS)).isEqualToComparingFieldByField(product2);
        assertThat(analyzer.findMostExpensiveProductByCategory(Category.GROCERIES)).isEqualToComparingFieldByField(product4);
        assertThat(analyzer.findMostExpensiveProductByCategory(Category.CLOTHING)).isNull();
    }

    @Test
    public void testFindCheapestProductByCategory() {
        assertThat(analyzer.findCheapestProductByCategory(Category.ELECTRONICS)).isEqualToComparingFieldByField(product1);
        assertThat(analyzer.findCheapestProductByCategory(Category.GROCERIES)).isEqualToComparingFieldByField(product3);
        assertThat(analyzer.findCheapestProductByCategory(Category.CLOTHING)).isNull();
    }

    @Test
    public void testCalculateCategoryImportance() {
        MarketingImportance importance = analyzer.calculateCategoryImportance();
        assertThat(importance.getImportanceMap()).containsEntry(Category.ELECTRONICS, 300.0); // Исправлено на правильное значение
        assertThat(importance.getImportanceMap()).containsEntry(Category.GROCERIES, 120.0);
    }

    @Test
    public void testEmptyProductList() {
        MarketingAnalyzer05 emptyAnalyzer = new MarketingAnalyzer05(new ArrayList<>());
        assertThat(emptyAnalyzer.calculateAveragePriceByCategory(Category.ELECTRONICS)).isEqualTo(0.0);
        assertThat(emptyAnalyzer.findMostExpensiveProductByCategory(Category.ELECTRONICS)).isNull();
        assertThat(emptyAnalyzer.findCheapestProductByCategory(Category.ELECTRONICS)).isNull();
        assertThat(emptyAnalyzer.calculateCategoryImportance().getImportanceMap()).isEmpty();
    }

    @Test
    public void testCalculateCategoryImportanceWithMoreProducts() {
        Product p1 = new Product("P1", Category.ELECTRONICS, 120.0);
        Product p2 = new Product("P2", Category.ELECTRONICS, 180.0);
        Product p3 = new Product("P3", Category.GROCERIES, 60.0);
        Product p4 = new Product("P4", Category.GROCERIES, 40.0);
        Product p5 = new Product("P5", Category.CLOTHING, 200.0);
        Product p6 = new Product("P6", Category.CLOTHING, 150.0);

        List<Product> moreProducts = Arrays.asList(p1, p2, p3, p4, p5, p6);
        MarketingAnalyzer05 moreProductsAnalyzer = new MarketingAnalyzer05(moreProducts);

        MarketingImportance importance = moreProductsAnalyzer.calculateCategoryImportance();

        // Предположим, что медианные цены для категорий рассчитаны верно
        double expectedImportanceElectronics = 2 * ((120.0 + 180.0) / 2); // Количество продуктов * медианная цена
        double expectedImportanceGroceries = 2 * ((60.0 + 40.0) / 2);
        double expectedImportanceClothing = 2 * ((200.0 + 150.0) / 2);

        assertThat(importance.getImportanceMap()).containsEntry(Category.ELECTRONICS, expectedImportanceElectronics);
        assertThat(importance.getImportanceMap()).containsEntry(Category.GROCERIES, expectedImportanceGroceries);
        assertThat(importance.getImportanceMap()).containsEntry(Category.CLOTHING, expectedImportanceClothing);
    }
}