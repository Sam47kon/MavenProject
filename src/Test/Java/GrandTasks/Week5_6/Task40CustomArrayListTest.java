package GrandTasks.Week5_6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task40CustomArrayListTest {
    //  add, isEmpty, size, set, get, remove,  addAll, containsAll
    private List<String> list = new ArrayList<>();

    @Test
    void testAdd() {
        Assertions.assertTrue(list.add("1"));
        Assertions.assertTrue(list.add("2"));
    }

    @Test
    void testIsEmpty() {
        Assertions.assertTrue(list.isEmpty());
        list.add("1");
        Assertions.assertFalse(list.isEmpty());
        list.get(0);
    }

    @Test
    void testSize() {
        Assertions.assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        Assertions.assertEquals(2, list.size());
        list.add("3");
        Assertions.assertEquals(3, list.size());
    }

    @Test
    void testSet() {
        list.add("1");
        list.add("oldValue");
        Assertions.assertEquals("oldValue", list.set(1, "newValue1"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(2, "newValue2"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(-2, "newValue2"));
    }

    @Test
    void testGet() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        list.add("value1 index0");
        Assertions.assertEquals("value1 index0", list.get(0));
        list.add("value2 index1");
        Assertions.assertEquals("value1 index0", list.get(1));
    }

    @Test
    void testRemove() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        list.add("value1 index0 delete");
        list.add("value2 index1 delete");
        list.add("value3 index2");
        list.add("value4 index3");
        Assertions.assertEquals("value1 index0 delete", list.remove(0));
        Assertions.assertTrue(list.remove("value2 index1 delete"));
    }

    @Test
    void testAddAll() {
        List<String> testList = new ArrayList<>();
        testList.add("value1");
        testList.add("value2");
        testList.add("value3");
        Assertions.assertTrue(list.addAll(testList));
        Assertions.assertTrue(list.addAll(0, testList));
    }

    @Test
    void testContains() {
        list.add("value1");
        list.add("value2");
        list.add("value3");
        list.add("value4");
        Assertions.assertTrue(list.contains("value1"));
        Assertions.assertTrue(list.contains("value4"));
        Assertions.assertFalse(list.contains("value5"));
    }

    @Test
    void testContainsAll() {
        List<String> testList = new ArrayList<>();
        testList.add("value1");
        testList.add("value2");
        testList.add("value3");
        Assertions.assertFalse(list.containsAll(testList));
        list.addAll(testList);
        Assertions.assertTrue(list.containsAll(testList));
    }
}
