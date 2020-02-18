package JavaHeadFirstAndOther.OOP;

interface AnimalsInterface {
    int legs = 4;

    int getLegs();

    int getWeight();

    void setWeight(int weight);

    String getName();

    void setName(String name);

    void playVoice();
}

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

abstract class Animals implements AnimalsInterface {
    static int countAnimals = 0;
    static int countPlaySongs = 0;

    private int weight;
    private String name;

    static void printCountAnimals() {
        System.out.println("Всего животных: " + countAnimals);
    }

    static void printCountPlaySongs() {
        System.out.println("Всего звуков: " + countPlaySongs);
    }

    static void eat(Animals animals) {       // полиморфизм
        animals.eat();
    }

    public int getLegs() {
        return legs;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int dataWeight) {
        this.weight = dataWeight;
    }

    public String getName() {
        return name;
    }

    public void setName(String dataName) {
        this.name = dataName;
    }

    void printInfo() {
        System.out.println("Это " + name + ". Вес: " + weight + ". Количество лап: " + legs);
    }

    void eat() {
        System.out.println("Животное ест...");
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