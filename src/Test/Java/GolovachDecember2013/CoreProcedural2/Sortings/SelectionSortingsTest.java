package GolovachDecember2013.CoreProcedural2.Sortings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static GolovachDecember2013.CoreProcedural2.Sortings.InsertionSort.insertionSort;
import static GolovachDecember2013.CoreProcedural2.Sortings.RuntimeSortings.ARR1;

class SelectionSortingsTest {

    @Test
    void testSelectiveSorting() {
        Assertions.assertArrayEquals(insertionSort(ARR1), SelectionSortings.selectiveSorting(ARR1, 0, ARR1.length - 1));
    }
}