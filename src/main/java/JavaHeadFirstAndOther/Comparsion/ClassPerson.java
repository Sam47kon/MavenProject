package JavaHeadFirstAndOther.Comparsion;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Objects;

public class ClassPerson {

    public static void main(String[] args) {
        Person p1 = new Person("p", 18);
        Person p2 = new Person("p", 18);
        Person p3 = new Person("p3", 18);
        Person p4 = new Person("p", 81);

        System.out.println("p1:" + p1.hashCode());
        System.out.println(p1.equals(p1));  // +
        System.out.println(p1.equals(p2));  // +
        System.out.println(p1.equals(p3));  // -
        System.out.println(p1.equals(p4));  // -

        System.out.println("p2:" + p2.hashCode());
        System.out.println(p2.equals(p1));  // +
        System.out.println(p2.equals(p2));  // +
        System.out.println(p2.equals(p3));  // -
        System.out.println(p2.equals(p4));  // -

        System.out.println("p3: " + p3.hashCode());
        System.out.println(p3.equals(p1));  // -
        System.out.println(p3.equals(p2));  // -
        System.out.println(p3.equals(p3));  // +
        System.out.println(p3.equals(p4));  // -

        System.out.println("p4: " + p4.hashCode());
        System.out.println(p4.equals(p1));  // -
        System.out.println(p4.equals(p2));  // -
        System.out.println(p4.equals(p3));  // -
        System.out.println(p4.equals(p4));  // +

        System.out.println();
        String str1 = "Sout";
        String str2 = "Sout";
        System.out.println(str1 == "Sout");
        System.out.println(str1 == str2);

        System.out.println(str1 == str2.intern());
        System.out.println(str1.intern() == str2.intern());
    }

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
            int result = 37 * 17 + (name == null ? 0 : name.hashCode());
            result = 37 * result + age;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Person)) {
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
