package GrandTasks;

import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите порядковый номер элемента чисел фибоначчи, который хотите увидеть: ");
        int length = reader.nextInt();

        long value = new Task8().getFibonacciNumb(length);
        System.out.print("Ваше число: " + value);
    }

    public long getFibonacciNumb(int length) {
        long[] fib1 = new long[93];
        fib1[0] = 0;
        fib1[1] = 1;
        for (int i = 2; i < fib1.length; i++) {
            fib1[i] = fib1[i - 1] + fib1[i - 2];
        }
        if (length > 93) {
            length = 93;
            long[] fib2 = fib1;
            System.out.println("больше 93 не вычисляется");
            return fib2[length - 1];
        }
        if (length == 0) {
            System.out.println("невозможно");
            return fib1[0];
        }
        if (length == 1) {
            return fib1[0];
        }
        return fib1[length];
    }
}