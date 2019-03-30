package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task31ChineseCalendar1Test {

    @Test
    void testGetNameOfTheYearInTheChineseCalendar() {
        Assertions.assertEquals("1984 год - это год: Rat, Green по китайскому календарю.", new Task31ChineseCalendar1().getNameOfTheYearInTheChineseCalendar(1984));
    }
}