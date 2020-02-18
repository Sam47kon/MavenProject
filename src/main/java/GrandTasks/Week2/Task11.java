package GrandTasks.Week2;

import MyStaticMethods.MyMethods;

import java.util.Scanner;

// Программа принимает с клавиатуры число, и определяет, является ли это число степенью двойки
public class Task11 {

    public static void main(String[] args) {
        String exit = "";
        while (!exit.equals("qqq")) {
            int inputNum = (int) MyMethods.getDoubleFromInput("Введите число: ");
            boolean b1 = new Task11().isNumberPowerOfTwo1(inputNum);    // 1 вариант
            boolean b2 = new Task11().isNumberPowerOfTwo2(inputNum);    // 2 вариант
            boolean b3 = new Task11().isNumberPowerOfTwo3(inputNum);    // 3 вариант
            System.out.println(b1 + " " + b2 + " " + b3);
            exit = new Scanner(System.in).next();
        }
    }

    boolean isNumberPowerOfTwo1(int inputNum) {
        if (inputNum == 0) {
            return false;
        }
        inputNum = Math.abs(inputNum);
        while (((inputNum % 2) == 0)) {
            inputNum /= 2;
        }
        return inputNum == 1;
    }

    boolean isNumberPowerOfTwo2(int inputNum) {
        inputNum = Math.abs(inputNum);
        return (inputNum & (-inputNum)) == inputNum && inputNum != 0;
    }

    boolean isNumberPowerOfTwo3(int inputNum) {
        return Integer.bitCount(Math.abs(inputNum)) == 1;
    }

    //region Для меня, для расчетов
//    public void printUsefulInfo() {
//        int inputNum = (int) MyMethods.getDoubleFromInput();
//        System.out.println("наше число " + inputNum);
//        System.out.println(("наше число противоположное: " + ~(inputNum - 1)));    // эквивалентно -inputNumber
//        System.out.println("двоичное число " + Integer.toBinaryString(inputNum));
//        System.out.println("двоичное число противоположное: " + Integer.toBinaryString(~(inputNum - 1)));    // эквивалентно -inputNumber
//    }
    //endregion

    //region Вывод чисел от 0-64 в двоичнйой системе
    //    public String outNumbersInBinary() {
//        int[] numbersInDecimal = new int[65];
//        String[] numbersInBinary = new String[65];
//        for (int i = 0; i < numbersInDecimal.length; i++) {
//            numbersInDecimal[i] = i;
//            numbersInBinary[i] = Integer.toBinaryString(numbersInDecimal[i]);
//        }
//        return Arrays.toString(numbersInBinary);
//    }
    //endregion
}
