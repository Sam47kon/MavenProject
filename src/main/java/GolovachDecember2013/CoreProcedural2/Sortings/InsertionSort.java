package GolovachDecember2013.CoreProcedural2.Sortings;

class InsertionSort {    // сотрировки вставками

    static int[] insertionSort(int[] dataArr) {
        for (int barrier = 0; barrier < dataArr.length; barrier++) {
            int newElement = dataArr[barrier];
            int location = barrier - 1;
            while (location >= 0 && dataArr[location] > newElement) {
                dataArr[location + 1] = dataArr[location];
                location--;
            }
            dataArr[location + 1] = newElement;
        }
        return dataArr;
    }
}
