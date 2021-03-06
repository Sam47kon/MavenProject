package GrandTasks.Week3;

// 2.39 Даны целые числа h, m, s (0 < h ≤ 23, 0 ≤ m ≤ 59, 0 ≤ s ≤ 59), указывающие момент времени: "h часов, m минут, s секунд".
// Определить угол (в градусах) между положением часовой стрелки в начале суток и в указанный момент времени
class Task20 {

    double getAngle(int hour, int minute, int second) {  // 1h = 360/12 degree
        while (hour < 0) {    // пока часы не встанут в нужный промежуток (шкала), если ввели отрицательный hour - будем считать что часы перевели назад
            hour += 12;    // то переделаем hour на нужный промежуток (от 0 до 12)
        }
        while (hour >= 12) {    // если ввели больше чем шкала часов (будем считать что прокрутили часовую стрелку много раз)
            hour -= 12;    // то переделаем hour на нужный промежуток (от 0 до 12)
        }
        while (minute < 0) {    // то же самое для minute (минутная стрелка)
            minute += 60;
        }
        while (minute >= 60) {
            minute -= 60;
        }
        while (second < 0) {    // то же самое для second (секундная стрелка)
            second += 60;
        }
        while (second >= 60) {
            second -= 60;
        }
        // изначальная формула: hour * 360 / 12 + minute * 360 / 60 / 12 + second * 360 / 3600 / 12;
        return 360 * (double) (3600 * hour + 60 * minute + second) / (3600 * 12);
    }
}