package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {


    @Test
    void getModalTest() {
        int number = -60;
        Assertions.assertEquals(60, new Task2().getModal(number));
    }
}