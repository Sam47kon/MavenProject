package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task20Test {

    @Test
    void testGetAngle() {
        double hour = 5;
        double minute = 0;
        double second = 0;
        Assertions.assertEquals(150, new Task20().getAngle(hour, minute, second));
        hour = 12;
        minute = 30;
        second = 0;
        Assertions.assertEquals(15, new Task20().getAngle(hour, minute, second));

    }
}