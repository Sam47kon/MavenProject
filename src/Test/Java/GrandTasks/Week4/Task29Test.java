package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static GrandTasks.Week4.Task29.Days.*;

class Task29Test {

    @Test
    void whyDay() {
        Assertions.assertEquals("WORKING_DAY", new Task29().whyDay(1).toString());
        Assertions.assertEquals(WORKING_DAY, new Task29().whyDay(5));
        Assertions.assertEquals(WORKING_DAY, new Task29().whyDay(8));
        Assertions.assertEquals(WORKING_DAY, new Task29().whyDay(12));
        Assertions.assertEquals(WORKING_DAY, new Task29().whyDay(15));
        Assertions.assertEquals(WORKING_DAY, new Task29().whyDay(19));

        Assertions.assertEquals(SATURDAY, new Task29().whyDay(6));
        Assertions.assertEquals(SUNDAY, new Task29().whyDay(7));
        Assertions.assertEquals(SATURDAY, new Task29().whyDay(13));
        Assertions.assertEquals(SUNDAY, new Task29().whyDay(14));

        Assertions.assertEquals(SUNDAY, new Task29().whyDay(49));
        Assertions.assertEquals(SATURDAY, new Task29().whyDay(48));
        Assertions.assertEquals(SUNDAY, new Task29().whyDay(42));
        Assertions.assertEquals(SATURDAY, new Task29().whyDay(41));

    }
}