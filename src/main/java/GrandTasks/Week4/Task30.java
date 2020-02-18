package GrandTasks.Week4;

// 4.106. Составить программу, которая в зависимости от порядкового номера дня месяца (1, 2, ..., 12)
// выводит на экран время года, к которому относится этот месяц
class Task30 {
    static String printSeason_v2(int dataMonth) {
        switch (dataMonth) {
            case 1:
            case 2:
            case 3:
                return Season.Winter.toString();
            case 4:
            case 5:
            case 6:
                return Season.Spring.toString();
            case 7:
            case 8:
            case 9:
                return Season.Summer.toString();
            case 10:
            case 11:
            case 12:
                return Season.Autumn.toString();
            default:
                throw new ExceptionInInitializerError("В году только 12 месяцев!");
        }
    }

    public static void main(String[] args) {
        System.out.println(printSeason_v2(1));
        System.out.println(printSeason_v2(3));
        System.out.println(printSeason_v2(4));
        System.out.println(printSeason_v2(7));
        System.out.println(printSeason_v2(12));
    }

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

    enum Season {
        Winter,
        Spring,
        Summer,
        Autumn
    }
}
