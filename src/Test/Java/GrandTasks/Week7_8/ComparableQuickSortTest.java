package GrandTasks.Week7_8;

import MyStaticMethods.MyMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ComparableQuickSortTest {

    @Test
    void testComparableQuickSortInteger() {
        Integer[] expected1 = new Integer[1];
        Integer[] expected2 = new Integer[5_000];
        Integer[] expected3 = new Integer[5_000_000];
        MyMethods.fillIntegerArray(expected1);
        MyMethods.fillIntegerArray(expected2);
        MyMethods.fillIntegerArray(expected3);
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

    @Test
    void testComparableQuickSortString() {
        String[] expected1 = new String[1];
        String[] expected2 = new String[5_000];
        String[] expected3 = new String[5_000_000];
        MyMethods.fillStringArray(expected1);
        MyMethods.fillStringArray(expected2);
        MyMethods.fillStringArray(expected3);
        String[] actual1 = Arrays.copyOf(expected1, expected1.length);
        String[] actual2 = Arrays.copyOf(expected2, expected2.length);
        String[] actual3 = Arrays.copyOf(expected3, expected3.length);

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