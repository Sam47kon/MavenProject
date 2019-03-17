package GrandTasks.Week2;

// Вводишь 10 чисел, программа возвращает их в отсортированном порядке
public class Task13extra {
    public static void main(String[] args) {
        double[] inputNumbers = new double[10];
        for (int i = 0; i < inputNumbers.length; ) {
            inputNumbers[i] = new Task5().getNumber("Введите " + ++i + " число");
        }
        // Arrays.sort(inputNumbers);  // 1 вариант сортировки

        selectionSort(inputNumbers);
        for (int i = 0; i < inputNumbers.length; ) {
            System.out.print(inputNumbers[i++] + "  ");
        }
    }

    public static void selectionSort(double[] arr) {
        // По очереди будем просматривать все подмножества элементов массива (0 - последний, 1-последний, 2-последний,...)
        for (int i = 0; i < arr.length; i++) {
            // Предполагаем, что первый элемент (в каждом подмножестве элементов) является минимальным
            double min = arr[i];
            int min_i = i;
            // В оставшейся части подмножества ищем элемент, который меньше предположенного минимума
            for (int j = i + 1; j < arr.length; j++) {
                // Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            // Если нашелся элемент, меньший, чем на текущей позиции, меняем их местами
            if (i != min_i) {
                double tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
}
