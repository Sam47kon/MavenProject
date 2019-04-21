package GolovachDecember2013.CoreProcedural2.Sortings;

public class QuickSorts {
    private static void quickSort1(int[] dataArr, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (dataArr[i] <= dataArr[cur])) {
                i++;
            }
            while (j > cur && (dataArr[cur] <= dataArr[j])) {
                j--;
            }
            if (i < j) {
                int temp = dataArr[i];
                dataArr[i] = dataArr[j];
                dataArr[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        quickSort1(dataArr, start, cur);
        quickSort1(dataArr, cur + 1, end);
    }


    private static void quickSort2(int[] array, int start, int end) {
        if (array.length == 0) {   //завершить выполнение если длина массива равна 0
            return;
        }
        if (start >= end) {    //завершить выполнение если уже нечего делить
            return;
        }
        // выбрать опорный элемент - середину
        int middle = start + (end - start) / 2;
        int prop = array[middle];    // опора

        // разделить на подмассивы, который больше и меньше опорного элемента
        int left = start;
        int right = end;
        while (left <= right) {
            while (array[left] < prop) {
                left++;
            }

            while (array[right] > prop) {
                right--;
            }

            if (left <= right) {     //меняем местами
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }
        }

        if (start < right) {     // рекурсия сортировки для левой части
            quickSort2(array, start, right);
        }
        if (end > left) {      // рекурсия сортировки для правой части
            quickSort2(array, left, end);
        }
    }
}
