package GrandTasks.Week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task31ChineseCalendarTest {

    @Test
    void testGetYearOfTheAnimal() {
        Assertions.assertEquals("Rat", new Task31ChineseCalendar().getYearOfTheAnimal(1));
        Assertions.assertEquals("Cow", new Task31ChineseCalendar().getYearOfTheAnimal(2));
        Assertions.assertEquals("Tiger", new Task31ChineseCalendar().getYearOfTheAnimal(3));
        Assertions.assertEquals("Hare", new Task31ChineseCalendar().getYearOfTheAnimal(4));
        Assertions.assertEquals("Dragon", new Task31ChineseCalendar().getYearOfTheAnimal(5));
        Assertions.assertEquals("Snake", new Task31ChineseCalendar().getYearOfTheAnimal(6));
        Assertions.assertEquals("Horse", new Task31ChineseCalendar().getYearOfTheAnimal(7));
        Assertions.assertEquals("Sheep", new Task31ChineseCalendar().getYearOfTheAnimal(8));
        Assertions.assertEquals("Monkey", new Task31ChineseCalendar().getYearOfTheAnimal(9));
        Assertions.assertEquals("Rooster", new Task31ChineseCalendar().getYearOfTheAnimal(10));
        Assertions.assertEquals("Dog", new Task31ChineseCalendar().getYearOfTheAnimal(11));
        Assertions.assertEquals("Pig", new Task31ChineseCalendar().getYearOfTheAnimal(12));
        Assertions.assertEquals("Rat", new Task31ChineseCalendar().getYearOfTheAnimal(13));
    }

    @Test
    void getYearOfTheElementOfNature() {
        Assertions.assertEquals("Green", new Task31ChineseCalendar().getYearOfTheElementOfNature(1));
        Assertions.assertEquals("Green", new Task31ChineseCalendar().getYearOfTheElementOfNature(2));
        Assertions.assertEquals("Red", new Task31ChineseCalendar().getYearOfTheElementOfNature(3));
        Assertions.assertEquals("Red", new Task31ChineseCalendar().getYearOfTheElementOfNature(4));
        Assertions.assertEquals("Yellow", new Task31ChineseCalendar().getYearOfTheElementOfNature(5));
        Assertions.assertEquals("Yellow", new Task31ChineseCalendar().getYearOfTheElementOfNature(6));
        Assertions.assertEquals("White", new Task31ChineseCalendar().getYearOfTheElementOfNature(7));
        Assertions.assertEquals("White", new Task31ChineseCalendar().getYearOfTheElementOfNature(8));
        Assertions.assertEquals("Black", new Task31ChineseCalendar().getYearOfTheElementOfNature(9));
        Assertions.assertEquals("Black", new Task31ChineseCalendar().getYearOfTheElementOfNature(10));
        Assertions.assertEquals("Green", new Task31ChineseCalendar().getYearOfTheElementOfNature(11));
        Assertions.assertEquals("Green", new Task31ChineseCalendar().getYearOfTheElementOfNature(12));
        Assertions.assertEquals("Red", new Task31ChineseCalendar().getYearOfTheElementOfNature(13));
        Assertions.assertEquals("Black", new Task31ChineseCalendar().getYearOfTheElementOfNature(20));
    }

    @Test
    void getNameOfTheYearInTheChineseCalendar() {
        Assertions.assertEquals("5 год - это год: Dragon, Yellow по китайскому календарю.", new Task31ChineseCalendar().getNameOfTheYearInTheChineseCalendar(5));
        Assertions.assertEquals("1984 год - это год: Hare, Red по китайскому календарю.", new Task31ChineseCalendar().getNameOfTheYearInTheChineseCalendar(1984));
    }
}