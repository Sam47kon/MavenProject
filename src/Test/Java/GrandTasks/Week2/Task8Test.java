package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task8Test {

    @Test
    void getFibonacciNumbTest() {

        int test0 = 0;
        int test1 = 1;
        int testNumber1 = 2;
        int testNumber2 = 10;
        int testNumber4 = 777;
        String valStrExpectedNumber4 = "668226711200301698374224176558256700160458774333255425461900331623619273605518323137569702870357755802337031006361339094239227806499153841600804020665750176206357";

        Assertions.assertEquals(BigInteger.ZERO, new Task8().getFibonacciNumb(test1));
        Assertions.assertEquals(BigInteger.ONE, new Task8().getFibonacciNumb(testNumber1));
        Assertions.assertEquals(BigInteger.valueOf(34), new Task8().getFibonacciNumb(testNumber2));
        Assertions.assertEquals(new BigInteger(valStrExpectedNumber4), new Task8().getFibonacciNumb(testNumber4));
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> new Task8().getFibonacciNumb(test0), "Здесь должен быть текст, если утверждение неверно?");
    }
}