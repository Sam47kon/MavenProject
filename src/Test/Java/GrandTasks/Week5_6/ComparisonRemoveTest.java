package GrandTasks.Week5_6;

import java.util.ArrayList;
import java.util.List;

class ComparisonRemoveTest {
    private List arrList = new ArrayList();
    private List myList = new CustomArrayList();
    private List andreyArrayList = new AndreyArrayList();
    private double startTime;
    private double stopTime;

//
//    @BeforeEach
//    void beforeEach() {
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_001; i++) {
//            arrList.add(0, i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time arrList method add time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_001; i++) {
//            myList.add(0, i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time my method add time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_001; i++) {
//            andreyArrayList.add(0, i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time AndreyArrayList method add time= " + (stopTime - startTime) / 1000000 + " ms");
//
//    }
//
//    @Test
//    void testRemove() {
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_000; i++) {
//            arrList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time arrList method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_000; i++) {
//            myList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time my method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_000; i++) {
//            andreyArrayList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time AndreyArrayList method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//
//    }
//
//    @Test
//    void testRemove1() {
//        startTime = System.nanoTime();
//        for (int i = 100_000; i > 0; i--) {
//            arrList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time arrList method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_000; i++) {
//            myList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time my method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//
//
//        startTime = System.nanoTime();
//        for (int i = 0; i < 100_000; i++) {
//            andreyArrayList.remove(i);
//        }
//        stopTime = System.nanoTime();
//        System.out.println("Time AndreyArrayList method remove time= " + (stopTime - startTime) / 1000000 + " ms");
//    }
}