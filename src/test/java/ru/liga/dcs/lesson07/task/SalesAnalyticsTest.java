package ru.liga.dcs.lesson07.task;

import org.junit.Before;
import org.junit.Test;
import org.assertj.core.api.Assertions;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SalesAnalyticsTest {

    private List<SaleRecord> sales;

    @Before
    public void setUp() {
        sales = Arrays.asList(
            new SaleRecord("Laptop", 1200.00, "Electronics"),
            new SaleRecord("Smartphone", 800.00, "Electronics"),
            new SaleRecord("Coffee Maker", 150.00, "Home Appliances"),
            new SaleRecord("Blender", 100.00, "Home Appliances"),
            new SaleRecord("Headphones", 50.00, "Electronics")
        );
    }

    @Test
    public void testCountSalesByCategory() {
        long electronicsSalesCount = SalesAnalytics04.countSalesByCategory(sales, "Electronics");
        Assertions.assertThat(electronicsSalesCount).isEqualTo(3);

        long homeAppliancesSalesCount = SalesAnalytics04.countSalesByCategory(sales, "Home Appliances");
        Assertions.assertThat(homeAppliancesSalesCount).isEqualTo(2);
    }

    @Test
    public void testGetMaxSaleAmountInCategory() {
        Optional<Double> maxElectronicsSale = SalesAnalytics04.getMaxSaleAmountInCategory(sales, "Electronics");
        Assertions.assertThat(maxElectronicsSale).contains(1200.00);

        Optional<Double> maxHomeAppliancesSale = SalesAnalytics04.getMaxSaleAmountInCategory(sales, "Home Appliances");
        Assertions.assertThat(maxHomeAppliancesSale).contains(150.00);
    }

    @Test
    public void testGetMinSaleAmountAboveThreshold() {
        Optional<Double> minSaleAbove500 = SalesAnalytics04.getMinSaleAmountAboveThreshold(sales, 500.00);
        Assertions.assertThat(minSaleAbove500).contains(800.00);

        Optional<Double> minSaleAbove1200 = SalesAnalytics04.getMinSaleAmountAboveThreshold(sales, 1200.00);
        Assertions.assertThat(minSaleAbove1200).isNotPresent();
    }
}
