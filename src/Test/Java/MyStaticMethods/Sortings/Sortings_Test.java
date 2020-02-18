package MyStaticMethods.Sortings;

import MyStaticMethods.MyMethods;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Sortings_Test {
    private static final Integer[] dataArr = MyMethods.createRandomArrayWithSize(1_000);
    private static Integer[] dataArr_Sort = Arrays.copyOf(dataArr, dataArr.length);

    @BeforeEach
    void before() {
        Arrays.sort(dataArr_Sort);
    }

    @Test
    void bubbleSort() {
        Assertions.assertArrayEquals(dataArr_Sort, new BubbleSort_My().bubbleSort(dataArr));
    }

    @Test
    void mergeSort(){
        Assertions.assertArrayEquals(dataArr_Sort, new MergeSort_My().mergeSort(dataArr));
    }
}