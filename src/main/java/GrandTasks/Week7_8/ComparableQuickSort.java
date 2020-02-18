package GrandTasks.Week7_8;

import MyStaticMethods.MyMethods;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ComparableQuickSort {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String exit = "";
        int end;

        while (!Objects.equals(exit, "qqq")) {
            System.out.print("Длина массива: ");
            end = reader.nextInt();
            Integer[] array1 = new Integer[end];

            MyMethods.fillIntegerArray(array1);
            Integer[] array2 = Arrays.copyOf(array1, array1.length);

            System.out.println("Time DualPivotQuickSort for Integer array " + MyMethods.getRuntime(() -> Arrays.sort(array1)));
            System.out.println("Time comparableQuickSort for Integer array " + MyMethods.getRuntime(() -> new ComparableQuickSort().comparableQuickSort(array2)));

            System.out.println("Выйти - qqq");
            exit = reader.next();
        }
    }

    public void comparableQuickSort(Comparable[] array) {
        comparableQuickSort(array, 0, array.length - 1);
    }

    private void comparableQuickSort(Comparable[] array, int start, int end) {
        if (array.length == 0) {   //завершить выполнение если длина массива равна 0
            return;
        }
        if (start >= end) {    //завершить выполнение если уже нечего делить
            return;
        }
        // выбрать опорный элемент - середину
        int middle = start + (end - start) / 2;
        Comparable prop = array[middle];    // опора

        // разделить на подмассивы, который больше и меньше опорного элемента
        int left = start;
        int right = end;
        while (left <= right) {
            while (array[left].compareTo(prop) < 0) {
                left++;
            }

            while (array[right].compareTo(prop) > 0) {
                right--;
            }

            if (left <= right) {     //меняем местами
                Comparable temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) {     // рекурсия сортировки для левой части
            comparableQuickSort(array, start, right);
        }
        if (end > left) {      // рекурсия сортировки для правой части
            comparableQuickSort(array, left, end);
        }
    }
}
