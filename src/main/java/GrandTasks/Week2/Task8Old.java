package GrandTasks.Week2;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8Old {

    public static void main(String[] args) {
        System.out.print("Введите порядковый номер элемента чисел Фибоначчи, который хотите увидеть: ");
        int inputNum = new Scanner(System.in).nextInt();
        long startTime = System.nanoTime();
        BigInteger indexFibonacci = new Task8Old().getFibonacciNumb(inputNum);
        System.out.println("Время: " + (System.nanoTime() - startTime) / 1000000 + "ms");
        System.out.println("Ваше " + inputNum + " число Фибоначчи: " + indexFibonacci);
    }

    private BigInteger getFibonacciNumb(int index) {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for index 0");
        }
        if (index < 0) {
            throw new NegativeArraySizeException("Порядковый номер не может быть отрицательным");
        }
        if (index == 1) {
            return BigInteger.valueOf(0);
        }
        BigInteger[] numbersOfFibonacci = new BigInteger[index];
        numbersOfFibonacci[0] = BigInteger.ZERO;
        numbersOfFibonacci[1] = BigInteger.ONE;
        for (int i = 2; i < numbersOfFibonacci.length; i++) {
            numbersOfFibonacci[i] = numbersOfFibonacci[i - 1].add(numbersOfFibonacci[i - 2]);
        }
        return numbersOfFibonacci[index - 1];
    }
}