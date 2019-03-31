package GrandTasks.Week4;

// Работа светофора для пешеходов запрограммирована следующим образом: 1 минуту зеленый, 1 минуту желтый, 1 минуту красный
// Дано вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
// Определить, сигнал какого цвета горит для пешеходов в этот момент.
class Task28GYR {

    String whatColorGlows(int dataTime) {
        dataTime %= 3;
        if (dataTime == 1) {
            return "Green";
        }
        if (dataTime == 2) {
            return "Yellow";
        }
        return "Red";
    }
}
