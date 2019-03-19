package GrandTasks.Week2;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит n! (эн факториал)
public class Task7 {

    public static void main(String[] args) {
        String exit = "";
        while (!exit.equals("qqq")) {
            int inputNumber = (int) new Task5().getNumber("Введите число, и я его верну вам его факториал: ");
            BigInteger factorial = new Task7().getFactorial(inputNumber);
            System.out.println(factorial);
            System.out.println("enter qqq to exit");
            exit = new Scanner(System.in).nextLine();
        }
    }

    public BigInteger getFactorial(int inputNumber) {
        BigInteger factor = BigInteger.valueOf(1); // факториал 0 будет 1, как и должно быть
        BigInteger j;
        for (int i = 1; i <= inputNumber; i++) {
            j = BigInteger.valueOf(i);
            factor = factor.multiply(j);
        }
        return factor;
    }
}
