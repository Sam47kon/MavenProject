package GrandTasks.Week9_10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class CustomHashSetTest {
    private HashSet<Integer> libHashSet = new HashSet<>();
    private CustomHashSet<Integer> myHashSet = new CustomHashSet<>();
    private double startTime;
    private double stopTime;
    private double runTime;
    private static final Integer capacity = 1_000_000;

    @BeforeEach
    void before() {
        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            myHashSet.add(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myHashSet.add = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < capacity; i++) {
            libHashSet.add(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libHashSet.add = " + runTime + "ms");
    }

    @Test
    void size(){
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
    void iterator() {
    }

    @Test
    void toArray() {
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void containsAll() {
    }

    @Test
    void addAll() {
    }

    @Test
    void retainAll() {
    }

    @Test
    void removeAll() {
    }
}