package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class CopyArr {
    private static double startTime;
    private static double stopTime;

    public static void main(String[] args) {
        int[] arr = new int[1_000_000];
        testForByte(arr);
        testForInt(arr);
        testForLong(arr);
        testArrayCopyByte(arr);
        testArrayCopyInt(arr);
        testArrayCopyLong(arr);


        int[] array = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 0, 0, 0, 0};   // TODO вообще не понял зачем  и что должно делать
        System.out.println(Arrays.toString(array));
        int[] insert = {7, 9, 53, 156};
        int size = 10;
        for (int newElement : insert) {
            int newPos = Arrays.binarySearch(array, 0, size, newElement);
            if (newPos < 0) {
                newPos = -newPos - 1;
            }
            System.arraycopy(array, newPos, array, newPos + 1, 1);
            array[newPos] = newElement;
            System.out.println(Arrays.toString(array));
            size++;
        }
    }


    private static void testArrayCopyByte(int[] dataArr) {
        startTime = System.nanoTime();
        System.arraycopy(dataArr, 0, dataArr, 1, dataArr.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time testArrayCopyByte " + (stopTime - startTime) / 1000 + "ms");
    }

    private static void testArrayCopyInt(int[] dataArr) {
        startTime = System.nanoTime();
        System.arraycopy(dataArr, 0, dataArr, 1, dataArr.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time testArrayCopyInt " + (stopTime - startTime) / 1000 + "ms");
    }

    private static void testArrayCopyLong(int[] dataArr) {
        startTime = System.nanoTime();
        System.arraycopy(dataArr, 0, dataArr, 1, dataArr.length - 1);
        stopTime = System.nanoTime();
        System.out.println("Time testArrayCopyLong " + (stopTime - startTime) / 1000 + "ms");
    }


    private static void testForByte(int[] dataArr) {
        startTime = System.nanoTime();
        for (int i = 0; i < dataArr.length - 2; i++) {
            dataArr[i + 1] = dataArr[i];
        }
        stopTime = System.nanoTime();
        System.out.println("Time testForByte " + (stopTime - startTime) / 1000 + "ms");
    }

    private static void testForInt(int[] dataArr) {
        startTime = System.nanoTime();
        for (int i = 0; i < dataArr.length - 2; i++) {
            dataArr[i + 1] = dataArr[i];
        }
        stopTime = System.nanoTime();
        System.out.println("Time testForInt " + (stopTime - startTime) / 1000 + "ms");
    }

    private static void testForLong(int[] dataArr) {
        startTime = System.nanoTime();
        for (int i = 0; i < dataArr.length - 2; i++) {
            dataArr[i + 1] = dataArr[i];
        }
        stopTime = System.nanoTime();
        System.out.println("Time testForLong " + (stopTime - startTime) / 1000 + "ms");
    }
}
