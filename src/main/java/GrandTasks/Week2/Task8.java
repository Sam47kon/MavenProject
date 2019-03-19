package GrandTasks.Week2;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите порядковый номер элемента чисел фибоначчи, который хотите увидеть: ");
        int inputNum = reader.nextInt();

        BigInteger indexFibonacci = new Task8().getFibonacciNumb(inputNum);
        System.out.print("Ваше число: " + indexFibonacci);
    }

    public BigInteger getFibonacciNumb(int length) {
        if (length == 0) {
            throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for length 0");
        }
        if (length < 0) {
            throw new NegativeArraySizeException("Порядковый номер не может быть отрицательным");
        }
        if (length == 1) {
            return BigInteger.valueOf(0);
        }
        BigInteger[] numbersOfFibonacci = new BigInteger[length];
        numbersOfFibonacci[0] = BigInteger.ZERO;
        numbersOfFibonacci[1] = BigInteger.ONE;
        for (int i = 2; i < numbersOfFibonacci.length; i++) {
            numbersOfFibonacci[i] = numbersOfFibonacci[i - 1].add(numbersOfFibonacci[i - 2]);
        }
        return numbersOfFibonacci[length - 1];
    }
}