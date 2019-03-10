package GrandTasks;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// Программа принимает из консоли 2 числа и операцию (+ - / * ^ ), выводит результат
public class Task5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double number1 = reader.nextDouble();

        System.out.println("Введите второе число: ");
        double number2 = reader.nextDouble();
        double result = 0;

        System.out.println("Сложить '+', вычесть '-', умножить '*', поделить '/', возвести в степень '^' ");
        String sign = reader.next();

        Set<String> signs = Set.of("+", "-", "*", "/", "^"); // подключение контейнера
        double getC = new Task5().getC(number1, number2, sign);
        if (signs.contains(sign)) {
            result = getC;
        }
        //System.out.println("Попробуй еще раз.");
        System.out.println(result);
    }

    public double getC(double number1, double number2, String sign) {
        if (Objects.equals(sign, "+")) {
            System.out.print("Сумма чисел: " + number1 + " и " + number2 + " = ");
            return number1 + number2;
        }

        if (Objects.equals(sign, "-")) {
            System.out.print("Разность чисел: " + number1 + " и " + number2 + " = ");
            return number1 - number2;
        }

        if (Objects.equals(sign, "*")) {
            System.out.print("Произведение чисел: " + number1 + " и " + number2 + " = ");
            return number1 * number2;
        }

        if (Objects.equals(sign, "/")) {
            System.out.print("Частное чисел: " + number1 + " и " + number2 + " = ");
            return number1 / number2;
        }
        if (Objects.equals(sign, "^")) {
            System.out.print("Число: " + number1 + " в степени " + number2 + " = ");
            return Math.pow(number1, number2);
        }
        throw new IllegalArgumentException("Неверный знак");
    }
}