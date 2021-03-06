package GolovachDecember2013.CoreProcedural2.Sortings;

import java.util.Random;

class SelectionSortings {      // сортировки выборками

    static void selectionSort1(int[] dataArr) {
        for (int barrier = 0; barrier < dataArr.length - 1; barrier++) {
            for (int index = barrier + 1; index < dataArr.length; index++) {
                if (dataArr[barrier] > dataArr[index]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[barrier];
                    dataArr[barrier] = tmp;
                }
            }
        }
    }

    static int[] selectiveSorting(int[] dataArray, int leftBarrier, int rightBarrier) {   // выборочная сортировка (определенного отрезка)
        int i = leftBarrier;
        int j = rightBarrier;
        Random random = new Random();
        int x = dataArray[leftBarrier + random.nextInt(rightBarrier - leftBarrier + 1)];
        while (i <= j) {    // сравнивания, compare
            while (dataArray[i] < x) {
                i++;
            }
            while (dataArray[j] > x) {
                j--;
            }
            if (i <= j) {    //  перемены элементов местами, swap
                int temp = dataArray[i];
                dataArray[i] = dataArray[j];
                dataArray[j] = temp;
                i++;
                j--;
            }
        }
        if (leftBarrier < j) {
            selectiveSorting(dataArray, leftBarrier, j);
        }
        if (i < rightBarrier) {
            selectiveSorting(dataArray, i, rightBarrier);
        }
        return dataArray;
    }

    static void selectionSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    static void selectionSortDouble(double[] arr) {       // нашел в инете, разобрал, понял
        // По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...)
        for (int i = 0; i < arr.length; i++) {
            // Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
            double min = arr[i];
            int min_i = i;
            // В оставшейся части подмножества ищем элемент, который меньше предположенного минимума
            for (int j = i + 1; j < arr.length; j++) {
                // Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            // Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
}
