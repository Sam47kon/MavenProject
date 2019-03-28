package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task29Test {

    @Test
    void whyDay() {
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(1));
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(5));
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(8));
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(12));
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(15));
        Assertions.assertEquals("Рабочий день", new Task29().whyDay(19));

        Assertions.assertEquals("Суббота", new Task29().whyDay(6));
        Assertions.assertEquals("Воскресение", new Task29().whyDay(7));
        Assertions.assertEquals("Суббота", new Task29().whyDay(13));
        Assertions.assertEquals("Воскресение", new Task29().whyDay(14));

        Assertions.assertEquals("Воскресение", new Task29().whyDay(49));
        Assertions.assertEquals("Суббота", new Task29().whyDay(48));
        Assertions.assertEquals("Воскресение", new Task29().whyDay(42));
        Assertions.assertEquals("Суббота", new Task29().whyDay(41));

    }
}