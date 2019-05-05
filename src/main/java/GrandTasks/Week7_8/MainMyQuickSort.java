package GrandTasks.Week7_8;

import JavaHeadFirstAndOther.Comparsion.ClassPerson.*;

import java.util.Arrays;
import java.util.Comparator;

public class MainMyQuickSort {


    public static void main(String[] args) {
        Person[] people = new Person[16];
        people[0] = new Person("Tom", 88);
        people[1] = new Person("Tom", 1);
        people[2] = new Person("Tom", 45);
        people[3] = new Person("Andrey", 15);
        people[4] = new Person("Andrey", 5);
        people[5] = new Person("Alina", 88);
        people[6] = new Person("Andrey", 88);
        people[7] = new Person("Alina", 23);
        people[8] = new Person("Ilya", 23);
        people[9] = new Person("ilYA", 15);
        people[10] = new Person("ilYa", 15);
        people[11] = new Person("ilya", 15);
        people[12] = new Person("Ilya", 15);
        people[13] = new Person("ILya", 15);
        people[14] = new Person("ILYa", 15);
        people[15] = new Person("ILYA", 15);

        new MyQuickSort<Person>().QuickSortWithComparator(people, new PersonNameComparator().thenComparing(new PersonAgeComparator()));
        for (Person person : people) {
            System.out.println(person.toString());
        }
        System.out.println();


        Integer[] numbers = new Integer[]{9, 7, 6, 5, 4, 66, 345, -54};
        new MyQuickSort<Integer>().QuickSortDefault(numbers);
        System.out.println(Arrays.toString(numbers));

        String[] strings = new String[]{"b", "a", "h", "af", "fdg", "asd", "zz", "zzz", "5df", "1", "22", "uy3", "3uy", "aab", "aad", "aac"};
        new MyQuickSort<String>().QuickSortDefault(strings);
        System.out.println(Arrays.toString(strings));

        Character[] characters = new Character[]{1, 555, 0, 'd', 'y', 'n', '4', '1'};
        new MyQuickSort<Character>().QuickSortDefault(characters);
        System.out.println(Arrays.toString(characters));
        System.out.println();


        String[] strings1 = new String[]{"TO", "to", "To", "TOm", "toM", "Alina", "ALina", "alina", "ALINA", "To", "to"};
        new MyQuickSort<String>().QuickSortWithComparator(strings1, new Comparator<>() {
            /**
             * Сравнивает 2 строки по алфавиту
             *
             * @param o1 - первая строка
             * @param o2 - вторая строка
             * @return - 1 если 1>2, 0 если =, -1 если 2>1
             */
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(strings1));
    }
}
