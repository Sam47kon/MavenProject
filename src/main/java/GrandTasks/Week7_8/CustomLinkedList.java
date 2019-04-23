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
     * @param head     - ссылка на первый элемент (голова)
     * @param tail      - ссылка на последний элемент (хвост)
     */
    private Object[] dataElements = new Object[10]; // TODO удалить когда все переделаю

    private int size = 0;
    private MyNode head;
    private MyNode tail;


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


    /**
     * Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
     */
    @NotNull
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (MyNode toArr = head; toArr != null; toArr = toArr.next) {   // идем по всем ссылкам сначала до конца
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
        MyNode oldTail = tail;     // запоминаем старый последний узел
        tail = new MyNode(tail, newElement, null);
        if (size == 0) {
            head = tail;
        } else {
            oldTail.next = tail;
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
            // чтобы не бежать по всем ссылкам, разделим на пополам
            if (index < (size << 1)) {  // index <= size/2
                tmp = head;
                for (int i = 0; i < index; i++) {
                    tmp = tmp.next;
                }
                insertElement(newElement, head);
            } else {
                tmp = tail;
                for (int i = index - 1; i > 0; i--) {
                    tmp = tmp.prev;
                }
                insertElement(newElement, tail);
            }
        }
    }

    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     *
     * @param removeElement - указанный объект (искомый)
     * @return true, если объект есть
     */
    @Override
    public boolean remove(Object removeElement) {
        MyNode prev = null; // предыдущий
        MyNode current = head;  // текущий, идем сначала списка

        while (current != null) {
            if (Objects.equals(current.element, removeElement)) {   // если нашли элемент
                if (prev != null) {    // если он не вначале
                    prev.next = current.next;   // перемещаемся
                    if (current.next == null) {  // если элемент в конце
                        tail = prev;
                    } else {
                        // удаляем средний узел
                        current.next.prev = prev;
                    }
                    size--;
                } else {
                    // а если в начале, удаляем первый элемент
                    removeFirst();
                }
                return true;
            }
            // смещаемся вперед
            prev = current;
            current = current.next;
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
        return deleteNode(getNode(index));
    }


    /**
     * Удаляет все элементы из этого списка.
     */
    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет все элементы в указанной коллекции в конец этого списка
     *
     * @param addedCollection - добавляемая коллекция
     * @return - true, если коллекция не пустая
     */
    @Override
    public boolean addAll(@NotNull Collection addedCollection) {  // TODO остановился здесь
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
     * Возвращает элемент в указанной позиции в этом списке
     *
     * @param index - указанная позиция
     * @return элемент
     */
    @Override
    public Object get(int index) {      // TODO переделать
        checkIndexExistence(index);
        MyNode tmp;

        if (index < (size << 1)) {  // index <= size/2
            tmp = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
        } else {
            tmp = tail;
            for (int i = index - 1; i > 0; i--) {
                tmp = tmp.prev;
            }
        }
        return tmp.element;
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
    public String toString() {   // готово
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (size < 1) {
            return sb.append("]").toString();
        }
        if (size < 2) {
            return sb.append(head.element).append("]").toString();
        }
        for (MyNode node = head; node != tail; node = node.next) {
            sb.append(node.element).append(", ");
        }
        sb.append(tail.element).append("]");
        return sb.toString();
    }


    // Возвращает итератор для элементов в этом списке в правильной последовательности.
    @NotNull
    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
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

    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------
    // -----------------------------------------------------------------------------------------------------------------


    public Object getFirstElement() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

    public Object getLastElement() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.element;
    }

    /**
     * Вставляет
     *
     * @param newElement - новый элемент
     * @param node       - в какой узел вставить
     */
    private void insertElement(Object newElement, MyNode node) {
        MyNode oldNodePrev = node.prev;
        node.prev = new MyNode(node.prev, newElement, node);
        if (oldNodePrev == null) {
            head = node.prev;
        } else {
            oldNodePrev.next = node.prev;
        }
        size++;
    }

    /**
     * удалить первый элемент списка
     */
    public void removeFirst() {
        if (size == 0) {    // если список пустой то удалять нечего
            return;
        }
        head = head.next;   // устанавливаем первую ссылку на следущую
        size--;
        if (size == 0) {    // если был один элемент, то хвоста больше нет
            tail = null;
        } else {        // иначе обнуляем предыдущую сыллку (уже новой головы)
            head.prev = null;
        }
    }

    public void removeLast() {
        if (size <= 1) {
            head = null;
            tail = null;
            size = 0;
        } else {
            tail.prev.next = null;
            tail = tail.prev;
            size--;
        }
    }

    /**
     * Возвращает узел по индексу
     *
     * @param index - индекс узла
     * @return - нужный узел
     */
    private MyNode getNode(int index) {
        checkIndexExistence(index);
        MyNode node;
        if (index < (size << 1)) {  // index <= size/2
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = index - 1; i > 0; i--) {
                node = node.prev;
            }
        }
        return node;
    }

    /**
     * Удалить узел  вернуть его объект
     *
     * @param node - узел, который нужно удалить
     * @return - element этого узла
     */
    private Object deleteNode(MyNode node) {
        final Object element = node.element;
        MyNode prev = node.prev;
        MyNode next = node.next;

        if (prev == null) {   //если prev ссылка  узла node указывает на null, то значит head
            head = next;
        } else {
            prev.next = next;   // указываем что prev узел ссылается минуя node на его следущий узел
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;  // указываем что next узел ссылается минуя node на его предыдущий узел
        }

        node.element = null;
        size--;
        return element;
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
