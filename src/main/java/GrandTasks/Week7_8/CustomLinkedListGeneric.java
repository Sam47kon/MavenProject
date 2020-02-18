package GrandTasks.Week7_8;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomLinkedListGeneric<T> implements List<T> {

    /**
     * size      - размер списка
     * head      - ссылка на первый элемент (голова)
     * tail      - ссылка на последний элемент (хвост)
     */
    private int size = 0;
    private MyNode<T> head;
    private MyNode<T> tail;
    private int iteratorPoint = 0;

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
     * Возвращает новый массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
     */
    @NotNull
    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int index = 0;
        for (MyNode<T> node = head; node != null; node = node.next, index++) {   // идем по всем ссылкам сначала до конца
            result[index] = node.element;
        }
        return result;
    }

    /**
     * Добавляет указанный элемент в конец этого списка и возвращает true
     *
     * @param newElement - указанный элемент
     */
    @Override
    public boolean add(T newElement) {
        if (newElement == null) {
            throw new NullPointerException("Исключение нулевого указателя");
        }
        MyNode<T> oldTail = tail;     // запоминаем старый последний узел
        tail = new MyNode<>(tail, newElement, null);
        if (size == 0) {
            head = tail;
        } else {
            oldTail.next = tail;
        }
        size++;
        iteratorPoint++;
        return true;
    }

    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     *
     * @param index      - указанная позиция
     * @param newElement - указанный элемент
     */
    @Override
    public void add(int index, T newElement) {
        // есди index послений, то не будем занимать много памяти и добавим в конец
        if (index == size) {
            add(newElement);
        } else {
            MyNode<T> node = getNode(index);
            insertElement(newElement, node);
        }
    }

    /**
     * Добавляет все элементы в указанной коллекции в конец этого списка
     *
     * @param addedCollection - добавляемая коллекция
     * @return - true, если коллекция не пустая
     */
    @Override
    public boolean addAll(@NotNull Collection<? extends T> addedCollection) {  // готово
        addAll(size, addedCollection);
        return true;
    }

    /**
     * Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции. либо false если колекция пустая
     */
    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> addedCollection) {  // готово
        if (size != 0 && size != index) {
            checkIndexExistence(index);
        }
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        MyNode<T> prev;    // начнем записывать новые элементы с левой части списка
        MyNode<T> coupling;    // сцепка, сюда сохраним ссылку на правую часть списка
        if (size == index) {   // если добавляем в конец списка
            prev = tail;
            coupling = null;
        } else {    // если добавляем внутрь списка
            coupling = getNode(index);  // находим нужный узел (правую часть списка) и сохраняем его
            prev = coupling.prev;
        }
        size = addedElements.length + size;
        iteratorPoint++;

        for (Object addedElement : addedElements) {
            @SuppressWarnings("unchecked")
            MyNode<T> newNode = new MyNode<>(prev, (T) addedElement, null);
            if (prev == null) {
                head = newNode;
            } else {
                prev.next = newNode;
            }
            prev = newNode;
        }

        if (coupling == null) {
            tail = prev;
        } else {
            prev.next = coupling; // указываем nextNode ссылку последнего элемента на тот узел, что сохранили
            coupling.prev = prev;
        }
        return true;
    }

    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     *
     * @param removeElement - указанный объект (искомый)
     * @return true, если объект есть
     */
    @Override
    public boolean remove(Object removeElement) {
        MyNode<T> prev = null; // предыдущий
        MyNode<T> current = head;  // текущий, идем сначала списка

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
                iteratorPoint++;
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
    public T remove(int index) {
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
        iteratorPoint = 0;
    }

    /**
     * Возвращает элемент в указанной позиции в этом списке
     *
     * @param index - указанная позиция
     * @return элемент
     */
    @Override
    public T get(int index) {      // готово
        MyNode<T> node = getNode(index);
        return node.element;
    }

    /**
     * Заменяет элемент в указанной позиции в этом списке на указанный элемент, возвращает старый элемент
     *
     * @param index      - указанная позиция
     * @param newElement - новый элемент
     * @return старый элемент в указанной позиции
     */
    @Override
    public T set(int index, T newElement) { // готово
        checkIndexExistence(index);
        MyNode<T> tmp = getNode(index);
        T oldElement = tmp.element;
        tmp.element = newElement;
        return oldElement;
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента в этом списке или -1, если этот список не содержит элемент.
     *
     * @param soughtObject - искомый объект
     * @return -1, если список не содержит элемент
     */
    @Override
    public int indexOf(Object soughtObject) {   // готово
        int index = 0;
        for (MyNode<T> node = head; node != null; node = node.next, index++) {
            if (Objects.equals(soughtObject, node.element)) {
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
    public int lastIndexOf(Object soughtObject) {     // готово
        int index = size - 1;
        for (MyNode<T> node = tail; node != null; node = node.prev, index--) {
            if (Objects.equals(soughtObject, node.element)) {
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
    public boolean removeAll(@NotNull Collection<?> inputCollection) {     // Готово
        Object[] objectToDelete = inputCollection.toArray();
        if (ItContainsAtLeastOne(objectToDelete)) return false;

        for (MyNode<T> node = head; node != null; node = node.next) {
            for (int index = objectToDelete.length - 1; index >= 0; index--) {
                if (Objects.equals(node.element, objectToDelete[index])) {
                    remove(objectToDelete[index]);
                }
            }
        }
        return true;
    }

    /**
     * Удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции collection.
     *
     * @param collection - указанная коллекция
     * @return если текущая коллекция после удаления изменилась иначе false
     */
    @Override
    public boolean retainAll(@NotNull Collection<?> collection) {
        Object[] objects = collection.toArray();
        Boolean x = ItContainsAtLeastOne(objects);
        if (x != null) return x;

        for (MyNode<T> node = head; node != null; node = node.next) {
            for (int index = objects.length - 1; index >= 0; index--) {
                if (!Objects.equals(node.element, objects[index])) {
                    remove(objects[index]);
                }
            }
        }

        return true;
    }

    private Boolean ItContainsAtLeastOne(Object[] objects) {
        if (objects.length == 0) {
            return false;
        }

        for (int index = objects.length - 1; index >= 0; index--) {  // проверяем на содержание хотя бы 1 объекта
            if (contains(objects[index])) {  // выходим если нашли
                break;
            } else if (index == 0) {    // если дошли до конца и не нашли, возвращаем false
                return false;
            }
        }
        return null;
    }

    /**
     * Возвращает, true если этот список содержит все элементы указанной коллекции.
     *
     * @param specifiedCollection - указанная коллекция
     * @return true, если этот список содержит все элементы указанной коллекции
     */
    @Override
    public boolean containsAll(@NotNull Collection<?> specifiedCollection) {
        Object[] elementsOfTheCollection = specifiedCollection.toArray();
        if (elementsOfTheCollection.length == 0) {
            return false;
        }
        int amountOfElements = 0;
        for (int index = elementsOfTheCollection.length - 1; index >= 0; index--) {
            if (contains(elementsOfTheCollection[index])) {
                amountOfElements++;
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
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(@NotNull E[] arr) {  // TODO ???

        if (arr.length < size) {
            arr = (E[]) new Object[size];
        }

        if (arr.length > size) {
            int interval = arr.length - size;
            for (int i = arr.length - 1; i >= interval; i--) {
                arr[i] = null;
            }
        }

        int index = 0;
        for (MyNode<T> node = head; node != null; node = node.next, index++) {
            arr[index] = (E) node.element;
        }
        return arr;
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
        for (MyNode<T> node = head; node != tail; node = node.next) {
            sb.append(node.element).append(" <-> ");
        }
        sb.append(tail.element).append("]");
        return sb.toString();
    }

    /**
     * Возвращает итератор для элементов в этом списке в правильной последовательности.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();

    }
// -----------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

    @NotNull
    @Override
    public ListIterator<T> listIterator() {
        return new CustomListIterator(0);
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        return new CustomListIterator(index);
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    public Object getFirstElement() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.element;
    }

// ---------------------------------------------------------------------------------------------------------------------
// ---------------------------------------------------------------------------------------------------------------------

    public Object getLastElement() {
        if (tail == null) {
            throw new NoSuchElementException();
        }
        return tail.element;
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
     * Вставляет
     *
     * @param newElement - новый элемент
     * @param node       - в какой узел вставить
     */
    private void insertElement(T newElement, MyNode<T> node) {
        if (node == null) {
            node = new MyNode<>(null, newElement, null);
        }
        MyNode<T> newNode = new MyNode<>(node.prev, newElement, node);
        if (node.prev == null) {
            head = newNode;
            newNode.next.prev = newNode;
        } else {
            newNode.prev.next = newNode;
            newNode.next.prev = newNode;
        }
        size++;
        iteratorPoint++;
    }

    /**
     * Возвращает узел по индексу
     *
     * @param index - индекс узла
     * @return - нужный узел
     */
    private MyNode<T> getNode(int index) {
        checkIndexExistence(index);
        // чтобы не бежать по всем ссылкам, разделим на пополам
        MyNode<T> node;
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
    private T deleteNode(MyNode<T> node) {
        final T element = node.element;
        MyNode<T> prev = node.prev;
        MyNode<T> next = node.next;

        if (prev == null) {   //если prev ссылка  узла node указывает на null, то значит head
            head = next;
        } else {
            prev.next = next;   // указываем что prev узел ссылается минуя node на его следущий узел
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;  // указываем что nextNode узел ссылается минуя node на его предыдущий узел
        }

        node.element = null;
        size--;
        iteratorPoint++;
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

    /**
     * @param <T> тип
     */
    private static class MyNode<T> {
        private T element;
        private MyNode<T> next;
        private MyNode<T> prev;

        private MyNode(MyNode<T> prev, T element, MyNode<T> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private class CustomIterator implements Iterator<T> {
        int pos = 0;
        int lastPos = -1;
        int nowIteratorPoint = iteratorPoint;

        @Override
        public boolean hasNext() {
            return pos != size;
        }

        @Override
        public T next() {
            checkImmutabilityOfList();
            if (pos >= size) {
                throw new NoSuchElementException();
            }
            lastPos = pos++;
            return CustomLinkedListGeneric.this.get(lastPos);
        }

        @Override
        public void remove() {
            checkImmutabilityOfList();
            if (lastPos == -1) {
                throw new IllegalStateException();
            }
            try {
                CustomLinkedListGeneric.this.remove(pos = lastPos);
                lastPos = -1;
                nowIteratorPoint++;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        /**
         * Проверить неизменяемость листа во время работы итератора
         */
        final void checkImmutabilityOfList() {
            if (iteratorPoint != nowIteratorPoint)
                throw new ConcurrentModificationException();
        }
    }

    private class CustomListIterator implements ListIterator<T> {
        /**
         * Поля:
         * currentNode - текущий узел
         * nextNode    - следущий узел
         * index       - текущий индекс
         */
        private MyNode<T> currentNode;
        private MyNode<T> nextNode;
        private int index;
        private int nowIteratorPoint = iteratorPoint;

        CustomListIterator(int index) {
            nextNode = (index == size) ? null : getNode(index);
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            checkImmutabilityOfList();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            currentNode = nextNode;
            nextNode = nextNode.next;
            index++;
            return currentNode.element;
        }

        @Override
        public boolean hasPrevious() {
            return index > 0;
        }

        @Override
        public T previous() {
            checkImmutabilityOfList();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            nextNode = nextNode == null ? tail : nextNode.prev;
            currentNode = nextNode;
            index--;
            return currentNode.element;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            return index - 1;
        }

        @Override
        public void remove() {
            checkImmutabilityOfList();
            if (currentNode == null) {
                throw new IllegalStateException();
            }
            deleteNode(currentNode);
            index--;
            currentNode = null;
            nowIteratorPoint++;
        }

        @Override
        public void set(T element) {
            if (currentNode == null) {
                throw new IllegalStateException();
            }
            checkImmutabilityOfList();
            currentNode.element = element;
        }

        @Override
        public void add(T element) {
            checkImmutabilityOfList();
            currentNode = null;
            if (nextNode == null) {
                CustomLinkedListGeneric.this.add(element);
            } else {
                CustomLinkedListGeneric.this.add(index, element);
            }
            nowIteratorPoint++;
            index++;
        }

        /**
         * Проверить неизменяемость листа во время работы итератора
         */
        final void checkImmutabilityOfList() {
            if (iteratorPoint != nowIteratorPoint)
                throw new ConcurrentModificationException();
        }
    }
}
