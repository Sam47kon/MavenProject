package GrandTasks.Week7_8;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

import static MyMethods.MyMethods.*;

public class ComparableQuickSort {      // TODO доделать Comparable


    private static void quickSort(int[] array, int start, int end) {
        if (array.length == 0) {   //завершить выполнение если длина массива равна 0
            return;
        }
        if (start >= end) {    //завершить выполнение если уже нечего делить
            return;
        }
        // выбрать опорный элемент - середину
        int middle = start + (end - start) / 2;
        int prop = array[middle];    // опора

        // разделить на подмассивы, который больше и меньше опорного элемента
        int left = start;
        int right = end;
        while (left <= right) {
            while (array[left] < prop) {
                left++;
            }

            while (array[right] > prop) {
                right--;
            }

            if (left <= right) {     //меняем местами
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        if (start < right) {     // рекурсия сортировки для левой части
            quickSort(array, start, right);
        }
        if (end > left) {      // рекурсия сортировки для правой части
            quickSort(array, left, end);
        }
    }

    public static void main(String[] args) {
        double startTime;
        double stopTime;
        Scanner reader = new Scanner(System.in);
        boolean needToContinue = true;
        String exit;
        int start = 0;
        int end;


        while (needToContinue) {
            System.out.print("Длина массива: ");
            end = reader.nextInt();
            int[] array = new int[end];
            end--;

            fillArray(array);

            int[] array1 = Arrays.copyOf(array, array.length);


            startTime = System.nanoTime();
            Arrays.sort(array);
            stopTime = System.nanoTime();
            getRunTime(startTime, stopTime, "Time DualPivotQuickSort ");

            startTime = System.nanoTime();
            quickSort(array1, start, end);
            stopTime = System.nanoTime();
            getRunTime(startTime, stopTime, "Time quickSort ");


            System.out.println("Выйти - qqq");
            exit = reader.next();
            needToContinue = !Objects.equals(exit, "qqq");

//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(array1));
        }

    }


}
