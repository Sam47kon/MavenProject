package GrandTasks;

//Программа принимает на вход уравнение (например 10x^2+6x-4=0) выводит его решения
public class Task12 {

    public static void main(String[] args) {
        System.out.println("Хотите решить квадратное уравнение типа: ax\u00B2+bx+c=0 ?");
        double x1, x2, D;
        System.out.print("а: ");

        double a = new Task5().getNumber();
        System.out.print("b: ");
        double b = new Task5().getNumber();
        System.out.print("c: ");
        double c = new Task5().getNumber();
        System.out.println("Ваше уравнение имеет вид: " + a + "*x\u00B2+" + b + "*x+" + c + "=0");

        //region //TODO как реализовать теорему Виетта?
        //        if (a == 1) {
//            x1 = (-1) * b / 2;
//            x2 = (-1) * b / 2;
//            if (x1 + x2 == (-1) * b && x1 * x2 == c) {
//
//            }
//        }
        //endregion

        D = new Task12().getDiscriminant(a, b, c);
        if (b != 0 && c != 0) {
            x1 = new Task12().getX1(a, b, c, D);
        } else {
            if (b != 0) {
                x1 = 0;
                System.out.println("x = " + (int) x1);
            } else {
                System.out.println("Решить уравнение вида: " + c + "=0, Серьезно?");
            }
        }
        if (a != 0 && b != 0 && c != 0 && D > 0) {
            x2 = new Task12().getX2(a, b, D);
        } else {
            if (b != 0 && D > 0) {
                System.out.println("Только 1 корень, так как уравнение не квадратное :)");
            }
        }
        //region решение
        //        if (D >= 0) {    // если дискриминант больше или равен 0
//            x1 = ((-1) * b + Math.sqrt(D)) / (2 * a);    // указываем точное значение x1
//            if (x1 != 1 && x1 < 2 || x1 / (int) x1 != 1) {    // Если 1-ый корень это нецелое число (достаточно в принципе только второй части)
//                System.out.println("Первый корень x1 = " + ((-1) * b + Math.sqrt(D)) + "/" + (2 * a) + " . Или x1= " + x1);     // выводим красиво первый корень уравнения
//            } else {
//                System.out.println("Первый корень x1 = " + (int) x1);
//            }
//
//            x2 = ((-1) * b - Math.sqrt(D)) / (2 * a);    // указываем точное значение x2
//            if (x2 / (int) x2 != 1) { // такого if достаточно
//                System.out.println("Второй корень x2 = " + (int) ((-1) * b - Math.sqrt(D)) + "/" + (int) (2 * a) + " . Или x2= " + x2);     // выводим красиво второй корень уравнения
//            } else {
//                System.out.println("Второй корень x2 = " + (int) x2);
//            }
//        } else if (D == 0) {
//            x1 = (-1) * b;
//            x2 = x1;
//            System.out.print("x1, x2 = " + x1);
//        } else {
//            System.out.print("Ошибка. D меньше нуля");
//        }
        //endregion
    }

    public double getDiscriminant(double a, double b, double c) {
        double D;
        D = Math.pow(b, 2) - (4 * a * c);
        return D;
    }

    public double getX1(double a, double b, double c, double D) {
        double x1 = 0;
        if (a > 0) {
            if (D >= 0) {
                x1 = ((-1) * b + Math.sqrt(D)) / (2 * a);
                if (x1 / (int) x1 != 1) {
                    if (Math.sqrt(D) / (int) Math.sqrt(D) != 1) {
                        System.out.println("Первый корень x1 = (" + ((-1) * b) + "+\u221A" + D + ")/" + (2 * a) + " . Или x1 = " + x1);
                    } else {
                        System.out.println("Первый корень x1 = " + ((-1) * b + Math.sqrt(D)) + "/" + (2 * a) + " . Или x1 = " + x1);     // выводим красиво первый корень уравнения
                    }
                } else {
                    System.out.println("Первый корень x1 = " + x1);
                }
            } else if (D == 0) {
                x1 = (-1) * b;
                System.out.println("x1, x2 = " + x1);
            } else {
                System.out.println("Нет корней. дискриминант меньше нуля");
            }
        } else {
            x1 = c / b;
            System.out.println("x1 = " + x1);
        }
        return x1;
    }

    public double getX2(double a, double b, double D) {
        double x2 = 0;
        if (D >= 0) {    // если дискриминант больше или равен 0
            x2 = ((-1) * b - Math.sqrt(D)) / (2 * a);    // указываем точное значение x2
            if (x2 / (int) x2 != 1) {    // Если 2-ой корень это нецелое число
                if (Math.sqrt(D) / (int) Math.sqrt(D) != 1) {    // если корень из дискриминанта не целое число, то выведем красиво
                    System.out.println("Второй корень x2 = (" + ((-1) * b) + "-\u221A" + D + ")/" + (2 * a) + " . Или x2 = " + x2);
                } else {    // выводим красиво второй корень уравнения
                    System.out.println("Второй корень x2 = " + ((-1) * b - Math.sqrt(D)) + "/" + (2 * a) + " . Или x2 = " + x2);
                }
            } else {    // если целое число, то просто выведем
                System.out.println("Второй корень x2 = " + x2);
            }
        } else if (D == 0) {
            x2 = (-1) * b;
            System.out.println("x1, x2 = " + x2);
        } else {
            System.out.println("Нет корней. дискриминант меньше нуля");
        }
        return x2;
    }
}
