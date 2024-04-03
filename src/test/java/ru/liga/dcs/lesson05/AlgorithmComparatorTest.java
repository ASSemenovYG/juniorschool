package ru.liga.dcs.lesson05;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AlgorithmComparatorTest {
    class LinearSearchAlgorithm extends Algorithm {
        private final int[] data;
        private final int key;

        public LinearSearchAlgorithm(String name, int[] data, int key) {
            super(name);
            this.data = data;
            this.key = key;
        }

        @Override
        public void run() {
            for (int value : data) {
                if (value == key) {
                    break;
                }
            }
        }
    }

    class BinarySearchAlgorithm extends Algorithm {
        private final int[] data;
        private final int key;

        public BinarySearchAlgorithm(String name, int[] data, int key) {
            super(name);
            this.data = data;
            this.key = key;
        }

        @Override
        public void run() {
            int low = 0;
            int high = data.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (data[mid] < key) {
                    low = mid + 1;
                } else if (data[mid] > key) {
                    high = mid - 1;
                } else {
                    break; // key found
                }
            }
        }
    }

    @Test
    public void compareLinearAndBinarySearchPerformance() {
        int[] testData = new int[10000];
        for (int i = 0; i < testData.length; i++) {
            testData[i] = i;
        }
        int key = 9999; // значение для поиска

        Algorithm linearSearch = new LinearSearchAlgorithm("LinearSearch", testData, key);
        Algorithm binarySearch = new BinarySearchAlgorithm("BinarySearch", testData, key);

        List<Algorithm> algorithms = Arrays.asList(linearSearch, binarySearch);
        Map<String, Long> results = AlgorithmComparator07.compare(algorithms);
        System.out.println(results);
        // Проверяем, что бинарный поиск быстрее линейного
        assertThat(results.get("BinarySearch")).isLessThan(results.get("LinearSearch"));
    }
}
