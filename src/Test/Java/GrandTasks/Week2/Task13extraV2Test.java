package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task13extraV2Test {


    @Test
    void testSelectionSort() {
        double[] arr1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        double[] sortArr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assertions.assertArrayEquals(sortArr1, new Task13extraV2().selectionSort(arr1));
        double[] arr2 = {99999, 999.7, 7765, 23754, -3.7, -2, 0, 1, 5};
        double[] sortArr2 = {-3.7, -2, 0, 1, 5, 999.7, 7765, 23754, 99999};
        Assertions.assertArrayEquals(sortArr2, new Task13extraV2().selectionSort(arr2));
    }
}