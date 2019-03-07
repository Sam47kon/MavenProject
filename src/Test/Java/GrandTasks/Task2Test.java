package GrandTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test extends Task2 {

    @Test
    void modalTest() {
        int a = -60;
        assertEquals(60, Modal(a));
    }
}