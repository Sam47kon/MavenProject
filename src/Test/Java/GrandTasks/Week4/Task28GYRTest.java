package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task28GYRTest {


    @Test
    void testWhatColorGlows() {
        Assertions.assertEquals("Green", new Task28GYR().whatColorGlows(1));
        Assertions.assertEquals("Yellow", new Task28GYR().whatColorGlows(2));
        Assertions.assertEquals("Red", new Task28GYR().whatColorGlows(3));
        Assertions.assertEquals("Green", new Task28GYR().whatColorGlows(4));
        Assertions.assertEquals("Yellow", new Task28GYR().whatColorGlows(5));
        Assertions.assertEquals("Red", new Task28GYR().whatColorGlows(6));
        Assertions.assertEquals("Green", new Task28GYR().whatColorGlows(7));
        Assertions.assertEquals("Yellow", new Task28GYR().whatColorGlows(8));
        Assertions.assertEquals("Red", new Task28GYR().whatColorGlows(9));
        Assertions.assertEquals("Green", new Task28GYR().whatColorGlows(10));
        Assertions.assertEquals("Yellow", new Task28GYR().whatColorGlows(11));
        Assertions.assertEquals("Red", new Task28GYR().whatColorGlows(12));
        Assertions.assertEquals("Green", new Task28GYR().whatColorGlows(13));
    }
}