package GrandTasks.Week2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task12Test {

    @Test
    void getRootsOfEquation() {
        double a, b, c;
        a = 4;
        b = -7;
        c = 0;
        Assertions.assertEquals(1.75, new Task12().deriveRootValue(a, b, c, true));
        Assertions.assertEquals(0, new Task12().deriveRootValue(a, b, c, false));
        a = 2;
        b = 9;
        c = -5;
        Assertions.assertEquals(0.5, new Task12().deriveRootValue(a, b, c, true));
        Assertions.assertEquals(-5, new Task12().deriveRootValue(a, b, c, false));
        a = 5;
        b = 0;
        c = 0;
        Assertions.assertEquals(0, -1 * new Task12().deriveRootValue(a, b, c, true));
        Assertions.assertEquals(0, (-1) * new Task12().deriveRootValue(a, b, c, false));
        a = 0;
        b = 5;
        c = 4;
        Assertions.assertEquals(-0.8, new Task12().deriveRootValue(a, b, c, true));


    }
}