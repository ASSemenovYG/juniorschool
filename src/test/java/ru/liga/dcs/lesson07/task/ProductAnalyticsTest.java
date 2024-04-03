package ru.liga.dcs.lesson07.task;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import java.util.List;

public class ProductAnalyticsTest {

    @Test
    public void testCalculateWeightedRatingSum() {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 4.5, 100),
            new Product("Smartphone", 4.0, 50),
            new Product("Tablet", 3.8, 70)
        );
        double weightedSum = ProductAnalytics06.calculateWeightedRatingSum(products);
        Assertions.assertThat(weightedSum).isEqualTo(4.5 * 100 + 4.0 * 50 + 3.8 * 70);
    }
}
