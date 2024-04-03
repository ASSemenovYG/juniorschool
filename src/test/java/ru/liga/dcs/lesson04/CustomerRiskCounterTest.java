package ru.liga.dcs.lesson04;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import ru.liga.dcs.lesson04.domain.Customer00;

public class CustomerRiskCounterTest {

    @Test
    public void testCountCustomersByRiskCategory() {
        List<Customer00> customers = Arrays.asList(
            new Customer00("High"),
            new Customer00("Medium"),
            new Customer00("Low"),
            new Customer00("High"),
            new Customer00("Low")
        );

        Map<String, Integer> riskCategoryCount = CustomerRiskCounter00.countCustomersByRiskCategory(customers);

        assertThat(riskCategoryCount)
            .hasSize(3)
            .containsEntry("High", 2)
            .containsEntry("Medium", 1)
            .containsEntry("Low", 2);
    }

    @Test
    public void testCountCustomersByRiskCategory_EmptyList() {
        List<Customer00> customers = Arrays.asList();
        Map<String, Integer> riskCategoryCount = CustomerRiskCounter00.countCustomersByRiskCategory(customers);
        assertThat(riskCategoryCount).isEmpty();
    }

    @Test
    public void testCountCustomersByRiskCategory_NullList() {
        Throwable thrown = catchThrowable(() -> CustomerRiskCounter00.countCustomersByRiskCategory(null));
        assertThat(thrown).isInstanceOf(NullPointerException.class);
    }
}
