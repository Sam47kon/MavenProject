package GrandTasks.Week7_8;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomLinkedList implements List {

    /**
     * @param <E> тип
     */
    private static class MyNode<E> {
        private E element;
        private MyNode next;
        private MyNode prev;

        private MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

//        private MyNode genIter(E... values) {     // генерировать итеративно
//            MyNode head = null;
//            for (int i = values.length - 1; i >= 0; i--) {
//                head = new MyNode(head, values[i], head.prev);
//            }
//            return head;
//        }
    }


    /**
     * @param size      - размер списка
     * @param first     - ссылка на первый элемент
     * @param last      - ссылка на последний элемент
     */
    private Object[] dataElements = new Object[10]; // TODO удалить когда все переделаю

    private int size = 0;
    private MyNode first;
    private MyNode last;


    /**
     * Возвращает размер CustomLinkedList (далее этот список)
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
     *
     * @param soughtObject - искомый объект
     */
    @Override
    public boolean contains(Object soughtObject) {
        return indexOf(soughtObject) >= 0;
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
        Object[] result = new Object[size];
        int index = 0;
        for (MyNode toArr = first; toArr != null; toArr = toArr.next) {   // идем по всем ссылкам сначала до конца
            result[index++] = toArr.element;
        }
        return result;
    }


    /**
     * Добавляет указанный элемент в конец этого списка и возвращает true
     *
     * @param newElement - указанный элемент
     */
    @Override
    public boolean add(Object newElement) {
        if (newElement == null) {
            throw new NullPointerException("Исключение нулевого указателя");
        }
        MyNode lastLast = last;     // запоминаем старый последний узел
        last = new MyNode(last, newElement, null);
        if (lastLast == null) {
            first = last;
        } else {
            lastLast.next = last;
        }
        size++;
        return true;
    }


    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     *
     * @param index      - указанная позиция
     * @param newElement - указанный элемент
     */
    @Override
    public void add(int index, Object newElement) {
        // есди index послений, то не будем занимать много памяти и добавим в конец
        if (index == size) {
            add(newElement);
        } else {
            checkIndexExistence(index);
            MyNode tmp;
            if (index < (size << 1)) {  // index <= size/2
                tmp = first;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                insertElement(newElement, tmp);
            } else {
                tmp = last;
                for (int i = index - 1; i > 0; i--) {
                    tmp = tmp.prev;
                }
                insertElement(newElement, tmp);
            }
        }
    }

    public Object getFirstElement() {
        if (first == null) {
            throw new NoSuchElementException();
        }
        return first.element;
    }

    public Object getLastElement() {
        if (last == null) {
            throw new NoSuchElementException();
        }
        return last.element;
    }


    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     *
     * @param soughtObject - указанный объект (искомый)
     * @return true, если объект есть
     */
    @Override
    public boolean remove(Object soughtObject) {    // TODO остановился здесь
        decreaseDataElementsLength();
        int oldSize = size;
        for (int index = 0; index < oldSize; index++) {
            if (Objects.equals(soughtObject, dataElements[index])) {
                System.arraycopy(dataElements, index + 1, dataElements, index, oldSize - index);
                size--;
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
    public Object remove(int index) { // TODO переделать
        checkIndexExistence(index);
        Object oldElement = dataElements[index];
        decreaseDataElementsLength();
        for (int i = index; i < size; i++) {
            dataElements[i] = dataElements[i + 1];
        }
        size--;
        return oldElement;
    }


    /**
     * Добавляет все элементы в указанной коллекции в конец этого списка
     *
     * @param addedCollection - добавляемая коллекция
     * @return - true, если коллекция не пустая
     */
    @Override
    public boolean addAll(@NotNull Collection addedCollection) {  // TODO переделать
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        size = addedElements.length + size;
        dataElements = Arrays.copyOf(dataElements, size);
        System.arraycopy(addedElements, 0, dataElements, dataElements.length - addedElements.length, addedElements.length);
        return true;
    }

    /**
     * Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции. либо false если колекция пустая
     */
    @Override
    public boolean addAll(int index, @NotNull Collection addedCollection) {  // TODO переделать
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        int oldSize = size;
        size = addedElements.length + size;
        dataElements = Arrays.copyOf(dataElements, size);
        System.arraycopy(dataElements, index, dataElements, addedElements.length + index, oldSize - index);
        System.arraycopy(addedElements, 0, dataElements, index, addedElements.length);
        return true;
    }


    /**
     * Удаляет все элементы из этого списка.
     */
    @Override
    public void clear() {    // TODO переделать
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
    public Object get(int index) {      // TODO переделать
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
    public Object set(int index, Object newElement) {      // TODO переделать
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
    public int indexOf(Object soughtObject) {   // TODO переделать
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
    public int lastIndexOf(Object soughtObject) {     // TODO переделать
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
     *
     * @param inputCollection - указанная коллекция
     * @return false, если нечего удалять (пустая или ни однин объект не одинаковый)
     */
    @Override
    public boolean removeAll(@NotNull Collection inputCollection) {     // TODO переделать
        Object[] deletedElements = inputCollection.toArray();
        if (deletedElements.length == 0) {
            return false;
        }

        for (int index = 0; index < deletedElements.length; index++) {  // не уверен
            if (!contains(dataElements[index])) {
                return false;
            }
        }

        int oldSize = size;

        for (int iElement = 0; iElement < deletedElements.length; iElement++) {
            for (int index = 0; index < oldSize - 1; index++) {
                if (Objects.equals(deletedElements[iElement], deletedElements[index])) {
                    remove(deletedElements[iElement]);
                }
            }
        }
        return true;
    }


    /**
     * Возвращает, true если этот список содержит все элементы указанной коллекции.
     *
     * @param specifiedCollection - указанная коллекция
     * @return true, если этот список содержит все элементы указанной коллекции
     */
    @Override
    public boolean containsAll(@NotNull Collection specifiedCollection) {    // TODO переделать
        Object[] elementsOfTheCollection = specifiedCollection.toArray();
        if (elementsOfTheCollection.length == 0) {
            return false;
        }
        int amountOfElements = 0;
        for (int i = 0; i < size; i++) {
            for (Object element : elementsOfTheCollection) {
                if (Objects.equals(dataElements[i], element)) {
                    amountOfElements++;
                }
            }
        }
        return amountOfElements == elementsOfTheCollection.length;
    }


    /**
     * Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента);
     * тип времени выполнения возвращаемого массива является типом указанного массива.
     */
    @NotNull
    @Override
    public Object[] toArray(@NotNull Object[] arr) {   // TODO переделать
        if (arr.length < size) {
            return Arrays.copyOf(dataElements, size);
        }
        System.arraycopy(dataElements, 0, arr, 0, size);
        return dataElements;
    }


    @Override
    public String toString() {   // TODO переделать
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size < 1) {
            return sb.append("]").toString();
        }
        if (size < 2) {
            return sb.append(dataElements[0]).append("]").toString();
        }
        for (int i = 0; i < size - 1; i++) {
            sb.append(dataElements[i]).append(", ");
        }
        sb.append(dataElements[size - 1]).append("]");
        return sb.toString();
    }

    /**
     * Уменьшаем длину массива объектов в 1.5 раз
     */
    private void decreaseDataElementsLength() {  // TODO удалить когда все переделаю
        if (dataElements.length > size * 1.5) {
            dataElements = Arrays.copyOf(dataElements, (int) (dataElements.length / 1.5) + 1);
        }
    }


    // -------------------------------------------------
    // -------------------------------------------------

    private void addToFirstNewNode(Object object) {  // TODO удалить когда все переделаю, если не понадобится
        MyNode oldFirst = first;     // запоминаем старый первый узел
        first = new MyNode(null, object, first);
        if (oldFirst == null) {
            last = first;
        } else {
            oldFirst.prev = first;
        }
        size++;
    }

    private void insertElement(Object newElement, MyNode node) {
        MyNode oldNodePrev;
        oldNodePrev = node.prev;
        node.prev = new MyNode(node.prev, newElement, node);
        if (oldNodePrev == null) {
            first = node.prev;
        } else {
            oldNodePrev.next = node.prev;
        }
        size++;
    }


    /**
     * Проверяем существование поступающего индекса
     *
     * @param index - поступающий индекс
     */
    private void checkIndexExistence(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + " not contained in this List with Size: " + size);
        }
    }
}
