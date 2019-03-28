package GrandTasks.Week4;

// Работа светофора для пешеходов запрограммирована следующим образом: 1 минуту зеленый, 2 минуты желтый, 3 минуты красный
// Дано вещественное число t, означающее время в минутах, прошедшее с начала очередного часа.
// Определить, сигнал какого цвета горит для пешеходов в этот момент.
class Task28GYRv2 {

    String whatColorGlows(int dataTime) {
        if (dataTime == 1) {
            return "GREEN";
        }
        if (dataTime <= 3) {
            return "YELLOW";
        }
        if (dataTime <= 6) {
            return "RED";
        }

        int time = dataTime % 6;
        if (time > 3 || time == 0) {
            return "RED";
        }
        if (time > 1) {
            return "YELLOW";
        } else return "GREEN";
    }
}
