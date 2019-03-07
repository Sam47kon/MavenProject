package GrandTasks;

import java.util.Scanner;

// Вывод модуля числа
public class Task2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number");
        int a = reader.nextInt();

        System.out.println("Модуль числа: " + Modal(a));
        System.out.println("Yor number: " + a);
    }

    static int Modal(int number) {
        return Math.abs(number);
    }
}