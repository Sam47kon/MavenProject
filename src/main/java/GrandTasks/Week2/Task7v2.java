package GrandTasks.Week2;

import java.math.BigInteger;

//Программа принимает число n с клавиатуры, выводит n! (эн факториал)
public class Task7v2 {

    public static void main(String[] args) {

        int inputNumber = (int) new Task5().getNumber("Введите число, и я его верну вам его факториал: ");
        BigInteger factorial = new Task7v2().getFactorial(inputNumber);
        System.out.println(factorial);
    }

    public BigInteger getFactorial(int inputNumber) {   // TODO то то здесь не так
        long factor = 1; // факториал 0 будет 1, как и должно быть
        for (long i = 1; i <= inputNumber; i++) {
            factor = i * factor;
        }
        return BigInteger.valueOf(factor);
    }
}
