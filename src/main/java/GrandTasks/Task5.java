package GrandTasks;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Task5 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int number1 = reader.nextInt();

        System.out.println("Введите второе число: ");
        int number2 = reader.nextInt();
        int result = 0;

        System.out.println("Сложить '+', вычесть '-', умножить '*', поделить '/' ");
        String sign = reader.next();

        Set<String> signs = Set.of("+", "-", "*", "/", "^"); // подключение контейнера
        int getC = new Task5().getC(number1, number2, sign);
        if (signs.contains(sign)) {
            result = getC;
        }
        //System.out.println("Попробуй еще раз.");
        System.out.println(result);
    }

    private int getC(int number1, int number2, String sign) {
        if (Objects.equals(sign, "+")) {
            return number1 + number2;
        }

        if (Objects.equals(sign, "-")) {
            return number1 - number2;
        }

        if (Objects.equals(sign, "*")) {
            return number1 * number2;
        }

        if (Objects.equals(sign, "/")) {
            return number1 / number2;
        }
        if (Objects.equals(sign, "^")) {
            return (int) Math.pow(number1, number2);
        }
        throw new IllegalArgumentException("Неверный знак");
    }
}