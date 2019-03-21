package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task19Test {

    @Test
    void testFindX() {
        int x = 125;
        int n = 152;
        Assertions.assertEquals(x, new Task19().findX(n));
    }
}