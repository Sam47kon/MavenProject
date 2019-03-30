package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task35Test {

    @Test
    void testGetSquaresOfPositiveIntegersLessThanTheValue() {
        Assertions.assertArrayEquals(new int[]{1, 4, 9, 16, 25, 36, 49}, new Task35().getSquaresOfPositiveIntegersLessThanTheValue(50));
    }
}