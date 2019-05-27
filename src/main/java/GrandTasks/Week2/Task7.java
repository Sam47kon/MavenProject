package GrandTasks.Week2;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит n! (эн факториал)
public class Task7 {

    public static void main(String[] args) {
        String exit = "";
        while (!exit.equals("qqq")) {
            int inputNumber = (int) new Task5().getDoubleFromInput("Введите число, и я его верну вам его факториал: ");
            BigInteger factorial = new Task7().getFactorial(inputNumber);
            System.out.println(factorial);
            System.out.println("enter qqq to exit");
            exit = new Scanner(System.in).nextLine();
        }
    }

    BigInteger getFactorial(int inputNumber) {
        BigInteger result = BigInteger.ONE; // факториал 0 будет 1, как и должно быть
        for (int i = 1; i <= inputNumber; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
