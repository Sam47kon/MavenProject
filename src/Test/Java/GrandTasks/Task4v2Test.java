package GrandTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task4v2Test extends Task4v2 {

    @Test
    void average() {
        int[] numbers = {6, 8, 9, 43, 3};
        assertEquals(13.8, Average(numbers));
    }
}