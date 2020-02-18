package StepikTasks.Stepik6.S6_1;

import java.util.Objects;

public class Pair<T, E> {
    private T first;
    private E second;

    private Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public static <T, E> Pair<T, E> of(T first, E second) {
        return new Pair<>(first, second);
    }

    public static void main(String[] args) {
        Pair<Integer, String> pair1 = Pair.of(1, "Первый");
        Pair<Integer, String> pair2 = Pair.of(1, "Первый");
        System.out.println(pair1.equals(pair2));

        Pair pair3 = Pair.of(1, "Первый");
        Pair pair4 = Pair.of(1, "Первый");
        System.out.println(pair3.equals(pair4));

        System.out.println(pair1.equals(pair3));

        System.out.println(pair1.hashCode());
        System.out.println(pair2.hashCode());
        System.out.println(pair3.hashCode());
        System.out.println(pair4.hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 37 * hash + (first == null ? 0 : first.hashCode());
        hash = 37 * hash + (second == null ? 0 : second.hashCode());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair<?, ?> other = (Pair<?, ?>) obj;
        return (Objects.equals(other.first, this.first) && Objects.equals(other.second, this.second));
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }
}
