package GrandTasks.Week3;

import MyStaticMethods.MyMethods;

// 1.3. Составить программу вывода на экран числа, вводимого с клавиатуры. Выводимому числу должно предшествовать сообщение "Вы ввели число".
public class Task16 {

    public static void main(String[] args) {
        System.out.println("Вы ввели число: " + MyMethods.getDoubleFromInput("Введите число: "));
    }
}
