package GrandTasks.Week3;

import GrandTasks.Week2.Task5;

//Вводишь 10 чисел, и число, которое надо найти в этом списке. Программа возвращает индекс, или -1 если введенное число не присутствует
public class Task14 {

    public static void main(String[] args) {
        double[] inputNumbers = new double[5];
        for (int i = 0; i < inputNumbers.length; ) {
            inputNumbers[i] = new Task5().getDoubleFromInput("Insert the " + ++i + " number");
        }
        double desiredNumber = new Task5().getDoubleFromInput("Введите любое число, и я вам скажу есть ли оно среди тех чисел");
        boolean doesItExist = new Task14().findOutThatItExists(inputNumbers, desiredNumber);
        if (doesItExist) {
            System.out.println("1");
        } else {
            System.out.println("-1");   // решение, если надо вывести -1
        }
    }

    public boolean findOutThatItExists(double[] inputNumbers, double desiredNumber) {
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] == desiredNumber) {
                System.out.println("Ваше число " + desiredNumber + " стоит на " + (i + 1) + " месте");
                return true;
            }
        }
        return false;
    }
}
