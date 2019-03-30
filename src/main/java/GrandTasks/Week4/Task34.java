package GrandTasks.Week4;

// 5.64. В области 12 районов. Известны количество жителей (в тысячах человек) и площадь (в км2) каждого района.
// Определить среднюю плотность населения по области в целом.
public class Task34 {

    public static void main(String[] args) {
        double[] areas = {50.6, 70.9, 80, 10, 15, 69, 115, 47, 12, 36, 2.8, 200};
        double totalAreas = 0;
        for (double area : areas) {
            totalAreas += area;
        }

        double[] peopleInCities = {5, 8.3, 12.4, 5, 12, 7, 90, 4.3, 3, 4.5, 1, 100};
        double totalPeople = 0;
        for (double people :
                peopleInCities) {
            totalPeople += people;
        }

        double averageDensity = new Task34().getAverageDensity(totalPeople, totalAreas);
        if (averageDensity < 1) {
            averageDensity *= 1000;
            System.out.printf("Плотность общего населения = %1$.2f человек в 1 км", averageDensity);
        } else {
            System.out.printf("Плотность общего населения = %1$.2f тыс. человек в 1 км", averageDensity);
        }
    }


    double getAverageDensity(double dataPeople, double dataArea) {
        return dataPeople / dataArea;
    }
}
