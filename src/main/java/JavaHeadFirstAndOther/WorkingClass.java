
package JavaHeadFirstAndOther;

/**
 * Программа для вывода
 *
 * @author Sam47kon
 * @version 1.0
 */
public class WorkingClass {
    /**
     * Программа для вывода
     *
     * @param args команды линейных аргументов
     */

    public static void main(String[] args) {
        int N = 77777777;
        long t;

        {
            StringBuffer sb = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }

        {
            StringBuilder sb = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0;) {
                sb.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }
    }


//    public static void main(String[] args) {
//        System.out.println("HalloWorld");
//        //System.exit(-1); // завершает программу
//    }
}
