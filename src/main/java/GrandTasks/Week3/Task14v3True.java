package GrandTasks.Week3;

import MyStaticMethods.MyMethods;

//Вводишь 10 чисел, и число, которое надо найти в этом списке. Программа возвращает индекс, или -1 если введенное число не присутствует
public class Task14v3True {


    public static void main(String[] args) {
        double[] inputNumbers = new double[10];
        for (int i = 0; i < inputNumbers.length; ) {
            inputNumbers[i] = MyMethods.getDoubleFromInput("Insert the " + ++i + " number");
        }
        double desiredNumber = MyMethods.getDoubleFromInput("Введите любое число, и я вам скажу есть ли оно среди тех чисел");
        int indexNumber = new Task14v3True().findOutThatItExists(inputNumbers, desiredNumber);
        System.out.println(indexNumber);
    }

    int findOutThatItExists(double[] inputNumbers, double desiredNumber) {    // узнать, существует ли это
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] == desiredNumber) {
                return i + 1;
            }
        }
        return -1;
    }
}
