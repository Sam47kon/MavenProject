package GrandTasks;

import java.util.Scanner;

public class Task6 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int number1 = reader.nextInt();
        System.out.print("Введите второе число: ");
        int number2 = reader.nextInt();
        System.out.println("НОД для " + number1 + " и " + number2 + " это ");
        int gcd = new Task6().getGcd(number1, number2); //объект + запись пременной
        System.out.println(gcd);
    }

    public int getGcd(int a, int b) {
        int value;
        if (b > a) {
            value = a;
            a = b;
            b = value;
        }
        while (b != 0) {
            value = a % b;
            a = b;
            b = value;
        }
        return a;
    }
}
