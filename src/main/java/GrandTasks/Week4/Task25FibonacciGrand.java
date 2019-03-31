package GrandTasks.Week4;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task25FibonacciGrand {


    public static void main(String[] args) {
        while (true) {    // для того чтобы не запускать каждый раз
            System.out.print("Введите порядковый номер элемента чисел Фибоначчи, который хотите увидеть: ");
            int inputNum = new Scanner(System.in).nextInt();

            long startTime = System.nanoTime();
            BigInteger fibonacci = getFibonacci(inputNum);
            System.out.println("Время: " + (System.nanoTime() - startTime) / 1000000 + "ms");
            System.out.println("Ваше " + inputNum + " число Фибоначчи: " + fibonacci);
        }
    }

    private static BigInteger getFibonacci(int inputNum) {
        BigInteger one = BigInteger.ZERO;
        BigInteger two = BigInteger.ONE;
        for (int i = 2; i <= inputNum; i++) {
            BigInteger tmp = one;
            one = one.add(two);
            two = tmp;

        }
        return one;
    }
}

