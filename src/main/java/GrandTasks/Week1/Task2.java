package GrandTasks.Week1;

import java.util.Scanner;

// Вывод модуля числа
public class Task2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter number");

        int modal = new Task2().getModal(reader.nextInt());
        System.out.println("Модуль числа: " + modal);
    }

    int getModal(int number) {
        if (number < 0) {
            number *= (-1);
        }
        return number;
    }
}