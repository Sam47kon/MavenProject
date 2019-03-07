package GrandTasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test extends Task1 {

    @Test
    public void TestSquare() {
        int a = 5;
        assertEquals(Square(a), a * a);

    }
}