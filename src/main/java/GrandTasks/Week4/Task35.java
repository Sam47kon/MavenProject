package GrandTasks.Week4;

import java.util.Arrays;
import java.util.Scanner;

// 6.8. Дано число n. Из чисел 1, 4, 9, 16, 25, ... напечатать те, которые не превышают n
public class Task35 {

    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int number = new Scanner(System.in).nextInt();
        int[] numbers = new Task35().getSquaresOfPositiveIntegersLessThanTheValue(number);
        System.out.println(Arrays.toString(numbers));
    }


    int[] getNumbers1(int dataNum) {
        StringBuilder strNumbers = new StringBuilder();
        int tmp;
        for (int i = 1; Math.pow(i, 2) <= dataNum; i++) {
            tmp = (int) Math.pow(i, 2);
            strNumbers.append(tmp);
        }
        String[] items = strNumbers.toString().split(", ");
        int[] numbers = new int[items.length];
        for (int i = 0; i < items.length; i++) {
            numbers[i] = Integer.parseInt(items[i]);
        }
        return numbers;
    }

    int[] getSquaresOfPositiveIntegersLessThanTheValue(int dataValue) {
        int length = 0;
        for (int i = 1; Math.pow(i, 2) <= dataValue; i++) {
            length++;
        }
        int[] numbers = new int[length];
        for (int i = 1; i <= numbers.length; i++) {
            numbers[i - 1] = (int) Math.pow(i, 2);
        }
        return numbers;
    }
}
