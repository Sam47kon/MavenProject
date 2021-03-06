package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class MergerArrays {    // метод слияния отсортированных массивов

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] b = {3, 5, 7, 9};
        double startTime;
        double stopTime;
        startTime = System.nanoTime();
        int[] ab = merge1(a, b);
        stopTime = System.nanoTime();
        System.out.println("Time merge1 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(ab));

        startTime = System.nanoTime();
        ab = merge2(a, b);
        stopTime = System.nanoTime();
        System.out.println("Time merge2 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(ab));

        startTime = System.nanoTime();
        ab = merge3(a, b);
        stopTime = System.nanoTime();
        System.out.println("Time merge3 = " + (stopTime - startTime) / 1000 + " ms");
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

    private static int[] merge1(int[] a, int[] b) {      // мой правильный метод, если один массив обработан, то копируем остаток второго массива в конец
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

    private static int[] merge2(int[] arr1, int[] arr2) {   //  слияние
        int[] result = new int[arr1.length + arr2.length];
        int indexArr1 = arr1.length - 1;
        int indexArr2 = arr2.length - 1;
        int indexResult = result.length;

        while (indexResult > 0)
            result[--indexResult] = (indexArr2 < 0 || (indexArr1 >= 0 && arr1[indexArr1] >= arr2[indexArr2])) ?
                    arr1[indexArr1--] :
                    arr2[indexArr2--];
        return result;
    }

    private static int[] merge3(int[] arr1, int[] arr2) {   //  слияние подробнее НЕВЕРНЫЙ
        int[] result = new int[arr1.length + arr2.length];
        int indexArr1 = 0;
        int indexArr2 = 0;

        for (int indexResult = 0; indexResult < result.length; indexResult++) {
            if (indexArr1 > arr1.length - 1) {     //  если индекс вылетел за пределы
                result[indexResult] = arr2[indexArr2++];   // записываю оставшиеся элементы другого массива
            } else if (indexArr2 > arr2.length - 1) {
                result[indexResult] = arr1[indexArr1++];
            } else if (arr1[indexArr1] > arr2[indexArr2]) {
                result[indexResult] = arr1[indexArr1++];
            } else {
                result[indexResult] = arr2[indexArr2++];
            }
        }
        return result;
    }
}
