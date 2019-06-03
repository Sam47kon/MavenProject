package StepikTasks.Stepik4;

public class Stepik4_1 {

    // Stepik 4_1_1
    private static double sqrt(double x) {
        if (x < 0) {
            throw new java.lang.IllegalArgumentException("Expected non-negative number, got " + x);
        }
        return Math.sqrt(x);
    }


    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }


    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements.length <= 3 ? null
                : stackTraceElements[3].getClassName() + "#" + stackTraceElements[3].getMethodName();
    }

}
