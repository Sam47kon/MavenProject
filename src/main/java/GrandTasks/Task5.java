package GrandTasks;

import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

// Программа принимает из консоли 2 числа и операцию (+ - / * ^ ), выводит результат
public class Task5 {
    //enum Signs {
    //}

    //private Scanner reader; // если я ввожу данные через метод, то сканер можно объявить в классе

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String sign = "k";
        boolean ifSignInputErr = true;
        Set<String> signs = Set.of("+", "-", "*", "/", "^");    // подключение контейнера для проверки нужного знака (1 вариант)
        //String[] signs1 = {"+", "-", "*", "/", "^"};    // для 2 варианта проверки

        double number1 = new Task5().getNumber();
        double number2 = new Task5().getNumber();

        boolean ifNumberInputErr = true;
        while (ifNumberInputErr) {
            System.out.println("Введите второе число: ");
            if (reader.hasNextDouble()) {
                number2 = reader.nextDouble();
            } else {
                System.out.println("Нужно ввести число, а не текст!!!");
                reader.next();
                continue;
            }
            ifNumberInputErr = false;
        }

        //boolean contains = Arrays.stream(signs1).anyMatch(sign::equals);    // 2 вариант проверки выдает true если sing является одним из значений массива
        System.out.print("Что сделать с числами? Сложить '+', вычесть '-', умножить '*', поделить '/', возвести в степень '^' ");

        // цикл заставляет вводить только НУЖНЫЙ знак, не выводя ошибку IllegalArgumentException
        while (ifSignInputErr) {
            if (reader.hasNext()) {    // никогда не будет ошибки IllegalArgumentException
                sign = reader.next();   // хотел попробовать через char, но у сканера нет метода ввода char :(
                // 1 вариант проверки нужного знака
                if (signs.contains(sign)) { // если входит в состав контейнера
                    break;
                } else {
                    System.out.println("Нужно ввести знак!");
                    continue;
                }
                /*// 2 вариант проверки нужного знака
                contains = Arrays.stream(signs1).anyMatch(sign::equals);
                if (contains) {
                    break;
                } else {
                    System.out.println("Нужно ввести знак!");
                    continue;
                }*/
            }
            ifSignInputErr = false;
        }


        //Signs signs1 = Signs.valueOf(reader.next()); // это для enum


        double decision = new Task5().useCalculator(number1, number2, sign);
        System.out.println(decision);
    }

    public double getNumber() { // метод ввода только числа
        double number = 0;
        Scanner reader = new Scanner(System.in);
        boolean ifNumberInputErr = true;
        // цикл заставляет вводить только числа, не выводя ошибку InputMismatchException
        while (ifNumberInputErr) {
            System.out.println("Введите первое число: ");
            if (reader.hasNextDouble()) { // has имеет булевское значение
                number = reader.nextDouble();
            } else {
                System.out.println("Нужно ввести число, а не текст!");
                reader.next();
                continue;
            }
            ifNumberInputErr = false;
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
