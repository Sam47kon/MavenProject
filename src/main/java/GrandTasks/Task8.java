package GrandTasks;

import java.util.Arrays;
import java.util.Scanner;

//Программа принимает число n с клавиатуры, выводит Fn (n-ое число фибоначи. О числах фибоначи можно прочесть в википедии)
public class Task8 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int length = reader.nextInt();
        int [] fibonacci = new int[length];
        fibonacci[0]=1;
        for (int i = 0; i <fibonacci.length-1; i++){
            fibonacci[i+1]=i +fibonacci[i];
        }
        for (int i : fibonacci){    //цикл for each, только для коллекций и массивов, автоматически i++
            System.out.println(i);
        }
        System.out.println(Arrays.toString(fibonacci)); // метод вывода массива в строке
    }
}
