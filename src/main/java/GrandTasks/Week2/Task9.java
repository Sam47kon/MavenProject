package GrandTasks.Week2;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner reared = new Scanner(System.in);
        System.out.print("Введите любой текст: ");
        String text = reared.nextLine();
        System.out.print("Ваш текст в обратном порядке: ");
        String textBackwards = new StringBuilder(text).reverse().toString();    // сделает то же самое, что мой метод
        System.out.println(textBackwards);

        textBackwards = new Task9().printLineBackwards(text);    // вывод обратного текста
        System.out.println(textBackwards);
    }

    String printLineBackwards(String text) {
        String textBackwards = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            textBackwards += text.charAt(i);
        }
        return textBackwards;
    }
}
