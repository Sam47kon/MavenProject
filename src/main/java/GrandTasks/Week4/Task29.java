package GrandTasks.Week4;

import java.util.Scanner;


//4.67. Дано целое число k (1 <= k <= 365). Определить, каким будет k-й день года:
// выходным (суббота и воскресенье) или рабочим, если 1 января — понедельник
class Task29 {

    public enum Days {
        WORKING_DAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        int day = new Scanner(System.in).nextInt();
        Days toDay = new Task29().whyDay(day);
        System.out.println(toDay.toString());
    }

    Days whyDay(int dataDay) {
        if (dataDay < 6) {
            return Days.WORKING_DAY;
        }
        int day = dataDay % 7;
        if (day == 0) {
            return Days.SUNDAY;
        } else if (day > 5) {
            return Days.SATURDAY;
        }
        return Days.WORKING_DAY;
    }
}
