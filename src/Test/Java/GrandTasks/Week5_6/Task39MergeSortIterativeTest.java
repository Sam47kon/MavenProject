package GrandTasks.Week5_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR3;

class Task39MergeSortIterativeTest {

    @Test
    void testMergeSortIterative() {
        int[] expectedArr = Arrays.copyOf(ARR3, ARR3.length);
        Arrays.sort(expectedArr);
        int[] actualArr = Arrays.copyOf(ARR3, ARR3.length);
        Task39MergeSortIterative.mergeSortIterative(actualArr);

        Assertions.assertArrayEquals(expectedArr, actualArr);
    }
}