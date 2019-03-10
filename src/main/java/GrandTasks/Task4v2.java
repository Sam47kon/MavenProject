package GrandTasks;

import java.util.Scanner;

// Среднее арифметическое введеных нескольких чисел
public class Task4v2 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите колличество чисел для вывода среднего значения: ");
        int numbers[] = new Task4v2().getArray(reader); // создаю массив, используя метод ArrayLength
        double average = new Task4v2().getAverage(numbers);
        System.out.println("Среднее арифметическое чисел: " + average);

    }

    // метод создания массива с указанием чисел и длинны
    private int[] getArray(Scanner reader) {
        int quantity = reader.nextInt();
        int[] numbers = new int[quantity];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Enter " + ++i + " number");
            i--;
            numbers[i] = reader.nextInt();
        }
        return numbers;
    }

    // метод
    public double getAverage(int a[]) {
        double average;
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        average = sum / a.length;
        return average;
    }
}
