package JavaHeadFirstAndOther.OOP;

public class AbstractWithInterface { // абстракция+интерфейс
    interface Animals1 {
        int legs = 4;

        int getLegs();

        void setWeight(int weight);

        int getWeight();

        void setName(String name);

        String getName();

        void playVoice();
    }

    private static int countAnimals = 0;
    private static int countPlaySongs = 0;

    static abstract class Animals2 implements Animals1 {
        int weight;
        String name;

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
    }


    static class Cat extends Animals2 {
        Cat() {
            countAnimals++;
        }

        public void playVoice() {
            System.out.println("Meow");
            countPlaySongs++;
        }
    }

    static class Dog extends Animals2 {
        Dog() {
            countAnimals++;
        }

        public void playVoice() {
            System.out.println("Woof");
            countPlaySongs++;
        }
    }


    public static void main(String[] args) {

        Animals2 cat1 = new Cat();
        cat1.setName("Vega");
        cat1.setWeight(5);

        Animals2 cat2 = new Cat();
        cat2.setName("Seva");
        cat2.setWeight(4);

        System.out.println("Имя первой кошки: " + cat1.getName());
        System.out.println("Вес первой кошки: " + cat1.getWeight());
        System.out.println("Ног у первой кошки: " + cat1.getLegs());
        cat1.playVoice();
        cat1.playVoice();
        cat1.playVoice();
        cat1.playVoice();

        System.out.println("Имя второй кошки: " + cat2.getName());
        System.out.println("Вес второй кошки: " + cat2.getWeight());
        System.out.println("Ног у первой кошки: " + cat2.getLegs());
        cat2.playVoice();
        cat2.playVoice();
        cat2.playVoice();

        System.out.println(countPlaySongs);
        System.out.println(countAnimals);

    }
}
