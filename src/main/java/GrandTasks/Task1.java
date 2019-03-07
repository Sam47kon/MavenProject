package GrandTasks;

import java.util.Scanner;

// Возведение числа в квадрат
public class Task1 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in); //подключение ввода с консоли
        System.out.println("Enter number");
        int a = reader.nextInt(); // ввод с консоли в новую переменную

        System.out.println("Your square: " + Square(a));
        System.out.println("Yor number: " + a);
    }

    public static int Square(int number) { //возведение в квадрат, без записи в переменную
        return number * number;
    }
}
