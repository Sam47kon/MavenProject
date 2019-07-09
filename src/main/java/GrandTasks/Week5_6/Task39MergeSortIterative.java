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
            int[] left_arr = new int[mid];
            System.arraycopy(arr, 0, left_arr, 0, mid);

            int[] right_arr = new int[arr.length - mid];
            System.arraycopy(arr, mid, right_arr, 0, arr.length - mid);

            mergeSortIterative(left_arr);
            mergeSortIterative(right_arr);

            int index_left = 0;
            int index_right = 0;
            int k = 0;
            while (index_left < left_arr.length && index_right < right_arr.length) {
                if (left_arr[index_left] < right_arr[index_right]) {
                    arr[k] = left_arr[index_left];
                    index_left++;
                } else {
                    arr[k] = right_arr[index_right];
                    index_right++;
                }
                k++;
            }
            while (index_left < left_arr.length) {
                arr[k] = left_arr[index_left];
                index_left++;
                k++;
            }
            while (index_right < right_arr.length) {
                arr[k] = right_arr[index_right];
                index_right++;
                k++;
            }
        }
    }
}
