package JavaHeadFirstAndOther.OOP;

public class Abstract { // абстракция
    static abstract class Animals {
        int countPlaySongs = 0;

        final int legs = 4;

        abstract int getLegs();

        int weight;

        abstract void setWeight(int weight);

        abstract int getWeight();

        String name;

        abstract void setName(String name);

        abstract String getName();


        abstract void playVoice();
    }

    static class Cat extends Animals {

        int getCountPlaySongs() {
            return countPlaySongs;
        }

        int getLegs() {
            return legs;
        }


        void setWeight(int dataWeight) {
            this.weight = dataWeight;
        }

        int getWeight() {
            return weight;
        }


        void setName(String dataName) {
            this.name = dataName;
        }

        String getName() {
            return name;
        }


        void playVoice() {
            System.out.println("Meow");
            countPlaySongs++;
        }
    }


    public static void main(String[] args) {
        Animals cat1 = new Cat();
        cat1.setName("Vega");
        cat1.setWeight(5);

        Animals cat2 = new Cat();
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

        System.out.println(((Cat) cat1).getCountPlaySongs());
        System.out.println(((Cat) cat2).getCountPlaySongs());
    }
}
