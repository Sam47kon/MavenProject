package StepikTasks;
// Задача: Реализуйте метод, возвращающий true, если среди четырех его аргументов ровно два истинны (любые). Во всех остальных случаях метод должен возвращать false.
public class Stepik2_1 {
    public static void main(String[] args) throws Exception {
        System.out.println("ffff " + booleanExpression(false, false, false, false));
        System.out.println("ffft " + booleanExpression(false, false, false, true));
        System.out.println("fftf " + booleanExpression(false, false, true, false));
        System.out.println("fftt " + booleanExpression(false, false, true, true) + " <- ");

        System.out.println("ftff " + booleanExpression(false, true, false, false));
        System.out.println("ftft " + booleanExpression(false, true, false, true) + " <- ");
        System.out.println("fttf " + booleanExpression(false, true, true, false) + " <- ");
        System.out.println("fttt " + booleanExpression(false, true, true, true));

        System.out.println("tfff " + booleanExpression(true, false, false, false));
        System.out.println("tfft " + booleanExpression(true, false, false, true) + " <- ");
        System.out.println("tftf " + booleanExpression(true, false, true, false) + " <- ");
        System.out.println("tftt " + booleanExpression(true, false, true, true));

        System.out.println("ttff " + booleanExpression(true, true, false, false) + " <- ");
        System.out.println("ttft " + booleanExpression(true, true, false, true));
        System.out.println("tttf " + booleanExpression(true, true, true, false));
        System.out.println("tttt " + booleanExpression(true, true, true, true));
    }
        public static boolean booleanExpression ( boolean a, boolean b, boolean c, boolean d){
            return ((!b) & (!b) & c & d) | ((!a) & b & (!c) & d) | (a & (!b) & (!c) & d) | (a & b & (!c) & (!d)) | (a & (!b) & c & (!d)) | ((!a) & b & c & (!d)); // Моё правильное решение true только: 0011 0101 1001 1100 1010 0110 0110

            //return ((a ^ b) & (c ^ d)) | ((a ^ c) & (b ^ d)) | ((a ^ d) & (b ^ c));   //Правильное решение (разобрать)

            //return (a | b | c | d) && !(a & b & c & d) && !(a ^ b ^ c ^ d);   //Правильное решение, разобрал (a | b | c | d) исключаем вариант что все false, && !(a & b & c & d) исключаем вариант что все true, && !(a ^ b ^ c ^ d) проверяем что количество true чётное т.к. вариант 0 true и 4 true исключены в предыдущих проверках, то чётность означает 2 (цепочка операций ^ меняет результат выражения на противоположный при каждом встреченном true, таким образом если число true чётно в результате получится false который будет инвертирован в true при помощи ! и станет результатом всего расчёта).

            /*int counter = 0;
            if (a) counter++;
            if (b) counter++;
            if (c) counter++;
            if (d) counter++;
            return (counter == 2);*/ //Правильное решение самое простое
    }

    }
