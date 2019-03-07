package GrandTasks;

import java.util.Scanner;

// Среднее арифметическое введеных 5 чисел
public class Task4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int[] numbers = new int[5];
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter " + ++i + " number");
            i--;
            numbers[i] = reader.nextInt();
            sum += numbers[i];
        }
        double average = sum / numbers.length;
        System.out.println("Среднее арифметическое чисел: " + average);

    }
}