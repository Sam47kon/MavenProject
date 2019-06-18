package StepikTasks.Stepik6.S6_4;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class S6_4_2 {

    public static <T> void findMinMax1(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        @SuppressWarnings("unchecked")
        T[] minMax = (T[]) new Object[]{null, null};
        stream.forEach(t -> {
            if (minMax[0] == null || order.compare(t, minMax[0]) < 0) {
                minMax[0] = t;
            } else if (minMax[1] == null || order.compare(t, minMax[1]) > 0) {
                minMax[1] = t;
            }
        });
        minMaxConsumer.accept(minMax[0], minMax[1]);
    }

    public static <T> void findMinMax2(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        @SuppressWarnings("unchecked")
        T[] array = (T[]) stream.sorted(order).toArray();
        if (array.length == 0) {
            minMaxConsumer.accept(null, null);
        } else minMaxConsumer.accept(array[0], array[array.length - 1]);

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        @SuppressWarnings("unchecked") final T[] minMax = (T[]) new Object[2];
        stream.sorted(order).forEach(x -> {
            if (minMax[0] == null) {
                minMax[0] = x;
            }
            minMax[1] = x;
        });
        minMaxConsumer.accept(minMax[0], minMax[1]);
    }

    public static <T> void findMinMax4(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {

        MinMaxFinder<T> minMaxFinder = new MinMaxFinder<>(order);
        stream.forEach(minMaxFinder);
        minMaxConsumer.accept(minMaxFinder.min, minMaxFinder.max);
    }

    private static class MinMaxFinder<T> implements Consumer<T> {

        private final Comparator<? super T> order;
        T min;
        T max;

        private MinMaxFinder(Comparator<? super T> order) {
            this.order = order;
        }

        @Override
        public void accept(T t) {
            if (min == null || order.compare(t, min) < 0) {
                min = t;
            }
            if (max == null || order.compare(max, t) < 0) {
                max = t;
            }
        }
    }
}
