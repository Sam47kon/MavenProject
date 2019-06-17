package StepikTasks.Stepik6.S6_3;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class S6_3_1 {


    public static void main(String[] args) {
        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        Function<String, Integer> safeStringLength1 = ternaryOperator(Objects::isNull, obj -> null, CharSequence::length);

        System.out.println(safeStringLength.apply(null));
        System.out.println(safeStringLength.apply("1"));
        System.out.println(safeStringLength.apply("12"));
        System.out.println(safeStringLength.apply("123"));

        System.out.println(safeStringLength1.apply(null));
        System.out.println(safeStringLength1.apply("1"));
        System.out.println(safeStringLength1.apply("12"));
        System.out.println(safeStringLength1.apply("123"));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return (T x) -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x); // your implementation here
    }
}
