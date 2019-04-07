package GrandTasks.Week5_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR3;

class Task38MergeSortRecursTest {

    @Test
    void testMergeSort() {
        int[] sortArr = Arrays.copyOf(ARR3, ARR3.length);
        Arrays.sort(sortArr);
        Assertions.assertArrayEquals(sortArr, Task38MergeSortRecurs.mergeSort(ARR3));
    }
}