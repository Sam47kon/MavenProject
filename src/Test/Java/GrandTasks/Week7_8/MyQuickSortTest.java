package GrandTasks.Week7_8;

import JavaHeadFirstAndOther.Comparsion.ClassPerson.Person;
import JavaHeadFirstAndOther.Comparsion.ClassPerson.PersonAgeComparator;
import JavaHeadFirstAndOther.Comparsion.ClassPerson.PersonNameComparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MyQuickSortTest {
    private Person[] people = new Person[16];

    @BeforeEach
    void beforeEach() {
        people[0] = new Person("Tom", 1);
        people[1] = new Person("Tom", 1);
        people[2] = new Person("Tom", 2);
        people[3] = new Person("Andrey", 1);
        people[4] = new Person("Andrey", 2);
        people[5] = new Person("Alina", 2);
        people[6] = new Person("Andrey", 2);
        people[7] = new Person("Alina", 1);
        people[8] = new Person("Ilya", 23);
        people[9] = new Person("ilYA", 15);
        people[10] = new Person("ilYa", 15);
        people[11] = new Person("ilya", 15);
        people[12] = new Person("Ilya", 15);
        people[13] = new Person("ILya", 15);
        people[14] = new Person("ILYa", 15);
        people[15] = new Person("ILYA", 15);
        System.out.println(Arrays.toString(people));
    }

    @AfterEach
    void afterEach() {
        System.out.println(Arrays.toString(people));
    }

    @Test
    void testQuickSortWithComparator() {
        new MyQuickSort<Person>().QuickSortWithComparator(people, new PersonNameComparator().thenComparing(new PersonAgeComparator()));
        Assertions.assertEquals("[Alina, 1, Alina, 2, Andrey, 1, Andrey, 2, Andrey, 2, ILYA, 15, ILYa, 15, ILya, 15, Ilya, 15, Ilya, 23, Tom, 1, Tom, 1, Tom, 2, ilYA, 15, ilYa, 15, ilya, 15]",
                Arrays.toString(people));
    }

    @Test
    void testQuickSortDefault() {
        new MyQuickSort<Person>().QuickSortDefault(people);
        Assertions.assertEquals("[Tom, 1, Tom, 1, Tom, 2, ILYA, 15, ILYa, 15, ILya, 15, Ilya, 15, Ilya, 23, ilYA, 15, ilYa, 15, ilya, 15, Alina, 1, Alina, 2, Andrey, 1, Andrey, 2, Andrey, 2]",
                Arrays.toString(people));
    }

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------

    @Test
    void testHashCode() {
        for (Person person : people) {
            System.out.println(person.toString());
        }

        int p0HC = people[0].hashCode();
        int p1HC = people[1].hashCode();
        int p2HC = people[2].hashCode();
        int p3HC = people[3].hashCode();
        int p4HC = people[4].hashCode();
        int p5HC = people[5].hashCode();
        Assertions.assertEquals(p0HC, people[0].hashCode());
        Assertions.assertEquals(people[0].hashCode(), people[0].hashCode());

        Assertions.assertEquals(p1HC, people[1].hashCode());
        Assertions.assertEquals(people[0].hashCode(), people[1].hashCode());
        Assertions.assertEquals(p0HC, p1HC);

        Assertions.assertNotEquals(p0HC, p2HC);
        Assertions.assertNotEquals(p0HC, p3HC);
        Assertions.assertNotEquals(p0HC, p4HC);
        Assertions.assertNotEquals(p0HC, p5HC);
    }

    @Test
    void testEquals() {
//        Assertions.assertTrue(people[0].equals(people[1]));
//        Assertions.assertFalse(people[0].equals(people[2]));
//        или так
        Assertions.assertEquals(people[0], people[1]);
        Assertions.assertNotEquals(people[0], people[2]);

        Assertions.assertEquals(people[1], people[0]);
        Assertions.assertEquals(people[1], people[1]);
        Assertions.assertEquals(people[0], people[0]);
        Assertions.assertNotEquals(people[2], people[0]);
        Assertions.assertNotEquals(people[3], people[0]);
        Assertions.assertNotEquals(people[4], people[0]);
        Assertions.assertNotEquals(people[5], people[0]);
    }
}