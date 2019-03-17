package GrandTasks.Week1;

import GrandTasks.Week1.Task1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {


    @Test
    public void getSquareTest() {
        int value = 5;
        Assertions.assertEquals(value * value, new Task1().getSquare(value));
    }
}