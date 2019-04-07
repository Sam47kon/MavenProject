package GrandTasks.Week5_6;

import java.util.Arrays;

public class Task37Comparable {

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


//    <T extends Comparable<T>> mergeArrays(T[] list) {
//
//    }

//    public static void mergeArrays(Comparable[] a, int lo, int mid, int hi)
//    {
//        // Merge a[lo..mid] with a[mid+1..hi].
//        int i = lo, j = mid+1;
//        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
//            aux[k] = a[k];
//        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
//            if (i > mid) a[k] = aux[j++];
//            else if (j > hi ) a[k] = aux[i++];
//            else if (less(aux[j], aux[i])) a[k] = aux[j++];
//            else a[k] = aux[i++];
//    }
}

//class Arrays implements Comparable<Arrays> {
//    private int[] arr;
//
//    Arrays(int[] arr) {
//        this.arr = arr;
//    }
//
//    int[] getArr() {
//        return this.arr;
//    }
//
//
//    @Override
//    public int compareTo(@NotNull Arrays obj) {
//        return 0;
//    }
//}