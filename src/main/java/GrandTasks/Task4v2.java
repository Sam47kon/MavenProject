package GrandTasks;

import java.util.Scanner;

// Среднее арифметическое введеных нескольких чисел
public class Task4v2 {
    public static void main(String[] args) {
        System.out.println("Введите колличество чисел для вывода среднего значения: ");
        while (true) {
            int[] numbers = new Task4v2().creatingArrayWithGivenNumbersAndLength();
            if (numbers.length != 0) {
                double average = new Task4v2().getAverage(numbers);
                System.out.println("Среднее арифметическое чисел: " + average);
                break;
            }
            System.out.println("Нельзя посчитать среднее арфиметическое без чисел! Введите количество (оно не может быть 0)");
        }
    }

    // метод создания массива с указанием чисел и длинны, creating an array with given numbers and its length
    private int[] creatingArrayWithGivenNumbersAndLength() {
        Scanner reader = new Scanner(System.in);
        int quantity = reader.nextInt();
        int[] values = new int[quantity];
        for (int i = 0; i < values.length; i++) {
            System.out.println("Enter " + ++i + " number");
            i--;
            values[i] = reader.nextInt();
        }
        return values;
    }

    // метод нахождение среднего
    public double getAverage(int[] mass) {
        double average;
        double sum = 0;
        for (int i : mass) {
            sum += i;
        }
        average = sum / mass.length;
        return average;
    }
}
