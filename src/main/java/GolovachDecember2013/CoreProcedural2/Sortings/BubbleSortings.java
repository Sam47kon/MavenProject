package GolovachDecember2013.CoreProcedural2.Sortings;

class BubbleSortings {    // сотрировки пузырьком

    static void bubbleSort1(int[] dataArr) {         // сортировка пузырьком  сравнивая по 2 элемента справа налево
        for (int barrier = dataArr.length - 1; barrier >= 0; barrier--) {
            for (int index = 0; index < barrier; index++) {
                if (dataArr[index] > dataArr[index + 1]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[index + 1];
                    dataArr[index + 1] = tmp;
                }
            }
        }
    }

    static void bubbleSort2(int[] dataArr) {       // лабораторная, сортировка пузырьком сравнивая по 2 элемента слева направо
        for (int barrier = 0; barrier < dataArr.length - 1; barrier++) {
            for (int index = dataArr.length - 2; index >= barrier; index--) {
                if (dataArr[index] > dataArr[index + 1]) {
                    int tmp = dataArr[index];
                    dataArr[index] = dataArr[index + 1];
                    dataArr[index + 1] = tmp;
                }
            }
        }
    }
}