package GrandTasks.Week2;

import GrandTasks.Week2.Task11;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task11Test {

    @Test
    void isNumberPowerOfTwoTest() {
        int value1 = 0;
        int value2 = 1;
        int value3 = 8;
        int value4 = 1024;
        int value5 = -9;
        int value6 = -128;

        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo2(value1));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo2(value2));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo2(value3));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo2(value4));
        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo2(value5));
        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo2(value6));

        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo1(value1));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo1(value2));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo1(value3));
        Assertions.assertEquals(true, new Task11().isNumberPowerOfTwo1(value4));
        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo1(value5));
        Assertions.assertEquals(false, new Task11().isNumberPowerOfTwo1(value6));
    }
}