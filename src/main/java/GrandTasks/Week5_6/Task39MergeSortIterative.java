package GrandTasks.Week5_6;

import java.util.Arrays;

public class Task39MergeSortIterative {    // сортировка слиянием используя рекурсию
    public static void main(String[] args) {
        int[] arr1 = {99, -999, 34, 60, 60, 75, 118, 9645, -10, 6666666};
        double startTime;
        double stopTime;

        startTime = System.nanoTime();
        mergeSortIterative(arr1);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSortInner = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(arr1));
    }

    static void mergeSortIterative(int[] arr) {
        if (arr == null) {
            return;
        }
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            System.arraycopy(arr, 0, left, 0, mid);
            int[] right = new int[arr.length - mid];
            System.arraycopy(arr, mid, right, 0, arr.length - mid);
            mergeSortIterative(left);
            mergeSortIterative(right);
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
    }
}
