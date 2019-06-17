package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

class Task25FibonacciTest {

    @Test
    void testGetFibonacciNumb() {
        String valStrExpectedNumber = "668226711200301698374224176558256700160458774333255425461900331623619273605518323137569702870357755802337031006361339094239227806499153841600804020665750176206357";

        Assertions.assertEquals(BigInteger.ZERO, Task25Fibonacci.getFibonacciRecurs(Task25Fibonacci.P, 1)[0][0]);
        Assertions.assertEquals(BigInteger.ONE, Task25Fibonacci.getFibonacciRecurs(Task25Fibonacci.P, 2)[0][0]);
        Assertions.assertEquals(BigInteger.valueOf(34), Task25Fibonacci.getFibonacciRecurs(Task25Fibonacci.P, 10)[0][0]);
        Assertions.assertEquals(new BigInteger(valStrExpectedNumber), Task25Fibonacci.getFibonacciRecurs(Task25Fibonacci.P, 777)[0][0]);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> Task25Fibonacci.getFibonacciRecurs(Task25Fibonacci.P, 0), "Этот текст должен быть, если моя указанная ошибка не выскочила");
    }
}