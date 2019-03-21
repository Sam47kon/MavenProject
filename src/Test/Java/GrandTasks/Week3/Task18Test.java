package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task18Test {

    @Test
    void findX() {
        int x = 125;
        int n = 152;
        Assertions.assertEquals(x, new Task18().findX(n));
    }
}