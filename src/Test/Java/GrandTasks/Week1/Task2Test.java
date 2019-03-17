package GrandTasks.Week1;

import GrandTasks.Week1.Task2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2Test {


    @Test
    void getModalTest() {
        int number = -60;
        Assertions.assertEquals(60, new Task2().getModal(number));
    }
}