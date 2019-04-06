package JavaHeadFirstAndOther.OOP;

public class Inheritance { // наследование
    class Box {
        int width;
        int height;
        int depth;

        Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }

        int getVolume() {
            return width * height * depth;
        }

        String getDescription() {
            return "Обычная коробка. ";
        }
    }

    class HeavyBox extends Box { // наследуемся от класса Box
        int weight;

        HeavyBox(int dataWidth, int dataHeight, int dataDepth, int dataWeight) {   // конструктор HeavyBox
            super(dataWidth, dataHeight, dataDepth);   // с помощью super вызваем конструктор Box
            this.weight = dataWeight;
        }

        @Override
        String getDescription() {
            //return super.getDescription();
            return "Коробка, имеющая вес. ";
        }
    }

    class MoneyBox extends HeavyBox {
        int cost;

        MoneyBox(int dataWidth, int dataHeight, int dataDepth, int dataWeight, int dataCost) {
            super(dataWidth, dataHeight, dataDepth, dataWeight);
            cost = dataCost;
        }

        @Override
        String getDescription() {
            //return super.getDescription();
            return "Коробка, имеющая вес и стоимость. ";
        }
    }

    public static void main(String[] args) {
        MoneyBox myBox = new Inheritance().new MoneyBox(1, 2, 3, 99, 544);
        int myBoxVol = myBox.getVolume();
        System.out.println(myBox.getDescription()
                + " Объем: " + myBoxVol + ", вес: " + myBox.weight + ", стоимость: " + myBox.cost);
    }
}
