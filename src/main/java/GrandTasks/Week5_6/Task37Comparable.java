package GrandTasks.Week5_6;

import java.util.Arrays;

public class Task37Comparable {

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] arr2 = {1, 2, 3, 9, 10, 11, 12, 13, 14, 15};
        double startTime;
        double stopTime;
        Comparable[] mergerArr1Arr2;

        startTime = System.nanoTime();
        mergerArr1Arr2 = mergeArrays(arr1, arr2);
        stopTime = System.nanoTime();
        System.out.println(Arrays.toString(mergerArr1Arr2));
        System.out.println("Time mergeArrays = " + (stopTime - startTime) / 1000 + " ms");

        String[] str = {"A", "D", "V"};
        String[] str2 = {"B", "C", "Z"};
        System.out.println(Arrays.toString(mergeArrays(str, str2)));
    }


    static Comparable[] mergeArrays(Comparable[] arr1, Comparable[] arr2) {
        Comparable[] result = new Comparable[arr1.length + arr2.length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (index < result.length) {
            //result[index] = arr1[aIndex] < arr2[bIndex] ? arr1[aIndex++] : arr2[bIndex++];
            result[index] = arr1[aIndex].compareTo(arr2[bIndex]) < 0 ? arr1[aIndex++] : arr2[bIndex++];
            if (aIndex == arr1.length) {       // если индекс вылетел за пределы
                System.arraycopy(arr2, bIndex, result, ++index, arr2.length - bIndex);    // копирую оставшиеся элементы другого массива
                break;
            }
            if (bIndex == arr2.length) {
                System.arraycopy(arr1, aIndex, result, ++index, arr1.length - aIndex);
                break;
            }
            index++;
        }
        return result;
    }
}