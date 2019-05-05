package GrandTasks.Week7_8;

import java.util.Comparator;

public class MyQuickSort<T> {

    public void QuickSortWithComparator(T[] array, Comparator<T> comparator) {
        comparableQuickSort(array, 0, array.length - 1, comparator);
    }

    /**
     * Подходит только для Integer, String, Char
     *
     * @param array - массив
     */
    public void QuickSortDefault(T[] array) {
        comparableQuickSort(array, 0, array.length - 1, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.hashCode() - o2.hashCode();   // тут реализую
            }
        });
    }

    private void comparableQuickSort(T[] array, int start, int end, Comparator<T> comparator) {
        if (array.length == 0) {   //завершить выполнение если длина массива равна 0
            return;
        }
        if (start >= end) {    //завершить выполнение если уже нечего делить
            return;
        }
        // выбрать опорный элемент - середину
        int middle = start + (end - start) / 2;
        T prop = array[middle];    // опора

        // разделить на подмассивы, который больше и меньше опорного элемента
        int left = start;
        int right = end;
        while (left <= right) {
            while (comparator.compare(array[left], prop) < 0) {
                left++;
            }

            while (comparator.compare(array[right], prop) > 0) {
                right--;
            }

            if (left <= right) {     //меняем местами
                T temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }
        if (start < right) {     // рекурсия сортировки для левой части
            comparableQuickSort(array, start, right, comparator);
        }
        if (end > left) {      // рекурсия сортировки для правой части
            comparableQuickSort(array, left, end, comparator);
        }
    }
}

