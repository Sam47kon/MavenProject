package GolovachDecember2013.CoreProcedural1;

import java.util.Arrays;

public class MethodsInvertArray {

    public static void main(String[] args) {
        System.out.println("Тест invertArray:");
        new MethodsInvertArray().printInvertArray(new int[]{});
        new MethodsInvertArray().printInvertArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println("Тест invertArrayRecurs:");
        new MethodsInvertArray().printInvertArrayRecurs(new int[]{});
        new MethodsInvertArray().printInvertArrayRecurs(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println("Тест invertArray2:");
        new MethodsInvertArray().printInvertArray2(new int[]{});
        new MethodsInvertArray().printInvertArray2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }


    int[] invertArray(int[] data) {    // нерекурсивный метод инвертирования значений массива (итеративный)
        for (int i = 0; i < data.length / 2; i++) {   // повторяем цикл до половины размера массива, среднее число останется на месте
            int tmp = data[i];  // берем первое значение из массива
            data[i] = data[data.length - 1 - i];    // приравниваем его к последнему-- значению массива
            data[data.length - 1 - i] = tmp;    // устанавливаем на последнее--  первое++ значение
        }
        return data;
    }

    private void printInvertArray(int[] arr) {    // распечатка массива и его инверт версии
        System.out.print(Arrays.toString(arr) + " -> ");
        invertArray(arr);
        System.out.println(Arrays.toString(arr));
    }


    int[] invertArrayRecurs(int[] data, int i) {    // рекурсивный метод инвертирования значений массива,  где i - с какого индекса стартуем (чтобы инвертировать весь - 0)
        if (i < data.length / 2) {
            int tmp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
            invertArrayRecurs(data, i + 1);    //  вызываю этот же метот только для следущего "индекса"
        }
        return data;
    }

    private void printInvertArrayRecurs(int[] arr) {    //
        System.out.print(Arrays.toString(arr) + " -> ");
        invertArrayRecurs(arr, 3);      // здесь указываем, с какого инекса начинаем инвертировать массив
        System.out.println(Arrays.toString(arr));
    }


    // TODO Гриша посмотри сюда
    int[] invertArray2(int[] data) {    // цикл будет идти не от 0 к середине, а от середины к 0 (лабораторная работа головача)
        for (int i = data.length / 2, j = 0; i > 0; i--, j++) {    // сравниваю с 0 мпетод работает быстрее
            int tmp = data[j];
            data[j] = data[data.length - 1 - j];
            data[data.length - 1 - j] = tmp;
        }
        return data;
    }

    private void printInvertArray2(int[] arr) {
        System.out.print(Arrays.toString(arr) + " -> ");
        invertArray2(arr);
        System.out.println(Arrays.toString(arr));
    }


    String invertText(String inputText) {    //
        char[] data = inputText.toCharArray();    // записываем строку в масив символов
        for (int i = 0; i < data.length / 2; i++) {
            char tmp = data[i];
            data[i] = data[data.length - 1 - i];
            data[data.length - 1 - i] = tmp;
        }
        return new String(data);
    }
}
