package GolovachDecember2013.CoreProcedural2.Sortings;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.*;

public class MergeSorting {

    public static void main(String[] args) {
        int[] result;
        double startTime;
        double stopTime;
        System.out.println("до: ");
        System.out.println(Arrays.toString(ARR0));
        System.out.println(Arrays.toString(ARR1));
        System.out.println(Arrays.toString(ARR2));
        System.out.println(Arrays.toString(ARR3));
        System.out.println("после: ");

        startTime = System.nanoTime();
        result = changeMergeSort(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort for ARR0 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(result));

        startTime = System.nanoTime();
        result = changeMergeSort(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort for ARR1 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(result));

        startTime = System.nanoTime();
        result = changeMergeSort(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort for ARR2 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(result));

        startTime = System.nanoTime();
        result = changeMergeSort(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time mergeSort for ARR3 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(result));

        startTime = System.nanoTime();
        sortUnsorted(ARR3, 0, ARR3.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time sortUnsorted for ARR3 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(ARR3));
    }

    private static int[] changeMergeSort(int[] array1) {
        int[] arr = Arrays.copyOf(array1, array1.length);
        int[] buffer = new int[array1.length];
        return mergeSort(arr, buffer, 0, array1.length);
    }

    /**
     * @param arr    Массив для сортировки.
     * @param buffer    Буфер. Размер должен быть равен размеру buffer1.
     * @param startIndex Начальный индекс в buffer1 для сортировки.
     * @param endIndex   Конечный индекс в buffer1 для сортировки.
     */
    private static int[] mergeSort(int[] arr, int[] buffer, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return arr;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSort(arr, buffer, startIndex, middle);
        int[] sorted2 = mergeSort(arr, buffer, middle, endIndex);

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


    /**
     * @param arr      - массив
     * @param firstPos - позиция первого элемента в массиве (для первой итерации = 0)
     * @param lastPos  - позиция последнего элемента в массиве (для первой итерации = a.length — 1)
     */
    private static void sortUnsorted(int[] arr, int firstPos, int lastPos) {  // сортировка слиянием TODO доработать
        if (lastPos <= firstPos)
            return;
        int mid = firstPos + (lastPos - firstPos) / 2;
        sortUnsorted(arr, firstPos, mid);
        sortUnsorted(arr, mid + 1, lastPos);

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
