package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task20Test {

    @Test
    void testGetAngle() {
        int hour = 5;
        int minute = 0;
        int second = 0;
        Assertions.assertEquals(150, new Task20().getAngle(hour, minute, second));

        hour = 11;
        minute = 36;
        second = 30;
        Assertions.assertEquals(348.25, new Task20().getAngle(hour, minute, second));

        hour = -999;
        minute = -566;
        second = -954;
        Assertions.assertEquals(287.05, new Task20().getAngle(hour, minute, second));

        hour = 4512;
        minute = 3540;
        second = 450;
        Assertions.assertEquals(0.25, new Task20().getAngle(hour, minute, second));

        hour = 0;
        minute = 0;
        second = 0;
        Assertions.assertEquals(0, new Task20().getAngle(hour, minute, second));

    }
}