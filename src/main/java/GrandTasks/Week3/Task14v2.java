package GrandTasks.Week3;

import MyStaticMethods.MyMethods;

//Вводишь 10 чисел, и число, которое надо найти в этом списке. Программа возвращает индекс, или -1 если введенное число не присутствует
public class Task14v2 {


    public static void main(String[] args) {
        double[] inputNumbers = new double[5];
        for (int i = 0; i < inputNumbers.length; ) {
            inputNumbers[i] = MyMethods.getDoubleFromInput("Insert the " + ++i + " number");
        }
        double desiredNumber = MyMethods.getDoubleFromInput("Введите любое число, и я вам скажу есть ли оно среди тех чисел");
        String doesItExist = new Task14v2().findOutThatItExists(inputNumbers, desiredNumber);
        System.out.println(doesItExist);
    }

    private String findOutThatItExists(double[] inputNumbers, double desiredNumber) {
        for (int i = 0; i < inputNumbers.length; i++) {
            if (inputNumbers[i] == desiredNumber) {

                return ("Ваше число " + desiredNumber + " стоит на " + (i + 1) + " месте");
            }
        }
        return "-1";
    }
}
