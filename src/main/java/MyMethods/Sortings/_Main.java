package MyMethods.Sortings;

import static MyMethods.MyMethods.getRuntime;

import MyMethods.MyMethods;
import java.util.Arrays;

public class _Main {

    private static final Integer[] dataArr = MyMethods.createRandomArrayWithSize(1_000_000);
    private static Integer[] dataArr_Sort = Arrays.copyOf(dataArr, dataArr.length);

    public static void main(String[] args) {

//        System.out.println(getRuntime(() -> new BubbleSort_My().bubbleSort(dataArr)) + "ms");
//        System.out.println(getRuntime(() -> Arrays.sort(dataArr_Sort)) + "ms");
//
//
        System.out.println(getRuntime(() -> new MergeSort_My().mergeSort(dataArr)) + "ms");
        System.out.println(getRuntime(() -> Arrays.sort(dataArr_Sort)) + "ms");


    }
}
