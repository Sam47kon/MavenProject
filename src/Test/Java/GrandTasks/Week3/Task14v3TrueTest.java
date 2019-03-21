package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task14v3TrueTest {

    @Test
    void testFindOutThatItExists() {
        double[] arr1 = {1, 3, 5, 7, 9};
        double numbTest = 3; // index 2
        Assertions.assertEquals(2, new Task14v3True().findOutThatItExists(arr1, numbTest));
        numbTest = 7;  // index 4
        Assertions.assertEquals(4, new Task14v3True().findOutThatItExists(arr1, numbTest));
        double[] arr2 = {-1.8, 301, 235, -7, 0};
        numbTest = 0;
        Assertions.assertEquals(5, new Task14v3True().findOutThatItExists(arr2, numbTest));
        Assertions.assertEquals(-1, new Task14v3True().findOutThatItExists(arr1, numbTest));
    }
}