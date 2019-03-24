package GolovachDecember2013.CoreProcedural1;

import java.util.Arrays;

// Вложенные циклы
public class NestedLoops {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }

        int[] array = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};
        System.out.println("Был массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, i, i + 1);
        }
        System.out.println("Стал массив: " + Arrays.toString(array));


        int[] array1 = {5, 1, 3, 4, 0, 8, 9, 7, 6, 2};
        System.out.println("Был массив1: " + Arrays.toString(array1));
        for (int i = 0; i < array1.length - 1; i++) {
            conditionalSwap(array1, i, i + 1);
        }
        System.out.println("Стал массив1: " + Arrays.toString(array1));

    }


    private static void swap(int[] array, int fst, int snd) {       // смещение элементов массива, либо перестановка элементов fst и snd
        int tmp = array[fst];
        array[fst] = array[snd];
        array[snd] = tmp;
    }

    private static void conditionalSwap(int[] array, int fst, int snd) {    // условный обмен элементов
        if (array[fst] > array[snd]) {
            int tmp = array[fst];
            array[fst] = array[snd];
            array[snd] = tmp;
        }
    }
}
