package GrandTasks.Week2;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// Программа принимает из консоли 2 числа и операцию (+ - / * ^ ), выводит результат
public class Task5 {

    public Scanner reader = new Scanner(System.in); // если я ввожу данные через метод, то сканер можно объявить в классе
    private Set<String> signs = Set.of("+", "-", "*", "/", "^");
    private boolean ifInputErr = true;

    public static void main(String[] args) {
        double number1 = new Task5().getNumber("Введите 1 число: ");
        double number2 = new Task5().getNumber("Введите 2 число: ");
        String sign = new Task5().getSign();

        double decision = new Task5().useCalculator(number1, number2, sign);
        System.out.println(decision);
    }

    private String getSign() {
        String sign = "k";
        System.out.print("Что сделать с числами? Сложить '+', вычесть '-', умножить '*', поделить '/', возвести в степень '^' ");
        while (ifInputErr) {    // цикл заставляет вводить только НУЖНЫЙ знак, не выводя ошибку IllegalArgumentException
            if (reader.hasNext()) {    // никогда не будет ошибки IllegalArgumentException
                sign = reader.next();   // хотел попробовать через char, но у сканера нет метода ввода char :(
                // 1 вариант проверки нужного знака
                if (signs.contains(sign)) {    // если входит в состав контейнера
                    break;
                } else {
                    System.out.println("Нужно ввести знак!");
                    continue;
                }
            }
            ifInputErr = false;
        }
        return sign;
    }

    public double getNumber(String text) { // метод ввода только числа
        double number = 0;
        System.out.println(text);
        while (ifInputErr) {    // цикл заставляет вводить только числа, не выводя ошибку InputMismatchException
            if (reader.hasNextDouble()) {    // has имеет булевское значение
                number = reader.nextDouble();
            } else {
                System.out.println("Нужно ввести число, а не текст! " + text);
                reader.next();
                continue;
            }
            ifInputErr = false;
        }
        return number;
    }

    public double useCalculator(double number1, double number2, String sign) {
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
        throw new IllegalArgumentException("Неверный знак"); // это уже не нужно
    }
}