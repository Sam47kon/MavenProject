package GrandTasks.Week5_6;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Task40CustomArrayListTrueTest {
    //  add, isEmpty, size, set, get, remove,  addAll, containsAll
//    private List<String> testList = new ArrayList<>();
//    private List<String> testAddList = new ArrayList<>();

    private Task40CustomArrayListTrue testList = new Task40CustomArrayListTrue();
    private Task40CustomArrayListTrue testAddList = new Task40CustomArrayListTrue();


    @BeforeEach
    void beforeEachFunctions() {
        testList.add("value1 i0");           // 0
        testList.add("oldValue i1");         // 1
        testList.add("value3 i2");           // 2
        testList.add("value4 i3 remove");    // 3
        testList.add("value5 i4 remove");    // 4

        testAddList.add("value1");
        testAddList.add("value2");
        testAddList.add("value3");
    }

    @AfterEach
    void afterEachFunctions() {
        System.out.println(testList);
        System.out.println(testAddList);
    }


    @Test
    void testAdd() {
        Assertions.assertTrue(testList.add("value6 i5"));
        Assertions.assertTrue(testList.add("value7 i6"));
    }

    @Test
    void testIsEmpty() {
        Assertions.assertFalse(testList.isEmpty());
    }

    @Test
    void testSize() {
        Assertions.assertEquals(5, testList.size());
    }

    @Test
    void testSet() {
        Assertions.assertEquals("oldValue i1", testList.set(1, "newValue1"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.set(5, "unable to replace non-existent object"));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.set(-2, "index can not be negative"));
    }

    @Test
    void testGet() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.get(5));
        Assertions.assertEquals("value1 i0", testList.get(0));
        Assertions.assertEquals("value3 i2", testList.get(2));
    }

    @Test
    void testRemove() {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> testList.remove(5));
        Assertions.assertEquals("value4 i3 remove", testList.remove(3));
        Assertions.assertTrue(testList.remove("value5 i4 remove"));
    }

    @Test
    void testContains() {
        Assertions.assertTrue(testList.contains("value1 i0"));
        Assertions.assertTrue(testList.contains("oldValue i1"));
        Assertions.assertFalse(testList.contains("value does not exist"));
    }

    @Test
    void testContainsAll() {
        Assertions.assertFalse(testList.containsAll(testAddList));
        testList.addAll(testAddList);
        Assertions.assertTrue(testList.containsAll(testAddList));
    }

    @Test
    void testAddAll() {
        Assertions.assertTrue(testList.addAll(testAddList));
        Assertions.assertTrue(testList.addAll(0, testAddList));
    }
}
