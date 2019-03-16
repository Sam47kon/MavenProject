package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task8Test {

    @Test
    void getFibonacciNumbTest() {
        int number0 = 0;
        int number1 = 1;
        int number2 = 2;
        int number3 = 10;
        int number4 = 777;
        long value5 = 7540113804746346429L;
        //int number = new Random().nextInt(300);
        Assertions.assertEquals(0, new Task8().getFibonacciNumb(number0));
        Assertions.assertEquals(0, new Task8().getFibonacciNumb(number1));
        Assertions.assertEquals(1, new Task8().getFibonacciNumb(number2));
        Assertions.assertEquals(55, new Task8().getFibonacciNumb(number3));
        Assertions.assertEquals(value5, new Task8().getFibonacciNumb(number4));
    }
}