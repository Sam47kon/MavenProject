package GrandTasks;

import java.util.Scanner;

// Сумма двух чисел
public class Task3 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter 1 number");
        int a = reader.nextInt();
        System.out.println("Enter 2 number");
        int b = reader.nextInt();

        System.out.println("Your Sum: " + Sum(a, b));
    }

    public static int Sum(int a, int b) { //возведение в квадрат, без записи в переменную
        return a + b;
    }
}
