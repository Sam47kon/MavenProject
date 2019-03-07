package GrandTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task3Test extends Task3 {

    @Test
    void sumTest() {
        int a = 5;
        int b = 10;
        assertEquals(Sum(a, b), a + b);
    }
}