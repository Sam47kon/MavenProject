package GrandTasks.Week2;

import java.util.Arrays;
import java.util.Random;

// Вводишь 10 чисел, программа возвращает их в отсортированном порядке
public class Task13extra {
    public static void main(String[] args) {
        double[] inputNumbers = new double[10];
        Random random = new Random();
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = random.nextDouble() * 5000;
        }
        long time = System.nanoTime();
        Arrays.sort(inputNumbers);  // 1 вариант сортировки
        System.out.println("Time " + (System.nanoTime() - time));
        for (int i = 0; i < inputNumbers.length; ) {
            System.out.print(inputNumbers[i++] + "  ");
        }
    }
}
