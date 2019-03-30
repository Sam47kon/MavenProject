package GrandTasks.Week4;

import java.util.Scanner;

// 5.64. В области 12 районов. Известны количество жителей (в тысячах человек) и площадь (в км2) каждого района.
// Определить среднюю плотность населения по области в целом.
public class Task34v2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Сколько в вашей стране городов?");
        double[] areas = new double[reader.nextInt()];
        System.out.println("Какая площадь в каждом городе?");
        for (int i = 0; i < areas.length; i++) {
            System.out.println("Введите " + (i + 1) + " площадь:");
            areas[i] = reader.nextDouble();
        }

        double totalAreas = 0;
        for (double area : areas) {
            totalAreas += area;
        }

        double[] peopleInCities = new double[areas.length];
        System.out.println("Сколько (в тыс.) человек в каждом городе?");
        for (int i = 0; i < peopleInCities.length; i++) {
            System.out.println("В " + (i + 1) + " городе:");
            peopleInCities[i] = reader.nextDouble();
        }

        double totalPeople = 0;
        for (double people :
                peopleInCities) {
            totalPeople += people;
        }

        double averageDensity = new Task34v2().getAverageDensity(totalPeople, totalAreas);
        if (averageDensity <= 1) {
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
