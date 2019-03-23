package GrandTasks.Week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task23Test {

    @Test
    void testGetAge() {
        Assertions.assertEquals(23, new Task23().getAge(1995, 11, 2019, 3));
        Assertions.assertEquals(25, new Task23().getAge(1994, 10, 2020, 4));
        Assertions.assertEquals(24, new Task23().getAge(1995, 11, 2019, 11));
    }

    @Test
    void getFullAge() {
        Assertions.assertEquals(23, new Task23().getFullAge(1995, 11, 18, 2019, 3, 23));
        Assertions.assertEquals(24, new Task23().getFullAge(1995, 11, 18, 2019, 11, 18));
        Assertions.assertEquals(23, new Task23().getFullAge(1995, 11, 18, 2019, 11, 17));
        Assertions.assertEquals(24, new Task23().getFullAge(1995, 11, 18, 2019, 12, 30));
        Assertions.assertEquals(77, new Task23().getFullAge(1943, 3, 23, 2020, 3, 23));
    }
}