package GrandTasks.Week9_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class CustomHashMapTest {
    private HashMap<Integer, Integer> libraryMap = new HashMap<>();
    private CustomHashMap<Integer, Integer> myMap = new CustomHashMap<>();
    private double startTime;
    private double stopTime;
    private double runTime;
    private static final Integer capacity = 1_000_000;

    @BeforeEach
    void before() {
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
        System.out.println("runTime myMap.put = " + runTime + "ms");


    }

    @Test
    void size() {
        Assertions.assertEquals(capacity, myMap.size());
        Assertions.assertEquals(capacity, myMap.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(libraryMap.isEmpty());
        Assertions.assertFalse(myMap.isEmpty());
    }

    @Test
    void containsKey() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            Assertions.assertTrue(libraryMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsKey (true) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 2_000_000; i++) {
            Assertions.assertFalse(libraryMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsKey (false) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            Assertions.assertTrue(myMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsKey (true) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 2_000_000; i++) {
            Assertions.assertFalse(myMap.containsKey(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsKey (false) = " + runTime + "ms");
    }

    @Test
    void containsValue() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            Assertions.assertTrue(libraryMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue 10000 times (true) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 1_000_100; i++) {
            Assertions.assertFalse(libraryMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue 100 times (false) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            Assertions.assertTrue(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue 10000 times (true) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 1_000_100; i++) {
            Assertions.assertFalse(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue 100 times (false) = " + runTime + "ms");

    }

    @Test
    void get() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get 0++> = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity - 1; i <= 0; i--) {
            Assertions.assertEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get -->0 = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 2_000_000; i++) {
            Assertions.assertNotEquals(i, libraryMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get (NotEquals) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get 0++> = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity - 1; i <= 0; i--) {
            Assertions.assertEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get -->0 = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i <= 2_000_000; i++) {
            Assertions.assertNotEquals(i, myMap.get(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get (NotEquals) = " + runTime + "ms");
    }

    @Test
    void put() {
        startTime = System.nanoTime();
        for (int i = capacity; i < 2_000_000; i++) {
            Assertions.assertNull(libraryMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put (newKey, newValue) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = capacity; i < 2_000_000; i++) {
            Assertions.assertNull(myMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put (newKey, newValue) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, libraryMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put (ExistKey, ExistValue) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < capacity; i++) {
            Assertions.assertEquals(i, myMap.put(i, i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put (ExistKey, ExistValue) = " + runTime + "ms");

    }

    @Test
    void remove() {
        startTime = System.nanoTime();
        for (int i = capacity; i <= 10_000_000; i++) {
            Assertions.assertNull(libraryMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.remove (nonexistent) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = capacity; i <= 10_000_000; i++) {
            Assertions.assertNull(myMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.remove (nonexistent) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            Assertions.assertEquals(i, libraryMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.remove (all) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            Assertions.assertEquals(i, myMap.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.remove (all) = " + runTime + "ms");

        Assertions.assertEquals(0, libraryMap.size());
        Assertions.assertEquals(0, myMap.size());
    }

    //    @Test
//    void putAll() {
//    }
//
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

//    @Test
//    void entrySet() {
//    }

}