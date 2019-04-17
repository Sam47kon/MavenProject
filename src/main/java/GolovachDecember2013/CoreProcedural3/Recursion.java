package GolovachDecember2013.CoreProcedural3;

import java.util.Arrays;

public class Recursion {
    public static void main(String[] args) {
        recurs1(1); // 1 2 4 8
        System.out.println();
        recurs2(1); // 8 4 2 1
        System.out.println();
        recurs3(1); // 1 2 4 8 8 4 2 1
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        invertArr(arr);
        System.out.println(Arrays.toString(arr));

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        invertArrRecursive(arr2, 0);
        System.out.println(Arrays.toString(arr2));

        System.out.println(fib1(5)); //  5 3 1 2 0 1 4 2 0 1 3 1 2 0 1 и пятое число фибоначчи 8
        System.out.println(fib2(5)); //  1 0 1 2 3 0 1 2 1 0 1 2 3 4 5 и пятое число фибоначчи 8
        System.out.println(fib3(5)); // 3 2 5 2 4 3 2 и пятое число фибоначчи 8
    }

    private static void invertArr(int arr[]) {
        for (int i = 0; i < arr.length / 2; i++) {
            int tmp = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = arr[i];
            arr[i] = tmp;
        }
    }

    private static void invertArrRecursive(int arr[], int firstIndex) {
        if (firstIndex < arr.length / 2) {
            int tmp = arr[arr.length - firstIndex - 1];
            arr[arr.length - firstIndex - 1] = arr[firstIndex];
            arr[firstIndex] = tmp;
            invertArrRecursive(arr, firstIndex + 1);
        }
    }

    private static void recurs1(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            recurs1(2 * arg);
        }
    }

    private static void recurs2(int arg) {
        if (arg < 7) {
            recurs2(2 * arg);
        }
        System.out.print(" " + arg);
    }

    private static void recurs3(int arg) {
        System.out.print(" " + arg);
        if (arg < 7) {
            recurs3(2 * arg);
        }
        System.out.print(" " + arg);
    }


    private static int fib1(int arg) {
        System.out.print(" " + arg);
        return arg < 2 ? 1 : fib1(arg - 2) + fib1(arg - 1);
    }

    private static int fib2(int arg) {
        int result =
                arg < 2 ? 1 : fib2(arg - 2) + fib2(arg - 1);
        System.out.print(" " + arg);
        return result;
    }

    private static int fib3(int arg) {
        return arg < 2 ? 1 : fib3(arg - 2) + func(arg) + fib3(arg - 1);
    }

    private static int func(int arg) {
        System.out.print(" " + arg);
        return 0;
    }
}


