package JavaHeadFirstAndOther.OOP;

public class AbstractWithInterface { // абстракция+интерфейс

    public static void main(String[] args) {

        Animals cat1 = new Cat();
        cat1.setName("Vega");
        cat1.setWeight(5);

        Animals cat2 = new Cat();
        cat2.setName("Seva");
        cat2.setWeight(4);

        Animals dog1 = new Dog();
        dog1.setName("Bobik");
        dog1.setWeight(10);

        cat1.printInfo();
        Animals.eat(cat1);
        cat1.playVoice();

        cat2.printInfo();
        Animals.eat(cat2);
        cat2.playVoice();

        dog1.printInfo();
        Animals.eat(dog1);
        dog1.playVoice();
        dog1.playVoice();

        Animals.printCountAnimals();
        Animals.printCountPlaySongs();
    }
}

interface AnimalsInterface {
    int legs = 4;

    int getLegs();

    void setWeight(int weight);

    int getWeight();

    void setName(String name);

    String getName();

    void playVoice();
}


abstract class Animals implements AnimalsInterface {
    static int countAnimals = 0;
    static int countPlaySongs = 0;

    private int weight;
    private String name;

    public int getLegs() {
        return legs;
    }

    public void setWeight(int dataWeight) {
        this.weight = dataWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String dataName) {
        this.name = dataName;
    }

    public String getName() {
        return name;
    }

    void printInfo() {
        System.out.println("Это " + name + ". Вес: " + weight + ". Количество лап: " + legs);
    }

    static void printCountAnimals() {
        System.out.println("Всего животных: " + countAnimals);
    }

    static void printCountPlaySongs() {
        System.out.println("Всего звуков: " + countPlaySongs);
    }

    void eat() {
        System.out.println("Животное ест...");
    }

    static void eat(Animals animals) {       // полиморфизм
        animals.eat();
    }

}


class Cat extends Animals {
    Cat() {
        countAnimals++;
    }

    public void playVoice() {
        System.out.println("Meow");
        countPlaySongs++;
    }

    @Override
    void eat() {
        System.out.println("Кошка ест...");
    }
}

class Dog extends Animals {
    Dog() {
        countAnimals++;
    }

    public void playVoice() {
        System.out.println("Woof");
        countPlaySongs++;
    }
}