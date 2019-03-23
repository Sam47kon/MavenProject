package GolovachDecember2013;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoreProcedural1Test {

    @Test
    void testInvertArray() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, new CoreProcedural1().invertArray(new int[]{6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, new CoreProcedural1().invertArray(new int[]{7, 6, 5, 4, 3, 2, 1}));
        Assertions.assertArrayEquals(new int[0], new CoreProcedural1().invertArray(new int[0]));
    }

    @Test
    void invertArrayRecurs() {
    }
}