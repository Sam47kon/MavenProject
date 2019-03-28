package GrandTasks.Week4;

//4.67. Дано целое число k (1 <= k <= 365). Определить, каким будет k-й день года:
// выходным (суббота и воскресенье) или рабочим, если 1 января — понедельник
class Task29 {

    String whyDay(int dataDay) {
        if (dataDay < 6) {
            return "Рабочий день";
        }
        int day = dataDay % 7;
        if (day == 0) {
            return "Воскресение";
        } else if (day > 5) {
            return "Суббота";
        }
        return "Рабочий день";
    }
}
