package GrandTasks;

import java.util.Scanner;

public class Task6 {
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

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = reader.nextInt();
        System.out.print("Введите второе число: ");
        int b = reader.nextInt();
        System.out.println("НОД для " + a + " и " + b + " это ");
        int gcd = new Task6().getGcd(a, b); //объект + запись пременной
        //new Task6().getGcd(a, b) // создаю объект
        System.out.println(gcd);


    }


}
