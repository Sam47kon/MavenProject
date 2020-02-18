package GolovachDecember2013.CoreProcedural3;

import java.util.Arrays;

public class Permutation {
    public static void main(String[] args) {
        int[] myArray = {1, 2, 3};
        new Permutation().findAllCombinationsOfArrayPermutations1(myArray, myArray.length);
    }

    private void findAllCombinationsOfArrayPermutations(int[] dataArr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(dataArr));
        } else {
            for (int i = 0; i < size; i++) {
                swap(dataArr, i, size - 1);
                findAllCombinationsOfArrayPermutations(dataArr, size - 1);
            }
        }
    }

    private void findAllCombinationsOfArrayPermutations1(int[] dataArr, int size) {
        if (size < 2) {
            System.out.println(Arrays.toString(dataArr));
        } else {
            for (int i = 0; i < size; i++) {
                swap(dataArr, i, size - 1);
                findAllCombinationsOfArrayPermutations1(dataArr, size - 1);
            }
        }
    }

    private void swap(int[] dataArr, int firstIndex, int lastIndex) {
        int tmp = dataArr[firstIndex];
        dataArr[firstIndex] = dataArr[lastIndex];
        dataArr[lastIndex] = tmp;
    }
}
