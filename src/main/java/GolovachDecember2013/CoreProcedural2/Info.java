package GolovachDecember2013.CoreProcedural2;

public class Info {

    public static void main(String[] args) {
/*
        Примитивные Типы переменных всего 8
        boolean		логический тип true или false
        char		символьный тип (хранит 1 символ)
        byte, short, int, long целочисленные типы
        float, double	большие целочисленные типы
        int - 4 байта памяти

        Все остальные это ссылочные:
        String		ссылка на выделенную память "текст"

        Операторы сравнения всего 6 (бинарные)
	            <	меньше
                >	больше
                <=	меньше или равно
	            >=	больше или равно
                == проверка равенства
                != проверка неравенства

        Тернарный оператор всего 1:
                boolean ? arg1 : arg2

        Логические операции всего 4:
                 !		отрицание   (унарный
	            &&		и (коньюнкция)
                ||		или (дизъюнкция)
                ^		исключающее или (сложение по модуллю)
*/

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("(" + i + "," + j + ") ");
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(j + i > 3 ? "+" : "-");     // тернарный условный оператор
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(i > j ? "+" : "-");     // тернарный условный оператор
            }
            System.out.println();
        }
        System.out.println();

        int[] arr = {10, 20, 30, 40};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

        int low = 0;
        int high = 100;
        int mid1 = (low + high) / 2;
        int mid2 = (low + high) >>> 1;   // mid1==mid2
        int mid3 = low + (high - low) / 2;
        System.out.println("mid1=(low+high)/2= " + mid1 + " == " + mid2 + " = mid2=(low+high)>>>1" + " == " + mid3 + " =mid3=low+(high-low)/2)");
    }
}
