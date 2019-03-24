package GolovachDecember2013.CoreProcedural1;

import static java.lang.Double.*;

public class Information {

    public static void main(String[] args) {
//        double d = 0 / 0;
//        System.out.println(d);   // Exception in thread "main" java.lang.ArithmeticException: / by zero
        System.out.println("0.0 / 0 = " + 0.0 / 0);   // NaN, не число (not a number)
        System.out.println("-1.0 / 0 = " + -1.0 / 0); // -Infinity (- бесконечность)
        System.out.println("+1.0 / 0 = " + -1.0 / 0); // +Infinity (+ бесконечность)


        String str = "NaN";
        double d = Double.valueOf(str);
        System.out.println("double d = Double.valueOf(\"Nan\") = " + d);    // NaN
        System.out.println("NaN + 999 = " + (NaN + 999));    // import static java.lang.Double.NaN; (NaN - несколько типов, в данном случае double)
        System.out.println("NaN - NaN = " + (NaN - NaN));
        System.out.println("NaN * NaN = " + (NaN * NaN));
        System.out.println("NaN / NaN = " + (NaN / NaN));
        System.out.println("NaN % NaN = " + (NaN % NaN));

        System.out.println(NaN > 0 || NaN < 0 || NaN == 0 ?
                "Это строка никогда не выведется" :
                "Любое сравнение NaN (даже NaN==NaN?) возвращает false");


        str = "Infinity";
        d = Double.valueOf(str);
        System.out.println("d = Double.valueOf(\"Infinity\") = " + d);
        System.out.println("-Infinity + -Infinity = " + (NEGATIVE_INFINITY + NEGATIVE_INFINITY));    // -Infinity import static java.lang.Double.NEGATIVE_INFINITY
        System.out.println("-Infinity * Infinity = " + (NEGATIVE_INFINITY * POSITIVE_INFINITY));    // -Infinity
        System.out.println("-Infinity + Infinity = " + (NEGATIVE_INFINITY + POSITIVE_INFINITY));    // NaN
        System.out.println("-Infinity / Infinity = " + (NEGATIVE_INFINITY / POSITIVE_INFINITY));    // NaN
        System.out.println("-Infinity % Infinity = " + (NEGATIVE_INFINITY % POSITIVE_INFINITY));    // NaN

        System.out.println(POSITIVE_INFINITY == 0 || NEGATIVE_INFINITY == 0 ?
                "эта строка никогда не выведеться" :
                "+Infinity и -Infinity не равны 0");
        System.out.println(POSITIVE_INFINITY < 0 || NEGATIVE_INFINITY > 0 ?
                "эта строка никогда не выведеться" :
                "+Infinity > 0 и -Infinity < 0");


//        Double.valueOf("qwerty12345");    // Exception in thread "main" java.lang.NumberFormatException: For input string: "qwerty12345"
//        Double.valueOf("null");           // Exception in thread "main" java.lang.NumberFormatException: For input string: "null"

    }
}
