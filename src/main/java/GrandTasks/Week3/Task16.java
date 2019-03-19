package GrandTasks.Week3;

import java.util.Scanner;

// 1.3. Составить программу вывода на экран числа, вводимого с клавиатуры. Выводимому числу должно предшествовать сообщение "Вы ввели число".
public class Task16 {
    private Scanner reader = new Scanner(System.in);
    private boolean ifInputErr = true;

    public static void main(String[] args) {
        double inputNumber = new Task16().getDoubleFromInput("Введите число: ");
        System.out.println("Вы ввели число: " + inputNumber);
    }

    public double getDoubleFromInput(String text) { // метод ввода только числа
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
}
