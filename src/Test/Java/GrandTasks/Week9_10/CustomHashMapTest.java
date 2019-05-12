package GrandTasks.Week9_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CustomHashMapTest {
    private HashMap<Integer, Integer> libraryMap = new HashMap<>();
    private CustomHashMap<Integer, Integer> myMap = new CustomHashMap<>();
    private double startTime;
    private double stopTime;
    private double runTime;
    private Integer capacity = 1_000_000;

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
        for (Integer i = capacity; i < 1_001_000; i++) {
            Assertions.assertFalse(libraryMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue 1000 times (false) = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            Assertions.assertTrue(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue 10000 times (true) = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < 1_001_000; i++) {
            Assertions.assertFalse(myMap.containsValue(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue 1000 times (false) = " + runTime + "ms");

    }

    @Test
    void get() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
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
        for (Integer i = 0; i < 1_000_000; i++) {
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
    }

    @Test
    void remove() {
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void keySet() {
    }

    @Test
    void values() {
    }

    @Test
    void entrySet() {
    }

    @Test
    void toString1() {
    }
}