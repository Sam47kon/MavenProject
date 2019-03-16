package GrandTasks;

//Программа принимает на вход уравнение (например 10x^2+6x-4=0) выводит его решения
public class Task12 {

    public static void main(String[] args) {
        System.out.println("Хотите решить квадратное уравнение? ax\u00B2+bx+c=0");
        double x1, x2, D;
        System.out.print("а: ");
        double a = new Task5().getNumber();
        System.out.print("b: ");
        double b = new Task5().getNumber();
        System.out.print("c: ");
        double c = new Task5().getNumber();
        D = Math.pow(b, 2) - (4 * a * c);
        if (D >= 0) {
            double tmp = ((-1) * b + Math.sqrt(D)) / (2 * a);
            if (tmp != 1 && tmp < 2 || tmp / (int) tmp != 1) {
                // TODO написать как расчитать x1
                x1 = tmp;
                System.out.println(tmp + "нецелое");
            }

            tmp = ((-1) * b - Math.sqrt(D)) / (2 * a);
            if (tmp != 1 && tmp < 2 || tmp / (int) tmp != 1) { // TODO прописать иф
                x2 = tmp;
                System.out.println("x2 нецелое число"); //TODO
            }

           // System.out.printf("Первый корень x1 = " + x1 + ", Второй корень x2 = " + x2);    // TODO
        } else if (D == 0) {
            x1 = (-1) * b;
            System.out.printf("x1, x2 = " + x1);
        } else
            System.out.print("Ошибка. D меньше нуля");
    }
}
