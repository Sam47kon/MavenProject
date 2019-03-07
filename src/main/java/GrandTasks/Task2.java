package GrandTasks;

import java.util.Scanner;

// Вывод модуля числа
public class Task2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number");
        int number = reader.nextInt();

        System.out.println("Модуль числа: " + Mod(number));
        System.out.println("Yor number: " + number);
    }

    private static int Mod(int number) {
        return Math.abs(number);
    }
}