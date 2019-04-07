package GrandTasks.Week5_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task37ComparableTest {

    @Test
    void testMergeArrays() {
        Integer[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] arr2 = {1, 2, 3, 9, 10, 11, 12, 13, 14, 15};
        Comparable[] mergeArr1Arr2 = {1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 9, 10, 10, 11, 12, 13, 14, 15};
        Assertions.assertArrayEquals(mergeArr1Arr2, Task37Comparable.mergeArrays(arr1, arr2));

        String[] str = {"A", "D", "V"};
        String[] str2 = {"B", "C", "Z"};
        String[] mergeStr1Str2 = {"A", "B", "C", "D", "V", "Z"};
        Assertions.assertArrayEquals(mergeStr1Str2, Task37Comparable.mergeArrays(str, str2));

        Assertions.assertThrows(ClassCastException.class, () -> Task37Comparable.mergeArrays(str, arr2));
    }
}