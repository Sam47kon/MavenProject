package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task18Test {

    @Test
    void testReversNumber() {
        int testNumber = 864;
        Assertions.assertEquals(468, new Task18().reversNumber(testNumber));
        testNumber = 987;
        Assertions.assertEquals(789, new Task18().reversNumber(testNumber));
    }
}