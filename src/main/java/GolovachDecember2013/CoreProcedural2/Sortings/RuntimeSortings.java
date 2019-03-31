package GolovachDecember2013.CoreProcedural2.Sortings;

import java.util.Arrays;

import static GolovachDecember2013.CoreProcedural2.Sortings.BubbleSortings.*;
import static GolovachDecember2013.CoreProcedural2.Sortings.SelectionSortings.*;

public class RuntimeSortings {
    private static final int[] ARR0 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    static final int[] ARR1 = new int[20];
    private static final int[] ARR2 = new int[500];
    private static final int[] ARR3 = new int[5000];
    private static final double[] DOUBLE_ARR1 = new double[20];
    private static final double[] DOUBLE_ARR2 = new double[500];

    static {
        fillArray(ARR1);
        fillArray(ARR2);
        fillArray(ARR3);
        fillArray(DOUBLE_ARR1);
        fillArray(DOUBLE_ARR2);
    }

    private static void fillArray(int[] dataArr) {
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = ((int) (Math.random() * 10000) - 5000);
        }
    }

    private static void fillArray(double[] dataArr) {
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = (Math.random() * 10000) - 5000;
        }
    }


    public static void main(String[] args) {
        double startTime;
        double stopTime;

        // Test time arr0
        System.out.println(Arrays.toString(ARR0));

        startTime = System.nanoTime();
        bubbleSort1(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        bubbleSort2(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionsSort(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time selectionsSort " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");

        // Test time arr1
        System.out.println(Arrays.toString(ARR1));

        startTime = System.nanoTime();
        bubbleSort1(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        bubbleSort2(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionsSort(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time selectionsSort " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");

        // Test time arr2
        System.out.println(Arrays.toString(ARR2));

        startTime = System.nanoTime();
        bubbleSort1(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        bubbleSort2(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionsSort(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time selectionsSort " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");

        // Test time arr3
        System.out.println(Arrays.toString(ARR3));

        startTime = System.nanoTime();
        bubbleSort1(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        bubbleSort2(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time bubbleSort2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionsSort(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time selectionsSort " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");


        // Test time double_arr1
        System.out.println(Arrays.toString(DOUBLE_ARR1));
        startTime = System.nanoTime();
        selectionSortDouble(DOUBLE_ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortDouble " + (stopTime - startTime) / 1000 + "ms");

        // Test time double_arr2
        System.out.println(Arrays.toString(DOUBLE_ARR2));
        startTime = System.nanoTime();
        selectionSortDouble(DOUBLE_ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortDouble " + (stopTime - startTime) / 1000 + "ms");

    }
}
