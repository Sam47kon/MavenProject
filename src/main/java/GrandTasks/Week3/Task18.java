package GrandTasks.Week3;

// 2.13 Дано трехзначное число. Найти число, полученное при прочтении его цифр справа налево.
public class Task18 {

    int reversNumber(int number) {
        return number % 100 % 10 * 100 + number % 100 / 10 * 10 + number / 100;
    }
}
