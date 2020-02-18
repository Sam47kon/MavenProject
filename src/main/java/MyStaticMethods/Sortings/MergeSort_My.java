package MyStaticMethods.Sortings;

class MergeSort_My {

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

        return merge(arr_left, arr_right);
    }

    private Integer[] merge(Integer[] arr1, Integer[] arr2) {
        Integer[] result = new Integer[arr1.length + arr2.length];
        int indexArr1 = arr1.length - 1;
        int indexArr2 = arr2.length - 1;
        int indexResult = result.length;

        while (indexResult > 0) {
            result[--indexResult] =
                    (indexArr2 < 0 || (indexArr1 >= 0 && arr1[indexArr1] >= arr2[indexArr2])) ?
                            arr1[indexArr1--] :
                            arr2[indexArr2--];
        }
        return result;
    }
}