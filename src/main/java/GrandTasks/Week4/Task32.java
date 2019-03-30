package GrandTasks.Week4;

import java.util.Scanner;

// 5.10. Напечатать таблицу перевода 1, 2, ... 20 долларов США в рубли по текущему курсу (значение курса вводится с клавиатуры).
public class Task32 {

    public static void main(String[] args) {
        System.out.println("Введите курс $/\u20bd:");
        double rate = new Scanner(System.in).nextDouble();
        double[] rub = new double[20];
        double[] dollar = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < 20; i++) {
            rub[i] = new Task32().getDollar(rate, dollar[i]);
            System.out.printf("%1$.0f$ = %2$.3f\u20bd\n", dollar[i], rub[i]);
        }
    }

    double getDollar(double dataRate, double dataDollars) {
        return dataRate * dataDollars;
    }
}
