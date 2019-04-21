package GrandTasks.Week7_8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static MyMethods.MyMethods.fillIntegerArray;

class ComparableQuickSortTest {

    @Test
    void testComparableQuickSort() {
        Integer[] expected1 = new Integer[1];
        Integer[] expected2 = new Integer[5_000];
        Integer[] expected3 = new Integer[5_000_000];
        fillIntegerArray(expected1);
        fillIntegerArray(expected2);
        fillIntegerArray(expected3);
        Integer[] actual1 = Arrays.copyOf(expected1, expected1.length);
        Integer[] actual2 = Arrays.copyOf(expected2, expected2.length);
        Integer[] actual3 = Arrays.copyOf(expected3, expected3.length);

        Arrays.sort(expected1);
        Arrays.sort(expected2);
        Arrays.sort(expected3);
        new ComparableQuickSort().comparableQuickSort(actual1);
        new ComparableQuickSort().comparableQuickSort(actual2);
        new ComparableQuickSort().comparableQuickSort(actual3);

        Assertions.assertArrayEquals(expected1, actual1);
        Assertions.assertArrayEquals(expected2, actual2);
        Assertions.assertArrayEquals(expected3, actual3);
    }
}