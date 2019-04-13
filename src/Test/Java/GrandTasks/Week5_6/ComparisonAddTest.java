package GrandTasks.Week5_6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ComparisonAddTest {
    private List arrList = new ArrayList();
    private List myList = new CustomArrayList();
    private List andreyArrayList = new AndreyArrayList();

    private double startTime;
    private double stopTime;

    @Test
    void testAdd() {
        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrList.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time arrList method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            myList.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time my method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            andreyArrayList.add(0, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time AndreyArrayList method add time= " + (stopTime - startTime) / 1000000 + " ms");
    }

    @Test
    void testAdd1() {
        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrList.add(arrList.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time arrList method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            myList.add(myList.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time my method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            andreyArrayList.add(andreyArrayList.size() / 2, i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time AndreyArrayList method add time= " + (stopTime - startTime) / 1000000 + " ms");
    }

    @Test
    void testAdd2() {
        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            arrList.add(arrList.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time arrList method add  time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            myList.add(myList.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time my method add time= " + (stopTime - startTime) / 1000000 + " ms");


        startTime = System.nanoTime();
        for (int i = 0; i < 100_000; i++) {
            andreyArrayList.add(andreyArrayList.size(), i);
        }
        stopTime = System.nanoTime();
        System.out.println("Time AndreyArrayList add  time= " + (stopTime - startTime) / 1000000 + " ms");
    }
}