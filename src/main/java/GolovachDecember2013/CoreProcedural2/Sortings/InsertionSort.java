package GolovachDecember2013.CoreProcedural2.Sortings;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR1;

public class InsertionSort {    // сотрировки вставками

    public static void main(String[] args) {
        System.out.println(Arrays.toString(ARR1));
        int[] arr = insertionSort1(ARR1);
        System.out.println(Arrays.toString(arr));

    }

    static void insertionSort(int[] dataArr) {
        for (int barrier = 0; barrier < dataArr.length; barrier++) {
            int newElement = dataArr[barrier];
            int location = barrier - 1;
            while (location >= 0 && dataArr[location] > newElement) {
                dataArr[location + 1] = dataArr[location];
                location--;
            }
            dataArr[location + 1] = newElement;
        }
    }

    static int[] insertionSort1(int[] dataArr) {
        for (int barrier = 0; barrier < dataArr.length; barrier++) {
            int newElement = dataArr[barrier];
            int location = barrier - 1;
            int minBarrier = Arrays.binarySearch(dataArr, newElement); // TODO доделать
            while (location >= 0 && dataArr[location] > minBarrier) {
                dataArr[location + 1] = dataArr[location];
                location--;
            }
            dataArr[location + 1] = newElement;
        }
        return dataArr;
    }
}