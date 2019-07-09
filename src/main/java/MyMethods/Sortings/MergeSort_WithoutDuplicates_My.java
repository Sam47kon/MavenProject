package MyMethods.Sortings;

import java.util.Arrays;

class MergeSort_WithoutDuplicates_My {

    /**
     * Сортировка слиянием
     *
     * @param dataArr - входящий массив, НЕ изменяется
     * @return отсортированный массив
     */
    Integer[] mergeSort(Integer[] dataArr) {
        if (dataArr == null) {
            return null;
        }
        if (dataArr.length < 2) {
            return dataArr;
        }

        int mid = dataArr.length / 2;   // находим середину

        Integer[] arr_left = new Integer[mid];
        System.arraycopy(dataArr, 0, arr_left, 0, mid);  // левая часть массива

        Integer[] arr_right = new Integer[dataArr.length - mid];
        System.arraycopy(dataArr, mid, arr_right, 0, dataArr.length - mid); // правая часть массива

        arr_left = mergeSort(arr_left);
        arr_right = mergeSort(arr_right);

        return mergeSortedWithoutDuplicates(arr_left, arr_right);
    }


    private Integer[] mergeSortedWithoutDuplicates(Integer[] a, Integer[] b) {
        Integer[] answer = new Integer[a.length + b.length];
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

    private Integer[] mergeWithoutDuplicates(Integer[] arr1, Integer[] arr2) {
        Integer[] result = new Integer[arr1.length + arr2.length];
        int indexArr1 = arr1.length - 1;
        int indexArr2 = arr2.length - 1;
        int indexResult = result.length;
        Integer tmp = 0;
        while (indexResult > 0) {
            tmp = (indexArr2 < 0 || (indexArr1 >= 0 && arr1[indexArr1] >= arr2[indexArr2])) ?
                    arr1[indexArr1--] :
                    arr2[indexArr2--];
            //TODO доделать без дубликатов
        }


        return Arrays.copyOf(result, result.length - indexResult);
    }
}