package GrandTasks;

import java.util.Scanner;

// еще не сделал
public class Task5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = reader.nextInt();
        System.out.println("Введите второе число: ");
        int b = reader.nextInt();
        int c = 0;
        System.out.println("Сложить '+', вычесть '-', умножить '*', поделить '/' ");
        String sign = reader.next();
      //  while (sign == "p" || sign == "-" || sign == "*" || sign == "/") {
            if (sign == "p") {
                c = a + b;
            } else if (sign == "-") {
                c = a - b;
            } else if (sign == "*") {
                c = a * b;
            } else if (sign == "/") {
                c = a / b;
         //   } else System.out.println("Попробуй еще раз.");
        }
        System.out.println(c + sign);
    }
}