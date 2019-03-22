package GrandTasks.Week3;

// 2.43. Даны два целых числа a и b. Если a делится на b или b делится на a, то вывести 1, иначе — любое другое число.
// Условные операторы и операторы цикла
//не использовать
class Task21 {


    int checkTheEqualityOfNumbers(int a, int b) {    // проверить равенство чисел
        int tmp1 = a - b;
        int tmp2 = b - a;
        return tmp1 * tmp2 + 1;
    }
}
