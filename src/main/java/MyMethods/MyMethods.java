package MyMethods;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyMethods {
    private Scanner reader = new Scanner(System.in);
    private boolean ifInputErr = true;

    public static void getRunTime(double startTime, double stopTime, String s) {
        System.out.println(s + (stopTime - startTime) / 1000000 + " ms");
    }

    public static void swap(int[] array, int fst, int snd) {       // смещение элементов массива, либо перестановка элементов fst и snd
        int tmp = array[fst];
        array[fst] = array[snd];
        array[snd] = tmp;
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length * 10);
        }
    }

    public static int[] createRandomArrayWithSize(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length * 10);
        }
        return Arrays.copyOf(array, size);
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
