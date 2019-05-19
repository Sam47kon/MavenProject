package GrandTasks.Week9_10;

import java.util.HashMap;

public class RuntimeComparisonHashMap {

    public static void main(String[] args) {
        HashMap<Integer, Integer> libraryMap = new HashMap<>();
        CustomHashMap<Integer, Integer> myMap = new CustomHashMap<>();
        double startTime;
        double stopTime;
        double runTime;

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// put

        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            libraryMap.put(i, i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.put = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            myMap.put(i, i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.put = " + runTime + "ms");

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// containsKey

        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            libraryMap.containsKey(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsKey = " + runTime + "ms");


        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            myMap.containsKey(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsKey = " + runTime + "ms");

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// containsValue

        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            libraryMap.containsValue(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.containsValue = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < 10_000; i++) {
            myMap.containsValue(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.containsValue = " + runTime + "ms");

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// get

        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            libraryMap.get(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime libraryMap.get = " + runTime + "ms");

        startTime = System.nanoTime();
        for (Integer i = 0; i < 1_000_000; i++) {
            myMap.get(i);
        }
        stopTime = System.nanoTime();
        runTime = (stopTime - startTime) / 1000000;
        System.out.println("runTime myMap.get = " + runTime + "ms");

    }
}
