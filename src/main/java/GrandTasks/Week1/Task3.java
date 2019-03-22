package GrandTasks.Week1;

import java.util.Scanner;

// Сумма двух чисел
public class Task3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите 2 числа: ");
        int sum = new Task3().getSum(reader.nextInt(), reader.nextInt());
        System.out.println("Сумма чисел: " + sum);
    }

    int getSum(int a, int b) {
        return a + b;
    }
}
