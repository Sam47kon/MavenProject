package GrandTasks.Week3;

// 2.39 Даны целые числа h, m, s (0 < h ≤ 23, 0 ≤ m ≤ 59, 0 ≤ s ≤ 59), указывающие
//момент времени: "h часов, m минут, s секунд". Определить угол (в градусах)
//между положением часовой стрелки в начале суток и в указанный момент
//времени
class Task20 {

    double getAngle(double hour, double minute, double second) {  // 1h = 360/12 degree
        if (hour >= 12) {
            hour -= 12;
        }
        //return hour * 360 / 12 + minute * 360 / 60 / 12 + second * 360 / 3600 / 12;    // or
        return 360 * (3600 * hour + 60 * minute + second) / (3600 * 12);
    }
}