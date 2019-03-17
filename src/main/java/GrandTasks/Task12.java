package GrandTasks;

import java.util.Objects;
import java.util.Scanner;

//Программа принимает на вход уравнение (например 10x^2+6x-4=0) выводит его решения
public class Task12 {

    public static void main(String[] args) {
        System.out.println("Хотите решить квадратное уравнение типа: ax\u00B2+bx+c=0 ?");
        String exit = "restart";
        while (Objects.equals(exit, "restart")) {
            double a = new Task5().getNumber("Введите а: ");
            double b = new Task5().getNumber("Введите b: ");
            double c = new Task5().getNumber("Введите c: ");
            System.out.println("Ваше уравнение имеет вид: " + a + " * x\u00B2 + " + b + " * x + " + c + " = 0");

            double discriminant;
            discriminant = Math.pow(b, 2) - (4 * a * c);

            double x1 = 13.5;
            double x2 = 13.6;

            if (a == 0 && b == 0) {
                if (c != 0) {    // 0x^2+0x+c=0 невозможно
                    System.out.println("Решить уравнение вида: " + c + "=0, Серьезно?");
                } else {
                    System.out.println("x может быть абсолютно любым числом!");    // 0x^2+0x+0=0 ...
                }
            } else if (a == 0) {    // 0x^2+bx+c=0 и решение
                x1 = -c / b;
                System.out.println("x = " + x1);
                System.out.println("Только 1 корень, так как уравнение не квадратное :)");
            } else {    // решение через дискриминант
                x1 = new Task12().deriveRootValue(a, b, c, true);
            }

            boolean isThereSecondRoot = a != 0 && c != 0 && discriminant > 0;   // есть ли второй корень?
            if (isThereSecondRoot) {
                x2 = new Task12().deriveRootValue(a, b, c, false);     // находим второй корень
            }
            System.out.println(x1 + "и" + x2);
            System.out.println("restart - чтобы повторить");
            exit = new Scanner(System.in).nextLine();
        }
    }


    public double deriveRootValue(double a, double b, double c, boolean isFirstRoot) {      //получить значение корня
        if (a == 0) {       // для теста
            return -c / b;
        }
        double discriminant = Math.pow(b, 2) - (4 * a * c);
        if (discriminant == 0) {
            if (b == 0) {
                System.out.println("x1 = x2 = " + -b / (2 * a));
                return -b / (2 * a);
            }
            System.out.println("x1, x2 = " + (-1) * b);
            return (-1) * b;
        }
        if (discriminant >= 0) {    // если дискриминант больше или равен 0
            double x = isFirstRoot
                    ? ((-1) * b + Math.sqrt(discriminant)) / (2 * a)     // нахождение x1
                    : ((-1) * b - Math.sqrt(discriminant)) / (2 * a);    // нахождение x2
            boolean isInteger = x / (int) x != 1;

            if (isInteger) {   // Если корень это нецелое число
                isInteger = Math.sqrt(discriminant) / (int) Math.sqrt(discriminant) != 1;    // если корень из дискриминанта не целое число, то выведем красиво
                if (isInteger) {
                    System.out.println(isFirstRoot
                            ? "Первый корень x1 = (" + ((-1) * b) + "+\u221A" + discriminant + ")/" + (2 * a) + " . Или x1 = " + x
                            : "Второй корень x2 = (" + ((-1) * b) + "+\u221A" + discriminant + ")/" + (2 * a) + " . Или x2 = " + x);
                    return x;
                }    // выводим красиво корень уравнения
                System.out.println(isFirstRoot
                        ? "Первый корень x1 = " + ((-1) * b + Math.sqrt(discriminant)) + "/" + (2 * a) + " . Или x1 = " + x
                        : "Второй корень x2 = " + ((-1) * b + Math.sqrt(discriminant)) + "/" + (2 * a) + " . Или x2 = " + x);     // выводим красиво первый корень уравнения
                return x;
            }
            System.out.println(isFirstRoot
                    ? "Первый корень x1 =  " + x
                    : "Второй корень x2 =  " + x);    // если целое число, то просто выведем
            return x;
        }
        if (discriminant < 0) {    // ессли дискр меньше нуля, то ничего не вернет и выведет текст
            System.out.println("Нет корней. дискриминант меньше нуля");
        }

        throw new IllegalArgumentException("Корней нет");   // TODO ?
    }
}
