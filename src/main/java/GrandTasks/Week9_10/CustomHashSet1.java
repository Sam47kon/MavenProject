package GrandTasks.Week9_10;

import org.apache.commons.math3.exception.NullArgumentException;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomHashSet1<E> implements Set<E> {
    private static final Object obj = new Object();
    final private double fillFactor;
    private int size;
    private LinkedList<E>[] hashTable;
    private double threshold;   // порог размера
    private int itrPoint = 0;

//----------------------------------------------------------------------------------------------------------------------
// constructors

    CustomHashSet1() {
        hashTable = new LinkedList[16];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashSet1(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        hashTable = new LinkedList[size];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashSet1(int capacity, double fillFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        if (fillFactor <= 0 || fillFactor >= 1) {
            throw new IllegalArgumentException("Illegal fillFactor: " + fillFactor);
        }
        hashTable = new LinkedList[size];
        this.fillFactor = fillFactor;
        threshold = hashTable.length * fillFactor;
    }

    //----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
//    utilities
    private int getIndex(final int hash) {
        return (hashTable.length - 1) & hash;
    }

    private int hash(final E key) {
        int hash = key.hashCode();
        return hash ^ (hash >>> 16);
    }

    private void increaseTable() {
        LinkedList<E>[] oldTable = hashTable;
        hashTable = new LinkedList[oldTable.length * 2];
        size = 0;
        for (LinkedList<E> nodes : oldTable) {
            if (nodes != null) {
                for (E element : nodes) {
                    simpleAdd(element);
                }
            }
        }
    }

    private boolean simpleAdd(E newElement) {
        int index = getIndex(hash(newElement));

        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(newElement);
            size++;
            itrPoint++;
            return true;
        }
        LinkedList<E> elements = hashTable[index];
        for (E element : elements) {
            if (isCollision(element, newElement)) {
                collision(newElement, elements);
                return true;
            }
            if (Objects.equals(element, newElement)) {  // if element exist (Если данный element уже существует в HashSet возвращаем false)
                return false;
            }
        }
        collision(newElement, elements);
        return true;
    }

    private boolean isCollision(E element, E newElement) {
        return hash(element) == hash(newElement) &&
                !Objects.equals(element, newElement);
    }

    private void collision(E newElement, LinkedList<E> nodes) {
        nodes.add(newElement);
        size++;
        itrPoint++;
    }

    @Override
    public int size() {
        return size;
    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// override

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        E key = (E) obj;
        int index = getIndex(hash((key)));
        if (hashTable[index] != null) {
            for (E element : hashTable[index]) {
                if (Objects.equals(key, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    @NotNull
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Iterator<E> iterator = iterator();
        for (int i = 0; i < array.length; i++) {
            array[i] = iterator.next();
        }
        return array;
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] array) {  // хз
        if (size == 0) {
            throw new NullArgumentException();
        }
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
        for (LinkedList<E> nodes : hashTable) {
            if (nodes != null) {
                for (E element : nodes) {
                    array[index++] = (T) element;
                }
            }
        }
        return array;
    }

    @Override
    public boolean add(E newElement) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            increaseTable();
        }
        return simpleAdd(newElement);
    }

    @Override
    public boolean remove(Object element) {
        int index = getIndex(hash((E) element));
        if (hashTable[index] == null) {
            return false;
        }
        LinkedList<E> elements = hashTable[index];
        for (E el : elements) {
            if (element.equals(el)) {
                elements.remove(el);
                size--;
                itrPoint++;
                return true;
            }
        }
        return false;
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

    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
        boolean changed = false;
        Iterator<?> iterator = iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
                changed = true;
            }
        }
        if (changed) {
            itrPoint++;
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
        if (changed) {
            itrPoint++;
        }
        return changed;
    }

    @Override
    public void clear() {
        if (size != 0) {
            for (int i = 0; i < hashTable.length; i++) {
                hashTable[i] = null;
            }
            size = 0;
            itrPoint++;
        }
    }

    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("{");
        if (size == 0) {
            return st.append("}").toString();
        }

        for (LinkedList<E> elements : hashTable) {
            if (elements != null) {
                for (E couple : elements) {
                    st.append(couple.toString()).append(", ");
                }
            }
        }
        if (st.length() > 2) {
            st.delete(st.length() - 2, st.length());
        }
        return st.append("}").toString();
    }

    private class Itr implements Iterator<E> {
        int pos = 0;
        int lastPosLL = 0;
        int lastPosHT = 0;
        int nowIteratorPoint = itrPoint;
        E oldElement;

        @Override
        public boolean hasNext() {
            return pos != size;
        }

        @Override
        public E next() {
            checkImmutabilityOfList();
            if (pos >= size) {
                throw new NoSuchElementException();
            }

            while (lastPosHT < hashTable.length) {
                LinkedList<E> elements = hashTable[lastPosHT++];
                if (elements != null) {
                    if (elements.size() == 1) {
                        pos++;
                        lastPosLL = 0;
                        return oldElement = elements.getFirst();
                    } else {
                        if (lastPosLL < elements.size()) {
                            lastPosLL++;
                            pos++;
                            return oldElement = elements.get(lastPosLL);
                        } else {
                            lastPosLL = 0;
                            pos++;
                            return oldElement = elements.getLast();
                        }
                    }
                }
            }

            return null;
        }

        @Override
        public void remove() {
            checkImmutabilityOfList();
            if (oldElement == null) {
                throw new IllegalStateException();
            }
            if (CustomHashSet1.this.remove(oldElement)) {
                nowIteratorPoint++;
                pos--;
            } else throw new NullPointerException();
        }

        /**
         * Проверить неизменяемость листа во время работы итератора
         */
        final void checkImmutabilityOfList() {
            if (itrPoint != nowIteratorPoint)
                throw new ConcurrentModificationException();
        }
    }
}
