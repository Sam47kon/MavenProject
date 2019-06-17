package StepikTasks.Stepik6.S6_4;

import java.math.BigInteger;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
//        int sum = IntStream.iterate(1, n -> n + 1).filter(n -> n % 5 == 0 && n % 2 != 0).map(n -> n * n).limit(10).sum();
//        System.out.println(sum);
//        System.out.println(IntStream.iterate(0, n -> n + 5).limit(3).sum());
        System.out.println(factorial(10));
        System.out.println(factorial(20));
    }

    private static BigInteger factorial(int n) {
        return IntStream.rangeClosed(1, n).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
