package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task4v2Test {

    @Test
    void average() {
        int[] numbers = {6, 8, 9, 43, 3};
        Assertions.assertEquals(13.8, new Task4v2().getAverage(numbers));
    }
}