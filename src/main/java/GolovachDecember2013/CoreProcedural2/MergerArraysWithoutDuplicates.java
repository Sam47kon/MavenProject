package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class MergerArraysWithoutDuplicates {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 5, 6, 7};
        double startTime;
        double stopTime;
        startTime = System.nanoTime();
        int[] ab = mergeSortedWithoutDuplicates(a, b);
        stopTime = System.nanoTime();
        System.out.println("Time merge1 = " + (stopTime - startTime) / 1000 + " ms");
        System.out.println(Arrays.toString(ab));
    }

    private static int[] mergeSortedWithoutDuplicates(int[] a, int[] b) {
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        int tmp;
        while (i < a.length && j < b.length) {
            tmp = a[i] < b[j] ? a[i++] : b[j++];
            for (; i < a.length && a[i] == tmp; i++) ;
            for (; j < b.length && b[j] == tmp; j++) ;
            answer[k++] = tmp;
        }
        while (i < a.length) {
            tmp = a[i++];
            for (; i < a.length && a[i] == tmp; i++) ;
            answer[k++] = tmp;
        }
        while (j < b.length) {
            tmp = b[j++];
            for (; j < b.length && b[j] == tmp; j++) ;
            answer[k++] = tmp;
        }
        return Arrays.copyOf(answer, k);
    }
}
