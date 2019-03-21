package GrandTasks.Week1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task3Test {

    @Test
    void testGetSum() {
        int number1 = 5;
        int number2 = 10;
        Assertions.assertEquals(15, new Task3().getSum(number1, number2));
    }
}