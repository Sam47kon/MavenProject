package GrandTasks.Week4;

import java.util.Scanner;

// 5.64. В области 12 районов. Известны количество жителей (в тысячах человек) и площадь (в км2) каждого района.
// Определить среднюю плотность населения по области в целом.
public class Task34v2 {
    private static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Сколько в вашей стране городов?");
        double[] areas = new double[reader.nextInt()];
        new Task34v2().enterArrayData(areas, "Какая площадь в каждом городе?",
                "Введите ", " площадь");

        double[] peopleInCities = new double[areas.length];
        new Task34v2().enterArrayData(peopleInCities,
                "Сколько (в тыс.) человек в каждом городе?", "В ", " городе:");

        double averageDensity = new Task34v2().getAverageDensity(peopleInCities, areas);
        if (averageDensity <= 1) {
            averageDensity *= 1000;
            System.out.printf("Плотность общего населения = %1$.2f человек в 1 км", averageDensity);
        } else {
            System.out.printf("Плотность общего населения = %1$.2f тыс. человек в 1 км", averageDensity);
        }
    }

    private static double getTotal(double[] areas) {
        double totalAreas = 0;
        for (double area : areas) {
            totalAreas += area;
        }
        return totalAreas;
    }

    private double getAverageDensity(double[] dataPeople, double[] dataArea) {
        return getTotal(dataPeople) / getTotal(dataArea);
    }

    private void enterArrayData(double[] dataArr, String whatValueByIndex, String nameType, String nameValue) {
        System.out.println(whatValueByIndex);
        for (int i = 0; i < dataArr.length; i++) {
            System.out.println(nameType + (i + 1) + nameValue);
            dataArr[i] = reader.nextDouble();
        }
    }
}
