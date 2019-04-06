package JavaHeadFirstAndOther.OOP;

public class ConstructorThis {    // использования конструктора this медленее, но поможет исключить дублирование кода

    static class Cat {
        int age;
        int birthday;
        String name;

        Cat(String dataName, int dataAge, int dataBirthday) {
            age = dataAge;
            birthday = dataBirthday;
            name = dataName;
        }

        // Инициализируем переменные явно
        Cat(int dataAge, int dataBirthday) {
            age = dataAge;
            birthday = dataBirthday;
        }

        // Инициализируем переменные одним и тем значением
        Cat(int dataAge) {
            this(dataAge, dataAge);
        }

        // Присвоим значения по умолчанию 0
        Cat() {
            this(0, 0);
        }
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        cat1.name = "Barsik";
        System.out.println("Name = " + cat1.name + ", age = " + cat1.age + ", birthday = " + cat1.birthday);

        Cat cat2 = new Cat(5, 9);
        System.out.println("age = " + cat2.age + ", birthday = " + cat2.birthday);

        Cat cat3 = new Cat(5);
        System.out.println("age = " + cat3.age + ", birthday = " + cat3.birthday);

        Cat cat4 = new Cat("Murzik", 5, 4);
        System.out.println("Name = " + cat4.name + ", age = " + cat4.age + ", birthday = " + cat4.birthday);

    }
}
