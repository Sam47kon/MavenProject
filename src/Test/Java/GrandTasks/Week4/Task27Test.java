package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task27Test {

    @Test
    void testIsEven() {
        Assertions.assertTrue(new Task27().isEven(6));
        Assertions.assertFalse(new Task27().isEven(7));
    }

    @Test
    void testIsNotEvent() {
        Assertions.assertFalse(new Task27().isNotEvent(6));
        Assertions.assertTrue(new Task27().isNotEvent(7));
    }
}