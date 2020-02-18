package MyStaticMethods.Sortings;

import java.util.Arrays;

class BubbleSort_My {

    /**
     * Сортировка пузырьком, не меняет исходный массив
     *
     * @param dataArr - входящий массив, НЕ изменяется
     * @return отсортированный массив
     */
    Integer[] bubbleSort(Integer[] dataArr) {
        Integer[] result = Arrays.copyOf(dataArr, dataArr.length);

        for (int i = 0; i < dataArr.length; i++) {
            for (int j = i; j < result.length; j++) {
                if (result[i] > result[j]) {
                    int larger = result[i];
                    result[i] = result[j];
                    result[j] = larger;
                }
            }
        }
        return result;
    }
}
