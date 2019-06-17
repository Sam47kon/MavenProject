package StepikTasks.Stepik6.S6_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class S6_2_2 {
    public static void main(String[] args) {
//        solution1();
        solution2();
    }

    private static void solution1() {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        byte i = 0;
        while (scanner.hasNext()) {
            int tmp = scanner.nextInt();
            if (i == 1) {
                arrayDeque.add(tmp);
                i = 0;
            } else i = 1;
        }
        for (Iterator<Integer> iterator = arrayDeque.descendingIterator(); iterator.hasNext(); ) {
            System.out.print(iterator.next() + " ");
        }
        arrayDeque.descendingIterator().forEachRemaining(value -> System.out.println(value + " "));
    }

    private static void solution2() {
        int[] autoInc = {0};
        Stream.of("")
                .flatMap(in -> new BufferedReader(new InputStreamReader(System.in)).lines().limit(1))
                .flatMap(str -> Stream.of(str.split(" ")))
                .filter(x -> autoInc[0]++ % 2 == 1)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(x -> System.out.print(x + " "));
    }
}
