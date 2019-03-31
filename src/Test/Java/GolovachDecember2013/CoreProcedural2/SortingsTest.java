package GolovachDecember2013.CoreProcedural2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortingsTest {

    private static final int[] ARR = {1, 6, 2, 5, 6, 3, 2, 6, -99, 234234, 342};
    private static final int[] ARR2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test
    void testSortBubble1() {
        Assertions.assertArrayEquals(new int[]{-99, 1, 2, 2, 3, 5, 6, 6, 6, 342, 234234}, Sortings.sortBubble1(ARR));
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sortings.sortBubble1(ARR2));
    }

    @Test
    void testSortBubble2() {
        Assertions.assertArrayEquals(new int[]{-99, 1, 2, 2, 3, 5, 6, 6, 6, 342, 234234}, Sortings.sortBubble2(ARR));
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sortings.sortBubble2(ARR2));
    }

    @Test
    void sortExample() {
        Assertions.assertArrayEquals(new int[]{-99, 1, 2, 2, 3, 5, 6, 6, 6, 342, 234234}, Sortings.sortExample(ARR));
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Sortings.sortExample(ARR2));
    }
}