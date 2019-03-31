package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class Sortings {    // сотрировки
    private static final int[] ARR0 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] ARR1 = new int[20];
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
        sortBubble1(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortBubble1(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortExample(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time sortExample " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR0);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");
        // Test time arr1
        System.out.println(Arrays.toString(ARR1));

        startTime = System.nanoTime();
        sortBubble1(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortBubble2(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortExample(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time sortExample " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR1);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");

        // Test time arr2
        System.out.println(Arrays.toString(ARR2));

        startTime = System.nanoTime();
        sortBubble1(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortBubble2(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortExample(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time sortExample " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        selectionSortInt(ARR2);
        stopTime = System.nanoTime();
        System.out.println("Time selectionSortInt " + (stopTime - startTime) / 1000 + "ms");

        // Test time arr3
        System.out.println(Arrays.toString(ARR3));

        startTime = System.nanoTime();
        sortBubble1(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble1 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortBubble2(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time sortBubble2 " + (stopTime - startTime) / 1000 + "ms");

        startTime = System.nanoTime();
        sortExample(ARR3);
        stopTime = System.nanoTime();
        System.out.println("Time sortExample " + (stopTime - startTime) / 1000 + "ms");

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

    static int[] sortBubble1(int[] dataArr) {           // сортировка пузырьком  сравнивая по 2 элемента справа налево
        for (int barrier = dataArr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (dataArr[index] > dataArr[index + 1]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[index + 1];
                    dataArr[index + 1] = tmp;
                }
            }
        }
        return dataArr;
    }

    static int[] sortBubble2(int[] dataArr) {       // лабораторная, сортировка пузырьком сравнивая по 2 элемента слева направо
        for (int barrier = 0; barrier < dataArr.length - 1; barrier++) {
            for (int index = dataArr.length - 2; index >= barrier; index--) {
                if (dataArr[index] > dataArr[index + 1]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[index + 1];
                    dataArr[index + 1] = tmp;
                }
            }
        }
        return dataArr;
    }

    static int[] sortExample(int[] dataArr) {       // сортировка выборками
        for (int barrier = 0; barrier < dataArr.length - 1; barrier++) {
            for (int index = barrier + 1; index < dataArr.length; index++) {
                if (dataArr[barrier] > dataArr[index]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[barrier];
                    dataArr[barrier] = tmp;
                }
            }
        }
        return dataArr;
    }

    private static void selectionSortInt(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    private static void selectionSortDouble(double[] arr) {       // нашел в инете, разобрал, понял
        // По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...)
        for (int i = 0; i < arr.length; i++) {
            // Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
            double min = arr[i];
            int min_i = i;
            // В оставшейся части подмножества ищем элемент, который меньше предположенного минимума
            for (int j = i + 1; j < arr.length; j++) {
                // Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            // Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
}