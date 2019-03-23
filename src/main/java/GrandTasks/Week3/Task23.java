package GrandTasks.Week3;

// 4.15 Известны год и номер месяца рождения человека, а также год и номер месяца сегодняшнего дня (январь — 1 и т. д.).
// Определить возраст человека (число полных лет). В случае совпадения указанных номеров месяцев считать, что прошел полный год
class Task23 {

    int getAge(int yearOfBirth, int monthOfBirth, int currentYear, int currentMonth) {
        int age = currentYear - yearOfBirth;
        if (currentMonth < monthOfBirth) {
            age--;
        }
        return age;
    }

    int getFullAge(int yearOfBirth, int monthOfBirth, int dayOfBirth, int currentYear, int currentMonth, int currentDay) {
        int fullAge = currentYear - yearOfBirth - 1;
        if (currentMonth >= monthOfBirth) {
            if (currentMonth > monthOfBirth) {
                fullAge++;
            } else {
                if (currentDay >= dayOfBirth) {
                    fullAge++;
                }
            }
        }
        return fullAge;
    }
}
