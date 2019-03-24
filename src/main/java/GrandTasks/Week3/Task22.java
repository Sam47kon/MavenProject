package GrandTasks.Week3;

// 3.29 Записать условие, которое является истинным, когда:
//        а) каждое из чисел X и Y нечетное;
//        б) только одно из чисел X и Y меньше 20;
//        в) хотя бы одно из чисел X и Y равно нулю;
//        г) каждое из чисел X, Y, Z отрицательное;
//        д) только одно из чисел X, Y и Z кратно пяти;
//        е) хотя бы одно из чисел X, Y, Z больше 100.

class Task22 {

    boolean itIsEvenNumber(int x, int y) {  // а) четное
        return x % 2 == 0 && y % 2 == 0;
    }

    boolean itIsUnEvenNumber(int x, int y) {  // а) нечетное
        return x % 2 == 1 && y % 2 == 1;
    }

    boolean whichIsLessThanTheIndicator(int x, int y, int indicator) {  // б)
        //return (x < indicator && y >= indicator) || (y < indicator && x >= indicator);
        return x < indicator ^ y < indicator;  // вот тут я понял как работает исключающее или
    }

    boolean isZero(int x, int y) {  // в)
        return x == 0 || y == 0;
    }

    boolean areAllNumbersNegative(int x, int y, int z) {  // г)
        return x < 0 && y < 0 && z < 0;
    }

    boolean oneOfThNumbersIsAMultipleOfFive(int x, int y, int z) {  // д)
        return (x % 5 == 0 && y % 5 != 0 && z % 5 != 0) ||
                (x % 5 != 0 && y % 5 == 0 && z % 5 != 0) ||
                (x % 5 != 0 && y % 5 != 0 && z % 5 == 0);
    }

    boolean isOneOfTheNumbersIsOverAHundred(int x, int y, int z) {
        return x > 100 || y > 100 || z > 100;
    }
}
