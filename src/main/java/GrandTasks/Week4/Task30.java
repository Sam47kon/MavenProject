package GrandTasks.Week4;

// 4.106. Составить программу, которая в зависимости от порядкового номера дня месяца (1, 2, ..., 12)
// выводит на экран время года, к которому относится этот месяц
class Task30 {
    String printSeason(int dataMonth) {
        String[] season = {"Winter", "Spring", "Summer", "Autumn"};
        switch (dataMonth) {
            case 1:
            case 2:
            case 3:
                return season[0];
            case 4:
            case 5:
            case 6:
                return season[1];
            case 7:
            case 8:
            case 9:
                return season[2];
            case 10:
            case 11:
            case 12:
                return season[3];
            default:
                throw new ExceptionInInitializerError("В году только 12 месяцев!");
        }
    }
}
