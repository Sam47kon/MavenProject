package JavaHeadFirstAndOther.OOP;

public class Interface { // интерфейс
    public static void main(String[] args) {
        Animals1 cat1 = new Cat1();
        cat1.setName("Vega");
        cat1.setWeight(5);

        Animals1 cat2 = new Cat1() {
            @Override
            public void playVoice() {
                System.out.println("MEEEEOOOOUUUU");
            }
        };
        cat2.setName("Seva");
        cat2.setWeight(4);


        System.out.println("Имя первой кошки: " + cat1.getName());
        System.out.println("Вес первой кошки: " + cat1.getWeight());
        System.out.println("Ног у первой кошки: " + cat1.getLegs());
        cat1.playVoice();

        System.out.println("Имя второй кошки: " + cat2.getName());
        System.out.println("Вес второй кошки: " + cat2.getWeight());
        System.out.println("Ног у первой кошки: " + cat2.getLegs());
        cat2.playVoice();   // outputs MEEEEOOOOUUUU

    }

    interface Animals1 {
        int legs = 4;

        int getLegs();

        int getWeight();

        void setWeight(int weight);

        String getName();

        void setName(String name);

        void playVoice();
    }

    static class Cat1 implements Animals1 {

        private int weight;
        private String name;

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

        public void playVoice() {
            System.out.println("Meow");
        }
    }
}
