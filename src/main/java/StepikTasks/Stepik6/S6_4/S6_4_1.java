package StepikTasks.Stepik6.S6_4;

import java.util.stream.IntStream;

public class S6_4_1 {

    public static void main(String[] args) {
//        IntStream stream = pseudoRandomStream(13);
//        stream.limit(10).forEach(System.out::print);

        System.out.println(getMid1(1));
        System.out.println(getMid1(12));
        System.out.println(getMid1(123));
        System.out.println(getMid1(1234));
        System.out.println(getMid1(12345));
        System.out.println(getMid1(123456));

        System.out.println(getMid2(1));
        System.out.println(getMid2(12));
        System.out.println(getMid2(123));
        System.out.println(getMid2(1234));
        System.out.println(getMid2(12345));
        System.out.println(getMid2(123456));

    }

    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> getMid1(n * n));
    }

    private static int getMid1(int seed) {
        return seed / 10000 > 0 ? getMid1(seed % 10000) : seed / 10;
    }

    private static int getMid2(int seed) {
        return seed / 10 % 1000;
    }

}
