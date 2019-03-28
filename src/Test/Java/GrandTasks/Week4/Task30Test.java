package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task30Test {

    @Test
    void testPrintSeason() {
        Assertions.assertEquals("Winter", new Task30().printSeason(1));
        Assertions.assertEquals("Winter", new Task30().printSeason(2));
        Assertions.assertEquals("Winter", new Task30().printSeason(3));
        Assertions.assertEquals("Spring", new Task30().printSeason(4));
        Assertions.assertEquals("Spring", new Task30().printSeason(5));
        Assertions.assertEquals("Spring", new Task30().printSeason(6));
        Assertions.assertEquals("Summer", new Task30().printSeason(9));
        Assertions.assertEquals("Autumn", new Task30().printSeason(12));
        Assertions.assertThrows(ExceptionInInitializerError.class, () -> new Task30().printSeason(30));
    }
}