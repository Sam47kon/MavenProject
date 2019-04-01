package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class Merger {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {3, 5, 7, 9};
        int[] ab = merge(a, b);
        System.out.println(Arrays.toString(ab));
    }


    public static int[] merge(int[] a, int[] b) {
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
}
