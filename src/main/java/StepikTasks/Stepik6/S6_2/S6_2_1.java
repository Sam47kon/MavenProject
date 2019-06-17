package StepikTasks.Stepik6.S6_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static MyMethods.MyMethods.*;

public class S6_2_1 {
    static Set<Integer> set1 = new LinkedHashSet<>(Arrays.asList(createRandomArrayWithSize(1_000_000)));
    static Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(createRandomArrayWithSize(1_000_000)));

    public static void main(String[] args) {

        System.out.println(getRuntime_N_times(3, S6_2_1::run1));
        System.out.println(getRuntime_N_times(3, S6_2_1::run2));
    }

    private static void run1() {
        Set<Integer> result1 = symmetricDifference1(set1, set2);
    }

    private static void run2() {
        Set<Integer> result2 = symmetricDifference2(set1, set2);
    }

    public static <T> Set<T> symmetricDifference1(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = new HashSet<>();
        for (T obj : set1) {
            if (!set2.contains(obj)) {
                result.add(obj);
            }
        }
        for (T obj : set2) {
            if (!set1.contains(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    public static <T> Set<T> symmetricDifference2(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> result = set1.stream().filter(obj -> !set2.contains(obj)).collect(Collectors.toSet());
        set2.stream().filter(obj -> !set1.contains(obj)).forEach(result::add);
        return result;
    }
}
