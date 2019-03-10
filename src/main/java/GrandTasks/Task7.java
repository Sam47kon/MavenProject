package GrandTasks;

import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит n! (эн факториал)
public class Task7 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Введите число: ");
        int number = reader.nextInt();
        int factorial = new Task7().getFactorial(number);
        System.out.println(factorial);
    }

    public int getFactorial(int number) {
        int factor = 1; // факториал 0 будет 1, как и должно быть
        for (int i = 1; i <= number; i++) {
            factor = i * factor;
        }
        return factor;
    }
}
