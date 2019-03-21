package GrandTasks.Week3;

import java.util.Scanner;

// Написать игру "угадай число", программа загадывает  число от 0 до 100, пользователю дается 8 попыток,
// если он называет число больше, то программа говорит что загаданное число должно быть меньше.
// Если называет число меньше - программа говорит что загаданное число больше. Если число угадано - программа
// пишет что все ок и завершает работу. Если за 8 попыток оно не угадано, то пользователь проиграл и программа
// завершает свою работу
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
            attempts--;
            if (attempts == 0) {
                System.out.println("You Lose...");
                break;
            }
            if (inputNumbers == unknownNumber) {
                System.out.println("Congratulations! You WIN!");
                break;
            }
            if (inputNumbers > unknownNumber) {
                attempts--;
                System.out.println("No, but hidden number less"); // загаданное число меньше
            }
            System.out.println("No, but hidden number greater"); // загаданное число больше
        }
    }
}
