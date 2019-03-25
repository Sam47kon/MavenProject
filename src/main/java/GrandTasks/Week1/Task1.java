package GrandTasks.Week1;

import java.util.Scanner;

// Возведение числа в квадрат
public class Task1 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); //подключение ввода с консоли
        System.out.print("Enter number: ");
        // 1 вариант без записи в переменную
        Task1 value = new Task1();
        System.out.println("Квадрат числа: " + value.getSquare(reader.nextInt()));
        // 2 вариант с записью в переменную
        int square = new Task1().getSquare(reader.nextInt());
        System.out.println("Квадрат числа: " + square);
        System.out.println(value + " " + square); // value отобразиться некоректно
    }

    int getSquare(int num) { //возведение в квадрат, без записи в переменную
        return num * num;
    }
}
