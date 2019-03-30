package GrandTasks.Week4;

import java.math.BigInteger;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task25Fibonacci {

    static final BigInteger[][] P = {{BigInteger.ZERO, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ONE}};    // первые 3 числа фибоначчи, которые нам нужны и только

    public static void main(String[] args) {
        //while (true) {    // для того чтобы не запускать каждый раз
        System.out.print("Введите порядковый номер элемента чисел Фибоначчи, который хотите увидеть: ");
        int inputNum = new Scanner(System.in).nextInt();
        BigInteger[][] indexFibonacci1 = new Task25Fibonacci().getFibonacciNumb(P, inputNum);
        System.out.println("Ваше " + inputNum + " число Фибоначчи: " + indexFibonacci1[0][0]);
        //}
    }


    private BigInteger[][] multiplication(BigInteger[][] a, BigInteger[][] b) {     // умножение матриц 2х2
        return new BigInteger[][]{
                {a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0])), a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]))},
                {a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[1][0])), a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]))}
        };
    }

    BigInteger[][] getFibonacciNumb(BigInteger[][] p, int index) {
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
            return multiplication(p, getFibonacciNumb(p, index - 1));
        }
        return getFibonacciNumb(getFibonacciNumb(p, index / 2), 2);     // рекурсивно придем к {{0 1}{1 1}}^index
    }
}