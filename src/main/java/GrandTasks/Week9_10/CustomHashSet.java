package GrandTasks.Week9_10;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomHashSet<E> implements Set<E> {
    private CustomHashMap<E, Object> map;
    private static final Object obj = new Object();

//----------------------------------------------------------------------------------------------------------------------
// constructors

    CustomHashSet() {
        map = new CustomHashMap<>();
    }

    CustomHashSet(int capacity) {
        map = new CustomHashMap<>(capacity);
    }

    CustomHashSet(int capacity, double fillFactor) {
        map = new CustomHashMap<>(capacity, fillFactor);
    }

//----------------------------------------------------------------------------------------------------------------------
// override

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object obj) {
        return map.containsKey(obj);
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size()];
        Iterator<E> iterator = map.keySet().iterator();
        for (int i = 0; i < array.length; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] array) {  // хз
        int size = size();
        int index = 0;
        if (array.length < size) {
            array = (T[]) new Object[size];
        }
        if (array.length > size) {
            int interval = array.length - size;
            for (int i = array.length - 1; i >= interval; i--) {
                array[i] = null;
            }
        }
        for (E e : map.keySet()) {
            array[index++] = (T) e;
        }

        return array;
    }

    @Override
    public boolean add(E element) {
        return map.put(element, obj) == null;
    }

    @Override
    public boolean remove(Object element) {
        return map.remove(element) != null;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends E> collection) {
        boolean changed = false;
        for (E e : collection) {
            if (add(e)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override // не работает почему то
    public boolean retainAll(@NotNull Collection<?> collection) {
        boolean changed = false;
        Iterator<?> iterator = iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
                changed = true;
            }
        }
        return changed;
        // или просто так:
//        return removeIf(o -> !collection.contains(o));
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> collection) {
        boolean changed = false;
        for (Object obj : collection) {
            if (contains(obj)) {
                remove(obj);
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public void clear() {
        map.clear();
    }


    public String toString() {
        StringBuilder st = new StringBuilder();
        Iterator<E> iterator = map.keySet().iterator();
        st.append("{");
        for (int i = 0; i < size() - 1; i++) {
            st.append(iterator.next()).append(", ");
        }
        return st.append(iterator.next()).append("}").toString();
    }
}
