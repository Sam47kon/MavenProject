package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {

    @Test
    void testCheckTheEqualityOfNumbers() {
        int a = 5;
        int b = 6;
        Assertions.assertEquals(0, new Task21().checkTheEqualityOfNumbers(a, b));
        a = -3;
        b = 9;
        Assertions.assertEquals(-143, new Task21().checkTheEqualityOfNumbers(a, b));
        a = 0;
        b = 0;
        Assertions.assertEquals(1, new Task21().checkTheEqualityOfNumbers(a, b));
        a = 1;
        b = 0;
        Assertions.assertEquals(0, new Task21().checkTheEqualityOfNumbers(a, b));


    }
}