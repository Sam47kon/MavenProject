package GrandTasks.Week9_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static MyMethods.MyMethods.createRandomArrayWithSize;

class CustomHashSetTest {
    private HashSet<Integer> libHashSet = new HashSet<>();
    private CustomHashSet<Integer> myHashSet = new CustomHashSet<>();
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
            libHashSet.add(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.add = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            myHashSet.add(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.add = " + runTime + "ms");

        System.out.println("after:");
    }

    @Test
    void size() {
        Assertions.assertEquals(capacity, myHashSet.size());
        Assertions.assertEquals(capacity, libHashSet.size());
    }

    @Test
    void contains() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            myHashSet.contains(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.contains = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            libHashSet.contains(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.contains = " + runTime + "ms");
    }

    @Test
    void add() {
        System.out.println("test add:");
        System.out.println("add existing elements:");
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertFalse(myHashSet.add(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.add = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertFalse(libHashSet.add(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.add = " + runTime + "ms");


        System.out.println("add 1_000_000 new elements:");
        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertTrue(myHashSet.add(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.add = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertTrue(libHashSet.add(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.add = " + runTime + "ms");
    }

    @Test
    void remove() {
        System.out.println("test remove:");

        System.out.println("remove 1_000_000 times non-existing element:");
        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertFalse(myHashSet.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.remove = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = capacity; i < capacity * 2; i++) {
            Assertions.assertFalse(libHashSet.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.remove = " + runTime + "ms");


        System.out.println("remove all existing elements one by one:");
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertTrue(myHashSet.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.remove = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            Assertions.assertTrue(libHashSet.remove(i));
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.remove = " + runTime + "ms");

        Assertions.assertEquals(0, myHashSet.size());
        Assertions.assertEquals(0, libHashSet.size());
    }

    @Test
    void containsAll() {
        System.out.println("test containsAll");
        startTime = System.nanoTime();
        Assertions.assertTrue(myHashSet.containsAll(libHashSet));
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.containsAll(libHashSet) = " + runTime + "ms");

        startTime = System.nanoTime();
        Assertions.assertTrue(libHashSet.containsAll(myHashSet));
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.containsAll(myHashSet) = " + runTime + "ms");


        myHashSet.add(-1);
        Assertions.assertFalse(libHashSet.containsAll(myHashSet));
        Assertions.assertTrue(myHashSet.containsAll(libHashSet));

        libHashSet.add(-2);
        Assertions.assertFalse(myHashSet.containsAll(libHashSet));

        libHashSet.add(-1);
        Assertions.assertTrue(libHashSet.containsAll(myHashSet));
    }

    @Test
    void addAll() {
        System.out.println("test addAll");
        startTime = System.nanoTime();
        Assertions.assertFalse(myHashSet.addAll(libHashSet));
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.addAll(libHashSet) = " + runTime + "ms");

        startTime = System.nanoTime();
        Assertions.assertFalse(libHashSet.addAll(myHashSet));
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.addAll(myHashSet) = " + runTime + "ms");


        myHashSet.add(-1);
        Assertions.assertTrue(libHashSet.addAll(myHashSet));
        Assertions.assertFalse(myHashSet.addAll(libHashSet));

        libHashSet.add(-2);
        Assertions.assertTrue(myHashSet.addAll(libHashSet));

        libHashSet.add(-1);
        Assertions.assertFalse(libHashSet.addAll(myHashSet));
    }

    @Test
    void retainAll() {
        CustomHashSet<Integer> my = new CustomHashSet<>();
        HashSet<Integer> lib = new HashSet<>();

        my.add(1);
        my.add(2);
        my.add(3);

        lib.add(3);
        lib.add(4);
        lib.add(5);

        my.retainAll(lib);

        System.out.println(my.toString());

    }

    @Test
    void removeAll() {
    }
}