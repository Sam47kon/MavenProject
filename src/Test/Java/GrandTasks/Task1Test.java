package GrandTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1Test {


    @Test
    public void squareTest() {
        int value = 5;
        Assertions.assertEquals(value * value, new Task1().getSquare(value));
    }
}