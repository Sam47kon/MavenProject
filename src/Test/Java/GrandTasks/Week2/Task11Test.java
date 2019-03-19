package GrandTasks.Week2;

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

        Assertions.assertFalse(new Task11().isNumberPowerOfTwo2(value1));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo2(value2));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo2(value3));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo2(value4));
        Assertions.assertFalse(new Task11().isNumberPowerOfTwo2(value5));
        Assertions.assertFalse(new Task11().isNumberPowerOfTwo2(value6));

        Assertions.assertFalse(new Task11().isNumberPowerOfTwo1(value1));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo1(value2));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo1(value3));
        Assertions.assertTrue(new Task11().isNumberPowerOfTwo1(value4));
        Assertions.assertFalse(new Task11().isNumberPowerOfTwo1(value5));
        Assertions.assertFalse(new Task11().isNumberPowerOfTwo1(value6));
    }
}