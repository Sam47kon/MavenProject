package GrandTasks;

import org.junit.jupiter.api.Test;

import static GrandTasks.Task4v2.getAverage;
import static org.junit.jupiter.api.Assertions.*;

class Task4v2Test {

    @Test
    void average() {
        int[] numbers = {6, 8, 9, 43, 3};
        assertEquals(13.8, getAverage(numbers));
    }
}