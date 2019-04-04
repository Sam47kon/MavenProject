package GolovachDecember2013.CoreProcedural1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MethodsInvertArrayTest {

    @Test
    void testInvertArray() {    // время работы 28 мс
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, new MethodsInvertArray().invertArray(new int[]{6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, new MethodsInvertArray().invertArray(new int[]{7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[0], new MethodsInvertArray().invertArray(new int[0]));
    }

    @Test
    void testInvertArrayRecurs() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, new MethodsInvertArray().invertArrayRecurs(new int[]{6, 5, 4, 3, 2, 1}, 0));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, new MethodsInvertArray().invertArrayRecurs(new int[]{7, 6, 5, 4, 3, 2, 1}, 0));
        Assertions.assertArrayEquals(new int[0], new MethodsInvertArray().invertArrayRecurs(new int[0], 0));
    }

    @Test
        // время работы 2 мс
    void invertArray2() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, new MethodsInvertArray().invertArray2(new int[]{6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, new MethodsInvertArray().invertArray2(new int[]{7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[0], new MethodsInvertArray().invertArray2(new int[0]));
    }
}