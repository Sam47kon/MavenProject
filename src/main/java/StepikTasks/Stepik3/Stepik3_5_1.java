package StepikTasks.Stepik3;

import java.util.function.DoubleUnaryOperator;

public class Stepik3_5_1 {

    public static void main(String[] args) {
        double f = integrate(x -> 1, 0, 10);
        System.out.println(f);
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double integral = 0;
        double gridSpacing = 1E-7;
        while (a < b) {
            a += gridSpacing;
            integral += f.applyAsDouble(a) * gridSpacing;
        }
        return integral;
    }
}
