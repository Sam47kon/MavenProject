package GrandTasks.Week4;

import java.math.BigInteger;
import java.util.Scanner;

import static MyStaticMethods.MyMethods.getRuntime;


//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task25Fibonacci {

    static final BigInteger[][] P = {{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};    // первые 3 числа фибоначчи, которые нам нужны и только

    public static void main(String[] args) {
        while (true) {    // для того чтобы не запускать каждый раз
            System.out.print("Введите порядковый номер элемента чисел Фибоначчи, который хотите увидеть: ");
            int inputNum = new Scanner(System.in).nextInt();

            System.out.println("Время: " + getRuntime(() -> getFibonacci(inputNum)) + "ms");
            System.out.println("Время: " + getRuntime(() -> getFibonacciGrand(inputNum)) + "ms");

        }
    }

    private static BigInteger getFibonacciGrand(int inputNum) {
        BigInteger one = BigInteger.ZERO;
        BigInteger two = BigInteger.ONE;
        for (int i = 2; i <= inputNum; i++) {
            BigInteger tmp = one;
            one = one.add(two);
            two = tmp;

        }
        return one;
    }

    private static BigInteger getFibonacci(int index) {
        return getFibonacciRecurs(P, index)[0][0];
    }

    static BigInteger[][] getFibonacciRecurs(BigInteger[][] p, int index) {
        if (index == 0) {
            throw new ArrayIndexOutOfBoundsException("Index 0 out of bounds for index 0");
        }
        if (index < 0) {
            throw new NegativeArraySizeException("Порядковый номер не может быть отрицательным");
        }
        if (index == 1) {
            return p;
        }
        if (index == 2) {
            return multiplication(p, p);
        }
        if (index % 2 == 1) {      // если степень n нечётна, мы поступаем очень просто: перейдём к степени n-1, которая будет уже чётной
            return multiplication(p, getFibonacciRecurs(p, index - 1));
        }
        return getFibonacciRecurs(getFibonacciRecurs(p, index / 2), 2);     // рекурсивно придем к {{0 1}{1 1}}^index
    }

    private static BigInteger[][] multiplication(BigInteger[][] a, BigInteger[][] b) {     // умножение матриц 2х2
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))}
        };
    }
}