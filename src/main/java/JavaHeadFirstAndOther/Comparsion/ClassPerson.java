package JavaHeadFirstAndOther.Comparsion;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ClassPerson {

    public static class Person implements Comparable<Person> {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        String getName() {
            return name;
        }

        int getAge() {
            return age;
        }

        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null){
                return false;
            }
            Person person = (Person) obj;
            return this.getAge() == person.getAge() && Objects.equals(person.getName(), this.getName());
        }

        public String toString() {
            return name + ", " + age;
        }

        // реализация метода интерфейса Comparable, используем встроенный механизм compareTo (сравнить с) для String
        @Override
        public int compareTo(@NotNull ClassPerson.Person p) {
            return name.compareTo(p.getName());
        }
    }


    public static class PersonNameComparator implements Comparator<Person> {
        @Override
        public int compare(Person m1, Person m2) {
            return m1.getName().compareTo(m2.getName());
        }
    }

    public static class PersonAgeComparator implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
//            return p1.getAge() > p2.getAge() ? 1 : p1.getAge() == p2.getAge() ? 0 : -1;
//            или
            return Integer.compare(p1.getAge(), p2.getAge());
        }
    }
}
