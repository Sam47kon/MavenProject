package GrandTasks.Week2;

import GrandTasks.Week2.Task7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task7Test {

    @Test
    void getFactorialTest() {
        int number = 7;
        Assertions.assertEquals(5040, new Task7().getFactorial(number));
    }
}