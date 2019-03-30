package GolovachDecember2013.CoreProcedural2;

import java.util.Arrays;

public class Sortings {    // сотрировки

    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5, 6, 3, 2, 6, -99, 234234, 342};
        System.out.println(Arrays.toString(sortBubble2(arr)));


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
            for (int index = barrier + 1; index < dataArr.length; index--) {
                if (dataArr[barrier] > dataArr[index]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[barrier];
                    dataArr[barrier] = tmp;
                }
            }
        }
        return dataArr;
    }
}