package GrandTasks.Week5_6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class CustomArrayListTest {
    private CustomArrayList myList = new CustomArrayList();
    private CustomArrayList addList = new CustomArrayList();
    private CustomArrayList deletedList = new CustomArrayList();


    @BeforeEach
    void beforeEachFunctions() {
        myList.add("1");      // 0
        myList.add("2");      // 1
        myList.add("3");      // 2
        myList.add("4");      // 3
        myList.add("6");      // 4
        myList.add(4, "5");   // 5

        addList.add("11");
        addList.add("22");
        addList.add("33");

        deletedList.add("7");      // 0
        deletedList.add("1");      // 1
        deletedList.add("3");      // 2
        deletedList.add("2");      // 3
        deletedList.add("99");      // 4

        System.out.println("Before:");
        System.out.println("myList: Size = " + myList.size() + ", elements - " + myList.toString());
        System.out.println("addList: Size = " + addList.size() + ", elements - " + addList.toString());
        System.out.println("deletedList: Size = " + deletedList.size() + ", elements - " + deletedList.toString());
    }

    @AfterEach
    void afterEachFunctions() {
        System.out.println("After:");
        System.out.println("myList: Size = " + myList.size() + ", elements - " + myList.toString());
        System.out.println("addList: Size = " + addList.size() + ", elements - " + addList.toString());
        System.out.println("deletedList: Size = " + deletedList.size() + ", elements - " + deletedList.toString());
    }


    @Test
    void testSize() {
        Assertions.assertEquals(6, myList.size());
    }

    @Test
    void testIsEmpty() {
        Assertions.assertFalse(myList.isEmpty());
    }

    @Test
    void testContains() {
        Assertions.assertTrue(myList.contains("1"));
        Assertions.assertTrue(myList.contains("2"));
        Assertions.assertFalse(myList.contains("value does not exist"));
    }

    @Test
    void testToArray() {
        String[] expected = {"1", "2", "3", "4", "5", "6"};
        Assertions.assertArrayEquals(expected, myList.toArray());
    }

    @Test
    void testAdd() {
        Assertions.assertTrue(myList.add("7"));
        Assertions.assertTrue(myList.add("8"));
        Assertions.assertEquals("7", myList.get(6));
        Assertions.assertEquals("8", myList.get(7));
    }

    @Test
    void testAdd1() {
        Assertions.assertEquals("5", myList.get(4));
    }

    @Test
    void testRemove() {
        Assertions.assertEquals(6, myList.size());
        Assertions.assertEquals("1", myList.remove(0));
        Assertions.assertEquals("2", myList.remove(0));
        Assertions.assertTrue(myList.remove("3"));
        Assertions.assertTrue(myList.remove("5"));
        Assertions.assertTrue(myList.remove("6"));
        Assertions.assertEquals(1, myList.size());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.remove(7));
    }

    @Test
    void testAddAll() {
        Assertions.assertTrue(myList.addAll(addList));
    }

    @Test
    void testAddAll1() {
        Assertions.assertTrue(myList.addAll(0, addList));
        System.out.println(myList.toString());
        Assertions.assertTrue(myList.addAll(2, addList));
        System.out.println(myList.toString());
        Assertions.assertTrue(myList.addAll(6, addList));
        System.out.println(myList.toString());
    }

    @Test
    void testClear() {
        myList.clear();
        Assertions.assertEquals(0, myList.size());
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(0));
    }

    @Test
    void testGet() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.get(7));
        Assertions.assertEquals("1", myList.get(0));
        Assertions.assertEquals("3", myList.get(2));
    }

    @Test
    void testSet() {
        Assertions.assertEquals("2", myList.set(1, "newValue2"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.set(7, "unable to replace non-existent object"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myList.set(-2, "index can not be negative"));
    }

    @Test
    void testIndexOf() {
        Assertions.assertEquals(-1, myList.indexOf("value does not exist"));
        Assertions.assertEquals(0, myList.indexOf("1"));
        Assertions.assertEquals(1, myList.indexOf("2"));
    }

    @Test
    void testLastIndexOf() {
        Assertions.assertEquals(-1, myList.indexOf("value does not exist"));
        Assertions.assertEquals(0, myList.indexOf("1"));
        Assertions.assertEquals(1, myList.indexOf("2"));
    }

    @Test
    void removeAll() {
        Assertions.assertTrue(myList.removeAll(deletedList));
        Assertions.assertEquals("4", myList.get(0));

        Assertions.assertFalse(addList.removeAll(deletedList));
        Assertions.assertEquals("11", addList.get(0));
    }

    @Test
    void testContainsAll() {
        Assertions.assertFalse(myList.containsAll(addList));
        myList.addAll(addList);
        Assertions.assertTrue(myList.containsAll(addList));
    }

    @Test
    void testToArray1() {
        Object[] o = addList.toArray();
        System.out.println(Arrays.toString(o));
        System.out.println(Arrays.toString(myList.toArray(o)));
    }
}
