package GrandTasks.Week4;

import java.util.Scanner;

// 5.27. Найти:
//а) сумму всех целых чисел от 100 до 500;
//б) сумму всех целых чисел от a до 500 (значение a вводится с клавиатуры a <=500);
//в) сумму всех целых чисел от –10 до b (значение b вводится с клавиатуры >= –10);
//г) сумму всех целых чисел от a до b (значения a и b вводятся с клавиатуры b >= a)
public class Task33 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Task33 method = new Task33();
        int num = method.getSum();
        System.out.println("Сумма целых чисел от 100 до 500 = " + num);


        System.out.println("Введите значение 'от':");
        int fromNum = reader.nextInt();
        System.out.println("Сумма целых чисел от " + fromNum + " до 500 = " + method.getSumFromTheNumberToFiveHundred(fromNum));

        System.out.println("Введите значение 'до':");
        int toNum = reader.nextInt();
        System.out.println("Сумма целых чисел от -10 до " + toNum + " = " + method.getSum2(toNum));

        System.out.println("Введите значение 'от':");
        fromNum = reader.nextInt();
        System.out.println("Введите значение 'до':");
        toNum = reader.nextInt();
        System.out.println("Сумма целых чисел от " + fromNum + " до " + toNum + " = " + method.getSum3(fromNum, toNum));


    }

    private int getSum() {      // а)
        int num = 0;
        for (int i = 100; i <= 500; i++) {
            num += i;
        }
        return num;
    }

    private int getSumFromTheNumberToFiveHundred(int dataFromNum) {     // б)
        for (int i = dataFromNum; i <= 500; i++) {
            dataFromNum += i;
        }
        return dataFromNum;
    }

    private int getSum2(int dataToNum) {     // в)
        int sum = 0;
        for (int i = -10; i <= dataToNum; i++) {
            sum += i;
        }
        return sum;
    }

    int getSum3(int dataFromNum, int dataToNum) {     // г)
        int sum = 0;
        for (int i = dataFromNum; i <= dataToNum; i++) {
            sum += i;
        }
        return sum;
    }
}
