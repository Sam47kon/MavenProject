package GrandTasks.Week3;

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        System.out.println("Let's play the game? Guess the number from 0 to 100 in 8 attempts");
        int unknownNumber = (int) (Math.random() * 100);
        int attempts = 8;
        int inputNumbers;
        Scanner reader = new Scanner(System.in);
        while (attempts > 0) {
            System.out.println("Left " + attempts + " attempts. Enter number...");
            inputNumbers = reader.nextInt();
            if (inputNumbers == unknownNumber) {
                System.out.println("Congratulations! You WIN!");
                break;
            }
            if (inputNumbers > unknownNumber) {
                attempts--;
                if (attempts == 0) {
                    System.out.println("You Lose...");
                    break;
                }
                System.out.println("No, but hidden number less"); // загаданное число меньше
            } else {
                attempts--;
                if (attempts == 0) {
                    System.out.println("You Lose...");
                    break;
                }
                System.out.println("No, but hidden number greater"); // загаданное число больше
            }
        }
    }
}
