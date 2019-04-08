package GrandTasks.Week5_6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Task40CustomArrayList<E> implements List {
    private int size;
    private Object[] elementData;

    // Возвращает размер CustomArrayList
    @Override
    public int size() {     // готово
        return this.size;
    }

    // Возвращает true, если CustomArrayList (далее этот список) пустой
    @Override       // готово
    public boolean isEmpty() {
        return size == 0;
    }

    // Возвращает, true если этот список содержит указанный элемент.
    @Override       // готово
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    // Возвращает итератор для элементов в этом списке в правильной последовательности.
    @NotNull
    @Override       // ??? TODO
    public Iterator iterator() {
        return null;
    }

    // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
    @NotNull
    @Override
    public Object[] toArray() {    // Готово
        return Arrays.copyOf(elementData, size);
    }

    // Добавляет указанный элемент в конец этого списка и возвращает true
    @Override
    public boolean add(Object e) {      // TODO хз правильно ли?
        elementData[size] = e;
        size++;
        return true;
    }

    // Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData.equals(o)) {
                elementData[i] = null;  //  TODO оставлять null или смещять весь список?
            }
        }
        return true;
    }

    @Override
    public boolean addAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    // Возвращает индекс последнего вхождения указанного элемента в этом списке или -1, если этот список не содержит элемент.
    @Override
    public int indexOf(Object o) {      // разобрать если не пойму, переделать как пойму
        return indexOfRange(o, 0, size);
    }

    private int indexOfRange(Object o, int start, int end) {    // разобрать если не пойму, переделать как пойму
        Object[] es = elementData;
        if (o == null) {
            for (int i = start; i < end; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < end; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection c) {
        return false;
    }

    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) {
        return new Object[0];
    }
}

