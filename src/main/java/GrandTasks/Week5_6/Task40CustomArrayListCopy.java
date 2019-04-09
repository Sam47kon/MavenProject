package GrandTasks.Week5_6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Task40CustomArrayListCopy<E> implements List<E> {
    private int size;
    private Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    // unchecked - отключение предупреждений, связанных с непроверенными операциями
    @SuppressWarnings("unchecked")
    E elementData(int index) {    // приведение типов
        return (E) elementData[index];
    }

    @SuppressWarnings("unchecked")
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }


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
    public boolean add(E e) {      // TODO хз правильно ли?
        add(e, elementData, size);
        return true;
    }

    private void add(E e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow();
        elementData[s] = e;
        size = s + 1;
    }

    // Удаляет элемент в указанной позиции в этом списке
    @Override
    public E remove(int index) {    // Готово, но надо проверить на работоспособность обязательно
//        Objects.checkIndex(index, size);
        rangeCheckForAdd(index);
        E oldElement = elementData(index);
        fastRemove(elementData, index);
        return oldElement;
    }

    // Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
    @Override
    public boolean remove(Object o) {   // TODO не совсем понял что здесь делается, что за конструкци AnyName:{... break AnyName}
        final Object[] es = elementData;
        final int size = this.size;
        int i = 0;
        found:
        {
            if (o == null) {
                for (; i < size; i++)
                    if (es[i] == null)
                        break found;
            } else {
                for (; i < size; i++)
                    if (o.equals(es[i]))
                        break found;
            }
            return false;
        }
        fastRemove(es, i);
        return true;
    }

    private void fastRemove(Object[] es, int i) {
        final int newSize;
        if ((newSize = size - 1) > i)
            System.arraycopy(es, i + 1, es, i, newSize - i);
        es[size = newSize] = null;
    }

    // Добавляет все элементы в указанной коллекции в конец этого списка
    @Override
    public boolean addAll(@NotNull Collection c) {      // готово
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew); //
        System.arraycopy(a, 0, elementData, s, numNew);
        size = s + numNew;
        return true;
    }

    private Object[] grow(int minCapacity) {    // наращивает
        return elementData = Arrays.copyOf(elementData,
                newCapacity(minCapacity));
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    // При необходимости увеличивает емкость этого списка, чтобы гарантировать,
    // что он может содержать как минимум количество элементов, указанное в аргументе минимальной емкости.
    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0)
                throw new OutOfMemoryError();
            return minCapacity;
        }
        return (newCapacity - MAX_ARRAY_SIZE <= 0)
                ? newCapacity
                : hugeCapacity(minCapacity);
    }

    private static int hugeCapacity(int minCapacity) {  // слишком большая ёмкость
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE)
                ? Integer.MAX_VALUE
                : MAX_ARRAY_SIZE;
    }

    // Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции. либо false если колекция пустая
    @Override
    public boolean addAll(int index, @NotNull Collection c) {   // готово
        rangeCheckForAdd(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;
        Object[] elementData;
        final int s;
        if (numNew > (elementData = this.elementData).length - (s = size))
            elementData = grow(s + numNew);

        int numMoved = s - index;
        if (numMoved > 0)
            System.arraycopy(elementData, index,
                    elementData, index + numNew,
                    numMoved);
        System.arraycopy(a, 0, elementData, index, numNew);
        size = s + numNew;
        return true;
    }

    private void rangeCheckForAdd(int index) {      // проверяем индекс на существование в этом списке
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {  // выводим красивое сообщение, если индекс не существует
        return "Index: " + index + ", Size: " + size;
    }

    // Удаляет все элементы из этого списка.
    //    @Override
//    public void clear() {
//        final Object[] es = elementData;
//        for (int to = size, i = size = 0; i < to; i++)
//            es[i] = null;
//    }
    @Override
    public void clear() {   // Готово
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    // Возвращает элемент в указанной позиции в этом списке
    @Override
    public E get(int index) {  // Готово
        rangeCheckForAdd(index);
        return elementData(index);
    }

    // Заменяет элемент в указанной позиции в этом списке на указанный элемент, возвращает старый элемент
    @Override
    public E set(int index, E element) {  // Готово
        rangeCheckForAdd(index);
        E oldElement = elementData(index);
        elementData[index] = element;
        return oldElement;
    }

    // Вставляет указанный элемент в указанную позицию в этом списке.
    @Override
    public void add(int index, E element) {    // Готово
        rangeCheckForAdd(index);
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index, elementData, index + 1, s - index);
        elementData[index] = element;
        size = s + 1;
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
    public int lastIndexOf(Object o) {  // TODO остановился здесь
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

