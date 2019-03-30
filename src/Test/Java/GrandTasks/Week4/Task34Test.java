package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task34Test {

    @Test
    void testGetAverageDensity() {
        Assertions.assertEquals(3.125, new Task34().getAverageDensity(5000, 1600));
    }
}