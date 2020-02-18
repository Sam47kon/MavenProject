package JavaHeadFirstAndOther.OOP;

public class ConstructorStatic {

    public static void main(String[] args) {
        Box box1 = new Box();
        System.out.println(box1.getVolume());

        Box box2Cube = new Box(3);
        System.out.println(box2Cube.getVolume());

        Box box3 = new Box(15, 41, 5);
        System.out.println(box3.getVolume());

        box1.setDim(2, 3, 4);
        System.out.println(box1.getVolume());

        Box box4 = new Box(box1);
        System.out.println(box4.getVolume());
        box4.setDim(3, 4, 5);
        System.out.println(box4.getVolume());

    }

    static class Box {
        int width; // ширина коробки
        int height; // высота коробки
        int depth; // глубина коробки

        // Конструктор
        Box() {
            width = 10;
            height = 10;
            depth = 10;
        }

        // Второй конструктор
        Box(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }

        // Третий конструктор для куба
        Box(int len) {
            width = height = depth = len;
        }

        // Используем объект типа Box
        Box(Box ob) {
            width = ob.width;
            height = ob.height;
            depth = ob.depth;
        }

        // вычисляем объём коробки
        int getVolume() {
            return width * height * depth;
        }

        // устанавливаем размеры коробки
        void setDim(int w, int h, int d) {
            width = w;
            height = h;
            depth = d;
        }
    }
}
