package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task5Test {

    @Test
    void result() {
        int number1 = 5;
        int number2 = -2;
        String sign1 = "+";
        String sign2 = "-";
        String sign3 = "/";
        String sign4 = "*";
        String sign5 = "^";
        Assertions.assertEquals(3, new Task5().getC(number1, number2, sign1));
        Assertions.assertEquals(7, new Task5().getC(number1, number2, sign2));
        Assertions.assertEquals(-2.5, new Task5().getC(number1, number2, sign3));
        Assertions.assertEquals(-10, new Task5().getC(number1, number2, sign4));
        Assertions.assertEquals(0.04, new Task5().getC(number1, number2, sign5));
    }

}