package GrandTasks.Week5_6;

import java.util.Arrays;

public class Task38MergeSort {    // сортировка слиянием
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[]{1, 2, 3, 9, 10, 11, 12, 13, 14, 15};
        double startTime;
        double stopTime;
        int[] mergerArr1Arr2;

        startTime = System.nanoTime();
        mergerArr1Arr2 = mergeArrays(arr1, arr2);
        stopTime = System.nanoTime();
        System.out.println(Arrays.toString(mergerArr1Arr2));
        System.out.println("Time mergeArrays = " + (stopTime - startTime) / 1000 + " ms");
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (index < result.length) {
            result[index] = arr1[aIndex] < arr2[bIndex] ? arr1[aIndex++] : arr2[bIndex++];
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
