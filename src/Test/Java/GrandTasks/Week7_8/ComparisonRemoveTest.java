package GrandTasks.Week7_8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class ComparisonRemoveTest {
    private List linkedList = new LinkedList();
    private List myListGeneric = new CustomLinkedListGeneric();
    private double startTime;
    private double stopTime;


    @BeforeEach
    void beforeEach() {
        startTime = System.nanoTime();
        for (double i = 0; i < 10_000; i++) {
            linkedList.add(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method add time= " + (stopTime - startTime) / 1000000 + " ms" + " size = " + linkedList.size());


        startTime = System.nanoTime();
        for (double i = 0; i < 10_000; i++) {
            myListGeneric.add(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method add time= " + (stopTime - startTime) / 1000000 + " ms" + " size = " + myListGeneric.size());
    }

    @Test
    void testRemove() {
        startTime = System.nanoTime();
        for (double i = 0; i < 10_000; i++) {
            linkedList.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method remove time= " + (stopTime - startTime) / 1000000 + " ms" + "size linkedList = " + linkedList.size());


        startTime = System.nanoTime();
        for (double i = 0; i < 10_000; i++) {
            myListGeneric.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method remove time= " + (stopTime - startTime) / 1000000 + " ms" + "size myListGeneric = " + myListGeneric.size());
    }

    @Test
    void testRemove1() {
        startTime = System.nanoTime();
        for (double i = 10_000; i >= 0; i--) {
            linkedList.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method remove time= " + (stopTime - startTime) / 1000000 + " ms" + "size linkedList = " + linkedList.size());


        startTime = System.nanoTime();
        for (double i = 10_000; i >= 0; i--) {
            myListGeneric.remove(i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method remove time= " + (stopTime - startTime) / 1000000 + " ms" + "size myListGeneric = " + myListGeneric.size());
    }
}