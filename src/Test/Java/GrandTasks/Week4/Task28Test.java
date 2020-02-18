package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task28Test {
    private final String GREEN = "Green";
    private final String RED = "Red";

    @Test
    void testWhatColorGlows() {
        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(1));
        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(2));
        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(3));
        Assertions.assertEquals(RED, new Task28().whatColorGlows(4));
        Assertions.assertEquals(RED, new Task28().whatColorGlows(5));

        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(6));
        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(7));
        Assertions.assertEquals(GREEN, new Task28().whatColorGlows(8));
        Assertions.assertEquals(RED, new Task28().whatColorGlows(9));
        Assertions.assertEquals(RED, new Task28().whatColorGlows(10));
    }
}