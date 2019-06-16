package MyMethods;

import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MyMethods {
    public static final File FOLDER_DESKTOP = new File("C:\\Users\\Alina\\Desktop");
    private Scanner reader = new Scanner(System.in);
    private boolean ifInputErr = true;

    public static double getRuntime(Runnable runnable) {
        double startTime;
        double stopTime;
        startTime = System.nanoTime();
        runnable.run();
        stopTime = System.nanoTime();
        return (stopTime - startTime) / 1_000_000;
    }

    public static double getRuntime_N_times(int count, Runnable runnable) {
        double startTime;
        double stopTime;
        double[] results = new double[count];
        double sum = 0;
        for (int i = count - 1; i >= 0; i--) {
            startTime = System.nanoTime();
            runnable.run();
            stopTime = System.nanoTime();
            results[i] = stopTime - startTime;
            sum += results[i];
        }
        return sum / count / 1_000_000;
    }

    public static void getRunTime(double startTime, double stopTime, String s) {
        System.out.println(s + (stopTime - startTime) / 1000000 + " ms");
    }

    public static void swap(int[] array, int fst, int snd) {       // смещение элементов массива, либо перестановка элементов fst и snd
        int tmp = array[fst];
        array[fst] = array[snd];
        array[snd] = tmp;
    }

    public static void fillIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length * 10);
        }
    }

    public static void fillIntegerArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(array.length * 10);
        }
    }

    public static void fillStringArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.toString(new Random().nextInt(array.length * 10));
        }
    }


    public static Integer[] createRandomArrayWithSize(int size) {
        Integer[] array = new Integer[size];
        fillIntegerArray(array);
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
