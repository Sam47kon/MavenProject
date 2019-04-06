package JavaHeadFirstAndOther.PracticeTraining;

public class StudyingExceptionHandlingMechanism {

}

//class MultiCatch {
//    static int c[] = {1};
//
//    public static void main(String args[]) {
//        try {
//            int a = args.length;
//            System.out.println("a = " + a);
//            int b = 23 / a;
//            c[4] = 33;
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException : " +
//                    e.getMessage());
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(
//                    "ArrayIndexOutOfBoundsException : "
//                            + e.getMessage());
//        }
//    }
//}
//
//class MultiNest {
//    static int c[] = {1};
//
//    static void checkArray() {
//        try {
//            c[4] = 33;
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println(
//            "ArrayIndexOutOfBoundsException : "
//                    + e.getMessage());
//        }
//    }
//
//    public static void main(String args[]) {
//        try {
//            int a = args.length();
//            System.out.println("a = " + a);
//            int b = 23 / a;
//            checkArray();
//        } catch (ArithmeticException e) {
//            System.out.println("ArithmeticException : " +
//                    e.getMessage());
//        }
//    }
//}