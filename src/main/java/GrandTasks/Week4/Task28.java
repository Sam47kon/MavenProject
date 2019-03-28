package GrandTasks.Week4;

// 4.36. Работа светофора для пешеходов запрограммирована следующим образом: в
//начале каждого часа в течение трех минут горит зеленый сигнал, затем в течение двух минут — красный,
// в течение трех минут — опять зеленый и т. д. Дано вещественное число t, означающее время в минутах,
// прошедшее с начала очередного часа. Определить, сигнал какого цвета горит для пешеходов в этот момент.
class Task28 {
    private final String GREEN = "Green";
    private final String RED = "Red";


    String whatColorGlows(int dataTime) {
        if (dataTime <= 3) {
            return GREEN;
        }
        if (dataTime <= 5) {
            return RED;
        }
        int time = dataTime % 5;
        if (time > 3 || time == 0) {
            return RED;
        } else return GREEN;
    }
}

