package GolovachDecember2013.CoreProcedural2.Sortings;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR3;

public class MergeSorting {

    public static void main(String[] args) {
        int[] result;
        int[] testArr = Arrays.copyOf(ARR3, ARR3.length);
        double startTime;
        double stopTime;
        System.out.println("до: ");
        System.out.println("ARR3 = " + Arrays.toString(ARR3));


        startTime = System.nanoTime();
        result = mergeSort1Recursive(testArr);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort1Recursive for ARR3 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println("result = " + Arrays.toString(result));


        startTime = System.nanoTime();
        mergeSort3(testArr, 0, testArr.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort3 for ARR3 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println("после mergeSort3 " + Arrays.toString(testArr));
        testArr = Arrays.copyOf(ARR3, ARR3.length);


        startTime = System.nanoTime();
        mergeSort2Iterative(testArr);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort2Iterative for ARR3 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(testArr));
        testArr = Arrays.copyOf(ARR3, ARR3.length);

    }

    /**
     * сортировка слиянием рекурсивно
     *
     * @param arr        Массив для сортировки.
     * @param buffer     Буфер. Размер должен быть равен размеру buffer1.
     * @param startIndex Начальный индекс в buffer1 для сортировки.
     * @param endIndex   Конечный индекс в buffer1 для сортировки.
     */
    private static int[] mergeSort1RecursiveInner(int[] arr, int[] buffer, int startIndex, int endIndex) { // сортировка слиянием рекурсивно
        if (startIndex >= endIndex - 1) {
            return arr;
        }
        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort1RecursiveInner(arr, buffer, startIndex, middle);
        int[] sorted2 = mergeSort1RecursiveInner(arr, buffer, middle, endIndex);
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

    private static int[] mergeSort1Recursive(int[] array1) {
        int[] arr = Arrays.copyOf(array1, array1.length);
        int[] buffer = new int[array1.length];
        return mergeSort1RecursiveInner(arr, buffer, 0, array1.length);
    }


    /**
     * сортировка слиянием итеративно
     *
     * @param arr Массив для сортировки.
     */

    private static void mergeSort2Iterative(int[] arr) {
        if (arr == null) {
            return;
        }
        if (arr.length > 1) {
            int mid = arr.length / 2;
            // Split left part
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }
            // Split right part
            int[] right = new int[arr.length - mid];
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }
            mergeSort2Iterative(left);
            mergeSort2Iterative(right);
            int i = 0;
            int j = 0;
            int k = 0;
            // Merge left and right arrays
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
            // Collect remaining elements
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


    /**
     * сортировка слиянием рекурсивно, выбранного промежутка
     *
     * @param arr      - массив
     * @param firstPos - позиция первого элемента в массиве (для первой итерации = 0)
     * @param lastPos  - позиция последнего элемента в массиве (для первой итерации = a.length — 1)
     */
    private static void mergeSort3(int[] arr, int firstPos, int lastPos) {  // сортировка слиянием рекурсивно, выбранного промежутка
        if (lastPos <= firstPos)
            return;
        int mid = firstPos + (lastPos - firstPos) / 2;
        mergeSort3(arr, firstPos, mid);
        mergeSort3(arr, mid + 1, lastPos);
        int[] buf = Arrays.copyOf(arr, arr.length);
        for (int k = firstPos; k <= lastPos; k++)
            buf[k] = arr[k];
        int i = firstPos;
        int j = mid + 1;
        for (int k = firstPos; k <= lastPos; k++) {
            if (i > mid) {
                arr[k] = buf[j];
                j++;
            } else if (j > lastPos) {
                arr[k] = buf[i];
                i++;
            } else if (buf[j] < buf[i]) {
                arr[k] = buf[j];
                j++;
            } else {
                arr[k] = buf[i];
                i++;
            }
        }
    }
}
