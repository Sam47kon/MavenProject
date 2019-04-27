package GrandTasks.Week7_8;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
class ComparisonAddTest {
    private List linkedList = new LinkedList();
    private List myListGeneric = new CustomLinkedListGeneric();
    private List myList = new CustomLinkedList();

    private double startTime;
    private double stopTime;

    @Test
    void testAdd() {
        System.out.println("Вставить вначало 1_000_0000 раз:");
        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            linkedList.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            myListGeneric.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            myList.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myList method add time= " + (stopTime - startTime) / 1000000 + " ms");
    }

    @Test
    void testAdd1() {
        System.out.println("Вставить всередину 10_000 раз:");
        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            linkedList.add(linkedList.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            myListGeneric.add(myListGeneric.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 10_000; i++) {
            myList.add(myList.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myList method add time= " + (stopTime - startTime) / 1000000 + " ms");
    }

    @Test
    void testAdd2() {
        System.out.println("Вставить вконец 1_000_0000 раз:");
        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            linkedList.add(linkedList.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time linkedList method add  time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            myListGeneric.add(myListGeneric.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myListGeneric method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 1_000_0000; i++) {
            myList.add(myList.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time myList method add time= " + (stopTime - startTime) / 1000000 + " ms");
    }
}