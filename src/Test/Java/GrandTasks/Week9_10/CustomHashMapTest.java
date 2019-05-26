package GrandTasks.Week9_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static MyMethods.MyMethods.createRandomArrayWithSize;

class CustomHashMapTest {
    private HashMap<Integer, Integer> libraryMap = new HashMap<>();
    private CustomHashMap<Integer, Integer> myMap = new CustomHashMap<>();
    private double startTime;
    private double stopTime;
    private double runTime;
    private static final Integer capacity = 1_000_000;

    @BeforeEach
    void before() {
        Integer[] arr = createRandomArrayWithSize(capacity);    // для разгона машины

        System.out.println("before:");

        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            libraryMap.put(i, i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            myMap.put(i, i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put      = " + runTime + "ms");

        System.out.println("after:");
    }

    @Test
    void size() {
        Assertions.assertEquals(capacity, myMap.size());
        Assertions.assertEquals(capacity, libraryMap.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(libraryMap.isEmpty());
        Assertions.assertFalse(myMap.isEmpty());
        myMap.clear();
        libraryMap.clear();
        Assertions.assertTrue(libraryMap.isEmpty());
        Assertions.assertTrue(myMap.isEmpty());

    }

    @Test
    void containsKey() {
        System.out.println("test containsKey");
        System.out.println("containsKey every existing key:");
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertTrue(libraryMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsKey = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertTrue(myMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsKey      = " + runTime + "ms");


        System.out.println("containsKey 1_000_000 times nonexistent key:");
        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertFalse(libraryMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsKey = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertFalse(myMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsKey      = " + runTime + "ms");
    }

    @Test
    void containsValue() {
        System.out.println("test containsValue");
        System.out.println("containsValue 10_000 times (existing value):");
        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            Assertions.assertTrue(libraryMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            Assertions.assertTrue(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue      = " + runTime + "ms");


        System.out.println("containsValue 100 times (nonexistent value):");
        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity + 100; i++) {
            Assertions.assertFalse(libraryMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity + 100; i++) {
            Assertions.assertFalse(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue      = " + runTime + "ms");

    }

    @Test
    void get() {
        System.out.println("test get");
        System.out.println("get every existing key:");
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get from 0 to size = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get      from 0 to size = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = capacity - 1; i >= 0; i--) {
            Assertions.assertEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get from size to 0 = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity - 1; i >= 0; i--) {
            Assertions.assertEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get      from size to 0 = " + runTime + "ms");


        System.out.println("get 1_000_000 times nonexistent key: ");
        startTime = System.nanoTime();
        for (Integer i = capacity; i < 2_000_000; i++) {
            Assertions.assertNotEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i <= 2_000_000; i++) {
            Assertions.assertNotEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get      = " + runTime + "ms");
    }

    @Test
    void put() {
        System.out.println("test put");
        System.out.println("put (newKey, newValue) 1_000_000 times:");
        startTime = System.nanoTime();
        for (int i = capacity; i < capacity * 2; i++) {
            Assertions.assertNull(libraryMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = capacity; i < capacity * 2; i++) {
            Assertions.assertNull(myMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put      = " + runTime + "ms");


        System.out.println("put (ExistKey, not important) 1_000_000 times:");
        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, libraryMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, myMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put      = " + runTime + "ms");
    }

    @Test
    void remove() {
        System.out.println("test remove");
        System.out.println("remove (nonexistent key) 10_000_000 times:");
        startTime = System.nanoTime();
        for (int i = capacity; i <= 10_000_000; i++) {
            Assertions.assertNull(libraryMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.remove = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = capacity; i <= 10_000_000; i++) {
            Assertions.assertNull(myMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.remove       = " + runTime + "ms");


        System.out.println("remove (each existing key) 10_000_000 times:");
        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, libraryMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.remove = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, myMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.remove      = " + runTime + "ms");

        Assertions.assertEquals(0, libraryMap.size());
        Assertions.assertEquals(0, myMap.size());
    }

    @Test
    void clear() {
        libraryMap.clear();
        myMap.clear();
        Assertions.assertEquals(0, libraryMap.size());
        Assertions.assertEquals(0, myMap.size());
        Assertions.assertNull(libraryMap.get(0));
        Assertions.assertNull(myMap.get(0));
        Assertions.assertNull(libraryMap.get(5000));
        Assertions.assertNull(myMap.get(5000));
        Assertions.assertNull(libraryMap.get(999999));
        Assertions.assertNull(myMap.get(999999));
    }

    @Test
    void keySet() {
        Assertions.assertEquals(capacity, libraryMap.keySet().size());
        Assertions.assertEquals(capacity, myMap.keySet().size());

        Set<Integer> set = new TreeSet<>();
        for (Integer i = 0; i < capacity; i++) {
            set.add(i);
        }
        Assertions.assertTrue(set.containsAll(libraryMap.keySet()));
        Assertions.assertTrue(set.containsAll(myMap.keySet()));
        set.remove(capacity - 1);
        Assertions.assertFalse(set.containsAll(libraryMap.keySet()));
        Assertions.assertFalse(set.containsAll(myMap.keySet()));
    }

    @Test
    void values() {
        Assertions.assertEquals(capacity, libraryMap.values().size());
        Assertions.assertEquals(capacity, myMap.values().size());

        Collection<Integer> collections = new TreeSet<>();
        for (Integer i = 0; i < capacity; i++) {
            collections.add(i);
        }
        Assertions.assertTrue(collections.containsAll(libraryMap.values()));
        Assertions.assertTrue(collections.containsAll(myMap.values()));
        collections.remove(capacity - 1);
        Assertions.assertFalse(collections.containsAll(libraryMap.values()));
        Assertions.assertFalse(collections.containsAll(myMap.values()));
    }

    @Test
    void entrySet() {
        System.out.println("test entrySet");
        System.out.println("entrySet 10 times (1_000_000 pairs):");
        Set set = myMap.entrySet();

        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            set = myMap.entrySet();
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.entrySet()      = " + runTime + "ms");
        Assertions.assertEquals(capacity, set.size());


        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            set = libraryMap.entrySet();
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.entrySet() = " + runTime + "ms");
        Assertions.assertEquals(capacity, set.size());

    }

}