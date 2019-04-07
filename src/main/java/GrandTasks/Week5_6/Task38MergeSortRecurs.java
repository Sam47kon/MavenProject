package GrandTasks.Week5_6;

import java.util.Arrays;

public class Task38MergeSortRecurs {    // сортировка слиянием используя рекурсию
    public static void main(String[] args) {
        int[] arr1 = new int[]{99, -999, 34, 60, 60, 75, 118, 9645, -10};
        int[] sortArr1;
        double startTime;
        double stopTime;

        startTime = System.nanoTime();
        sortArr1 = mergeSort(arr1);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSortInner = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(sortArr1));
        System.out.println(Arrays.toString(arr1));
    }

    static int[] mergeSort(int[] array1) {
        int[] arr = Arrays.copyOf(array1, array1.length);
        int[] buffer = new int[array1.length];
        return mergeSortInner(arr, buffer, 0, array1.length);
    }

    private static int[] mergeSortInner(int[] arr, int[] buffer, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return arr;
        }
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(arr, buffer, startIndex, middle);
        int[] sorted2 = mergeSortInner(arr, buffer, middle, endIndex);
        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == arr ? buffer : arr;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

}
