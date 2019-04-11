package GrandTasks.Week5_6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Task40CustomArrayListTrue implements List {

    private Object[] dataElements;
    private int size = 0;


    /**
     * Возвращает размер CustomArrayList (далее этот список)
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Возвращает true, если далее этот список пустой
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Возвращает, true если этот список содержит указанный элемент.
     */
    @Override
    public boolean contains(Object comparableObject) {
        if (comparableObject == null) {
            return false;
        }
        for (int index = 0; index < size; index++) {
            if (Objects.equals(comparableObject, dataElements[index])) {
                return true;
            }
        }
        return false;
    }


    // Возвращает итератор для элементов в этом списке в правильной последовательности.
    @NotNull
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }


    /**
     * Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
     */
    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(dataElements, size - 1);
    }


    /**
     * Добавляет указанный элемент в конец этого списка и возвращает true
     *
     * @param newDataElement - указанный элемент
     */
    @Override
    public boolean add(Object newDataElement) {//
        if (newDataElement == null) {
            throw new UnsupportedOperationException();
        }
        size++;
        dataElements[size - 1] = newDataElement;
        return true;
    }


    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     *
     * @param index          - указанная позиция
     * @param newDataElement - указанный элемент
     */
    @Override
    public void add(int index, Object newDataElement) {
        checkIndexExistence(index);
        size++;
        System.arraycopy(dataElements, index + 1, dataElements, index + 1, dataElements.length - index);
        dataElements[index] = newDataElement;
    }


    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     *
     * @param soughtObject - указанный объект (искомый)
     * @return true, если объект есть
     */
    @Override
    public boolean remove(Object soughtObject) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(soughtObject, dataElements[index])) {
                dataElements[index] = null;
                return true;
            }
        }
        return false;
    }


    /**
     * Удаляет элемент в указанной позиции в этом списке
     *
     * @param index - указанная позиция
     * @return - этот удаленный элемент
     */
    @Override
    public Object remove(int index) {
        checkIndexExistence(index);
        Object oldElement = dataElements[index];
        dataElements[index] = null;
        return oldElement;
    }


    /**
     * Добавляет все элементы в указанной коллекции в конец этого списка
     *
     * @param addedCollection - добавляемая коллекция
     * @return - true, если коллекция не пустая
     */
    @Override
    public boolean addAll(@NotNull Collection addedCollection) {
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        size = addedElements.length + size;
        System.arraycopy(dataElements, dataElements.length, addedElements, 0, addedElements.length + 1);
        return true;
    }

    //** Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции. либо false если колекция пустая*/
    @Override
    public boolean addAll(int index, @NotNull Collection c) {// опционально
        return false;
    }


    /**
     * Удаляет все элементы из этого списка.
     */
    @Override
    public void clear() {
        for (int index = size; index-- > 0; ) {    // сравнение с 0 быстрее, чем с числом :)
            dataElements[index] = null;
        }
        size = 0;
    }

    /**
     * Возвращает элемент в указанной позиции в этом списке
     *
     * @param index - указанная позиция
     * @return элемент
     */
    @Override
    public Object get(int index) {
        checkIndexExistence(index);
        return dataElements[index];
    }

    /**
     * Заменяет элемент в указанной позиции в этом списке на указанный элемент, возвращает старый элемент
     *
     * @param index      - указанная позиция
     * @param newElement - новый элемент
     * @return старый элемент в указанной позиции
     */
    @Override
    public Object set(int index, Object newElement) {
        checkIndexExistence(index);
        Object oldElement = dataElements[index];
        dataElements[index] = newElement;
        return oldElement;
    }


    /**
     * Возвращает индекс первого вхождения указанного элемента в этом списке или -1, если этот список не содержит элемент.
     *
     * @param soughtObject - искомый объект
     * @return -1, если список не содержит элемент
     */
    @Override
    public int indexOf(Object soughtObject) {
        for (int index = 0; index < size; index++) {
            if (Objects.equals(soughtObject, dataElements[index])) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Возвращает индекс последнего вхождения указанного элемента в этом списке или -1, если этот список не содержит элемент.
     *
     * @param soughtObject - сравнимый объект
     * @return -1, если список не содержит элемент
     */
    @Override
    public int lastIndexOf(Object soughtObject) {
        for (int index = size; index-- > 0; ) {
            if (Objects.equals(soughtObject, dataElements[index])) {
                return index;
            }
        }
        return -1;
    }

    @NotNull
    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();

    }

    @NotNull
    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        throw new UnsupportedOperationException();
    }


    /**
     * Удаляет из этого списка все его элементы, которые содержатся в указанной коллекции.
     */
    @Override
    public boolean removeAll(@NotNull Collection inputCollection) {
        Object[] addedElements = inputCollection.toArray();

        return false;
    }

    // Возвращает, true если этот список содержит все элементы указанной коллекции.
    @Override
    public boolean containsAll(@NotNull Collection c) { //
        return false;
    }

    // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента); тип времени выполнения возвращаемого массива является типом указанного массива.
    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] a) { //
        return new Object[0];
    }

    /**
     * Проверяем существование поступающего индекса
     *
     * @param index - поступающий индекс
     */
    private void checkIndexExistence(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " not contained in this List with Size: " + size);
        }
    }
}

// В аргументах arraycopy() передаётся 1 исходный массив,
// 2 начальная позиция копирования в исходном массиве,
// 3 приёмный массив,
// 4 начальная позиция копирования в приёмном массиве,
// 5 количество копируемых элементов.
// Любое нарушение границ массива приведёт к исключению.