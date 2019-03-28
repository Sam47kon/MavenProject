package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task28GYRv2Test {

    @Test
    void testWhatColorGlows() {
        Assertions.assertEquals("GREEN", new Task28GYRv2().whatColorGlows(1));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(2));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(3));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(4));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(5));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(6));

        Assertions.assertEquals("GREEN", new Task28GYRv2().whatColorGlows(7));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(8));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(9));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(10));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(11));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(12));

        Assertions.assertEquals("GREEN", new Task28GYRv2().whatColorGlows(13));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(14));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(15));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(16));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(17));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(18));

        Assertions.assertEquals("GREEN", new Task28GYRv2().whatColorGlows(19));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(20));
        Assertions.assertEquals("YELLOW", new Task28GYRv2().whatColorGlows(21));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(22));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(23));
        Assertions.assertEquals("RED", new Task28GYRv2().whatColorGlows(24));
    }
}