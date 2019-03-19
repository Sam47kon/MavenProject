package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task7Test {


    @Test
    void getFactorialTest() { // TODO как протестить?
        int number = 7;
        Assertions.assertEquals(BigInteger.valueOf(5040), new Task7().getFactorial(number));
    }
}