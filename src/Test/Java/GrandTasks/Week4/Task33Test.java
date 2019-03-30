package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task33Test {

    @Test
    void testGetSum3() {
        Assertions.assertEquals(21, new Task33().getSum3(10, 11));
        Assertions.assertEquals(14, new Task33().getSum3(-1, 5));
        Assertions.assertEquals(-40, new Task33().getSum3(-10, 5));
    }
}