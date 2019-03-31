package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task34Test {

    @Test
    void testGetAverageDensity() {
        Assertions.assertEquals(3.125, new Task34().getAverageDensity(new double[]{1000, 2000, 2000}, new double[]{1000, 500, 100}));
    }
}