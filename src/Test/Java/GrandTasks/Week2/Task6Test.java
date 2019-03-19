package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task6Test {

    @Test
    void getGcdTest() {
        int number1 = 3456;
        int number2 = 369;
        Assertions.assertEquals(9, new Task6().getGcd(number1, number2));
    }
}