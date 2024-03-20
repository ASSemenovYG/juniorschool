package ru.liga.dcs.lesson07.task;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class SalesInsightsTest {

    private static final List<SaleRecord> SALES = Arrays.asList(
        new SaleRecord("Телевизор", 1000.0,"Электроника" ),
        new SaleRecord("Платье", 500.0, "Одежда"),
        new SaleRecord("Смартфон", 2000.0, "Электроника"),
        new SaleRecord("Молоко", 1500.0, "Продукты")
    );

    @Test
    public void testFindFirstSaleInCategory() {
        Optional<SaleRecord> sale = SalesInsights02.findFirstSaleInCategory(SALES, "Электроника");

        assertThat(sale).isPresent();
        assertThat(sale.get().getCategory()).isEqualTo("Электроника");
        assertThat(sale.get().getAmount()).isEqualTo(1000.0);
        assertThat(sale.get().getProduct()).isEqualTo("Телевизор");
    }

    @Test
    public void testFindFirstSaleInCategory_EmptyList() {
        Optional<SaleRecord> sale = SalesInsights02.findFirstSaleInCategory(Collections.emptyList(), "Электроника");

        assertThat(sale).isEmpty();
    }

    @Test
    public void testAreAllSalesAboveThreshold() {
        boolean allAboveThreshold = SalesInsights02.areAllSalesAboveThreshold(SALES, 1000.0);

        assertThat(allAboveThreshold).isFalse();
    }

    @Test
    public void testAreAllSalesAboveThreshold_OneBelow() {
        List<SaleRecord> sales = Arrays.asList(
            new SaleRecord("Электроника", 1000.0, "Телевизор"),
            new SaleRecord("Одежда", 500.0, "Платье"),
            new SaleRecord("Электроника", 2000.0, "Смартфон"),
            new SaleRecord("Продукты", 900.0, "Молоко")
        );

        boolean allAboveThreshold = SalesInsights02.areAllSalesAboveThreshold(sales, 1000.0);

        assertThat(allAboveThreshold).isFalse();
    }

    @Test
    public void testIsAnySaleInCategory() {
        boolean isAnySaleInCategory = SalesInsights02.isAnySaleInCategory(SALES, "Электроника");

        assertThat(isAnySaleInCategory).isTrue();
    }

    @Test
    public void testIsAnySaleInCategory_EmptyList() {
        boolean isAnySaleInCategory = SalesInsights02.isAnySaleInCategory(Collections.emptyList(), "Электроника");

        assertThat(isAnySaleInCategory).isFalse();
    }

    @Test
    public void testAreNoSalesWithMaxAmount() {
        boolean areNoSalesWithMaxAmount = SalesInsights02.areNoSalesWithMaxAmount(SALES, 2000.0);

        assertThat(areNoSalesWithMaxAmount).isFalse();
    }

    @Test
    public void testAreNoSalesWithMaxAmount_EmptyList() {
        boolean areNoSalesWithMaxAmount = SalesInsights02.areNoSalesWithMaxAmount(Collections.emptyList(), 2000.0);

        assertThat(areNoSalesWithMaxAmount).isTrue();
    }
}
