package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class Merger {    // метод слияния отсортированных массивов

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 5, 7, 9};
        double startTime;
        double stopTime;
        startTime = System.nanoTime();
        int[] ab = merge1(a, b);
        stopTime = System.nanoTime();
        System.out.println("Time merge1 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(ab));
    }


    private static int[] merge(int[] a, int[] b) {      // неправильный метод, индекс a или b в конце вылетит за пределы
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex + bIndex != result.length) {
            if (a[aIndex] < b[bIndex]) {
                result[aIndex + bIndex] = a[aIndex++];
            } else {
                result[aIndex + bIndex] = b[bIndex++];
            }
        }
        return result;
    }

    private static int[] merge1(int[] a, int[] b) {      // мой правильный метод
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;
        int index = 0;
        while (index < result.length) {
            result[index] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if (aIndex == a.length) {       // если индекс вылетел за пределы
                System.arraycopy(b, bIndex, result, ++index, b.length - bIndex);    // копирую оставшиеся элементы другого массива
                break;
            }
            if (bIndex == b.length) {
                System.arraycopy(a, aIndex, result, ++index, a.length - aIndex);
                break;
            }
            index++;
        }
        return result;
    }
}
