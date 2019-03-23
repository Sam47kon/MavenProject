package GrandTasks.Week3;

// 3.29 Записать условие, которое является истинным, когда:
//        а) каждое из чисел X и Y нечетное;
//        б) только одно из чисел X и Y меньше 20;
//        в) хотя бы одно из чисел X и Y равно нулю;
//        г) каждое из чисел X, Y, Z отрицательное;
//        д) только одно из чисел X, Y и Z кратно пяти;
//        е) хотя бы одно из чисел X, Y, Z больше 100.

class Task22 {

    boolean itIsEvenNumber(int x, int y) {  // а)
        return x % 2 == 0 && y % 2 == 0;
    }

    int whichIsLess(int x, int y, int indicator) {
        return x < indicator ? x : y < indicator ? y : 0;
    }
}
