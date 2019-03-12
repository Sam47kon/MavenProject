package GrandTasks;

import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите порядковый номер элемента чисел фибоначчи, который хотите увидеть: ");
        int length = reader.nextInt();

        new Task8().getFibonacciNumber(length);
    }

    public void getFibonacciNumber(int length) {
        while (true) {
            if (length > 93) {
                System.out.println("К сожалению такое большое число трудно расчитать, поэтому покажем последнее 93-ое, которое можем расчитать: ");
                length = 93;
            }
            long[] fibonacci = new long[length];
            if (length == 0) {
                System.out.println("Без чисел нам не справиться!");
                break;
            }
            fibonacci[0] = 0;
            if (length == 1) {
                System.out.println("Первое число фибоначчи это 0");
                break;
            }
            fibonacci[1] = 1;
            for (int i = 2; i < fibonacci.length; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            //System.out.println("Последовательность фибоначи:  " + Arrays.toString(fibonacci)); // метод вывода массива в строке
            System.out.print("Ваше число: " + fibonacci[length - 1]);
            break;
        }
    }
}
