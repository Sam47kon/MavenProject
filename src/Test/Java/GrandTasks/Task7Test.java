package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task7Test {

    @Test
    void factorial() {
        int number = 7;
        Assertions.assertEquals(5040, new Task7().getFactorial(number));
    }
}