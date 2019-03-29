package GrandTasks.Week4;

import java.util.Scanner;

// 4.115.*В некоторых странах Дальнего Востока (Китае, Японии и др.) использовался (и неофициально используется в настоящее время)
// календарь, отличающийся от применяемого нами. Этот календарь представляет собой 60-летнюю циклическую систему.
// Каждый 60-летний цикл состоит из пяти 12-летних подциклов. В каждом подцикле года носят названия животных:
// Крыса, Корова, Тигр, Заяц, Дракон, Змея, Лошадь, Овца, Обезьяна, Петух, Собака и Свинья.
// Кроме того, в названии года фигурируют цвета животных, которые связаны с пятью элементами природы —
// Деревом (зеленый), Огнем (красный), Землей (желтый), Металлом (белый) и Водой (черный).
// В результате каждое животное (и его год) имеет символический цвет, причем цвет этот часто совершенно не совпадает с его "естественной" окраской —
// Тигр может быть черным, Свинья — красной, а Лошадь — зеленой. Например, 1984 год — год начала очередного цикла —
// назывался годом Зеленой Крысы. Каждый цвет в цикле (начиная с зеленого) "действует" два года, поэтому через каждые 60 лет имя года (животное и его цвет) повторяется.
// Составить программу, которая по заданному номеру года нашей эры n печатает его название по описанному календарю в виде: "Крыса, Зеленый". Рассмотреть два случая:
//а) значение n 1984;
//б) значение n может быть любым натуральным числом
class Task31ChineseCalendar {

//    enum AnimalsYear {
//        RAT,        // Крыса 1
//        COW,        // Корова 2
//        TIGER,      // Тигр 3
//        HARE,       // Заяц 4
//        DRAGON,     // Дракон 5
//        SNAKE,      // Змея 6
//        HORSE,     // Лошадь 7
//        SHEEP,      // Оцва 8
//        MONKEY,     // Обезьяна 9
//        ROOSTER,    // Петух 10
//        DOG,        // Собака 11
//        PIG         // Свинья 12
//    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите год:");
            int year = new Scanner(System.in).nextInt();
            System.out.println(new Task31ChineseCalendar().getNameOfTheYearInTheChineseCalendar(year));
        }
    }

    String getYearOfTheAnimal(int dataYear) {
        switch (dataYear) {
            case 1:
                return "Rat";
            case 2:
                return "Cow";
            case 3:
                return "Tiger";
            case 4:
                return "Hare";
            case 5:
                return "Dragon";
            case 6:
                return "Snake";
            case 7:
                return "Horse";
            case 8:
                return "Sheep";
            case 9:
                return "Monkey";
            case 10:
                return "Rooster";
            case 11:
                return "Dog";
            case 12:
                return "Pig";
        }
        int year = dataYear % 12;
        return getYearOfTheAnimal(year);
    }

    String getYearOfTheElementOfNature(int dataYear) {
        switch (dataYear) {
            case 1:
            case 2:
                return "Green";
            case 3:
            case 4:
                return "Red";
            case 5:
            case 6:
                return "Yellow";
            case 7:
            case 8:
                return "White";
            case 0:
            case 9:
            case 10:
                return "Black";
        }
        int year = dataYear % 10;
        return getYearOfTheElementOfNature(year);
    }

    String getNameOfTheYearInTheChineseCalendar(int dataYear) {
        return dataYear + " год - это год: " + getYearOfTheAnimal(dataYear) + ", " + getYearOfTheElementOfNature(dataYear) + " по китайскому календарю.";

    }
}
