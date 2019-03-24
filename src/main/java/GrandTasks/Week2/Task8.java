package GrandTasks.Week2;

import org.openjdk.jmh.annotations.Benchmark;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8 {

    public static void main(String[] args) { // TODO  массив на 2 числа

        System.gc();
        Runtime runtime = Runtime.getRuntime();
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("было памяти: " + memoryBefore);


        Scanner reader = new Scanner(System.in);
        System.out.print("Введите порядковый номер элемента чисел фибоначчи, который хотите увидеть: ");
        int inputNum = reader.nextInt();
        BigInteger indexFibonacci = new Task8().getFibonacciNumb(inputNum);
        System.out.println("Ваше число: " + indexFibonacci);


        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("осталось памяти: " + memoryAfter);

        System.out.println("использовано памяти: " + (memoryAfter - memoryBefore));
        System.gc();
    }

    @Benchmark
    public BigInteger getFibonacciNumb(int index) {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for index 0");
        }
        if (index < 0) {
            throw new NegativeArraySizeException("Порядковый номер не может быть отрицательным");
        }
        if (index == 1) {
            return BigInteger.valueOf(0);
        }
        BigInteger[] numbersOfFibonacci = new BigInteger[2];
        numbersOfFibonacci[0] = BigInteger.ZERO;
        numbersOfFibonacci[1] = BigInteger.ONE;
        for (int i = 0; i < numbersOfFibonacci.length; i++) {
            numbersOfFibonacci[i] = numbersOfFibonacci[i - 1].add(numbersOfFibonacci[i - 2]);
        }
        return numbersOfFibonacci[index - 1];
    }


}