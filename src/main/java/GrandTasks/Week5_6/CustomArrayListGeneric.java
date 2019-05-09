package GrandTasks.Week5_6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomArrayListGeneric<T> implements List<T> {

    private Object[] dataElements = new Object[10];
    private int size = 0;
    private int iteratorPoint = 0;


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

    /**
     * Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
     */
    @NotNull
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(dataElements, size);
    }

    /**
     * Добавляет указанный элемент в конец этого списка и возвращает true
     *
     * @param newDataElement - указанный элемент
     */
    @Override
    public boolean add(T newDataElement) {//
        if (newDataElement == null) {
            throw new NullPointerException("Исключение нулевого указателя");
        }
        increaseDataElementsLength();
        dataElements[size++] = newDataElement;
        iteratorPoint++;
        return true;
    }

    /**
     * Вставляет указанный элемент в указанную позицию в этом списке.
     *
     * @param index          - указанная позиция
     * @param newDataElement - указанный элемент
     */
    @Override
    public void add(int index, T newDataElement) {
        checkIndexExistence(index);
        increaseDataElementsLength();
        System.arraycopy(dataElements, index, dataElements, index + 1, size++ - index);
        dataElements[index] = newDataElement;
        iteratorPoint++;
    }

    /**
     * Добавляет все элементы в указанной коллекции в конец этого списка
     *
     * @param addedCollection - добавляемая коллекция
     * @return - true, если коллекция не пустая
     */
    @Override
    public boolean addAll(@NotNull Collection<? extends T> addedCollection) {
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        size = addedElements.length + size;
        iteratorPoint++;
        dataElements = Arrays.copyOf(dataElements, size);
        System.arraycopy(addedElements, 0, dataElements, dataElements.length - addedElements.length, addedElements.length);
        return true;
    }

    /**
     * Вставляет все элементы из указанной коллекции в этот список, начиная с указанной позиции. либо false если колекция пустая
     */
    @Override
    public boolean addAll(int index, @NotNull Collection<? extends T> addedCollection) {
        Object[] addedElements = addedCollection.toArray();
        if (addedElements.length == 0) {
            return false;
        }
        int oldSize = size;
        size = addedElements.length + size;
        iteratorPoint++;
        dataElements = Arrays.copyOf(dataElements, size);
        System.arraycopy(dataElements, index, dataElements, addedElements.length + index, oldSize - index);
        System.arraycopy(addedElements, 0, dataElements, index, addedElements.length);
        return true;
    }

    /**
     * Удаляет первое вхождение указанного элемента из этого списка, если он присутствует.
     *
     * @param soughtObject - указанный объект (искомый)
     * @return true, если объект есть
     */
    @Override
    public boolean remove(Object soughtObject) {
        decreaseDataElementsLength();
        int oldSize = size;
        for (int index = 0; index < oldSize; index++) {
            if (Objects.equals(soughtObject, dataElements[index])) {
                System.arraycopy(dataElements, index + 1, dataElements, index, oldSize - index);
                size--;
                iteratorPoint++;
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
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
        checkIndexExistence(index);
        T oldElement = (T) dataElements[index];
        for (int i = index; i < size - 1; i++) {
            dataElements[i] = dataElements[i + 1];
        }
        decreaseDataElementsLength();
        size--;
        iteratorPoint++;
        return oldElement;
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
        iteratorPoint=0;
    }

    /**
     * Возвращает элемент в указанной позиции в этом списке
     *
     * @param index - указанная позиция
     * @return элемент
     */
    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        checkIndexExistence(index);
        return (T) dataElements[index];
    }

    /**
     * Заменяет элемент в указанной позиции в этом списке на указанный элемент, возвращает старый элемент
     *
     * @param index      - указанная позиция
     * @param newElement - новый элемент
     * @return старый элемент в указанной позиции
     */
    @SuppressWarnings("unchecked")
    @Override
    public T set(int index, T newElement) {
        checkIndexExistence(index);
        T oldElement = (T) dataElements[index];
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

    /**
     * Удаляет из этого списка все его элементы, которые содержатся в указанной коллекции.
     *
     * @param inputCollection - указанная коллекция
     * @return false, если нечего удалять (пустая или ни однин объект не одинаковый)
     */
    @Override
    public boolean removeAll(@NotNull Collection inputCollection) {
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

        for (Object deletedElement : deletedElements) {
            for (int index = 0; index < oldSize - 1; index++) {
                if (Objects.equals(deletedElement, deletedElements[index])) {
                    remove(deletedElement);
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
    public boolean containsAll(@NotNull Collection<?> specifiedCollection) {
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
    @SuppressWarnings("unchecked")
    @Override
    public <T1> T1[] toArray(@NotNull T1[] arr) {
        if (arr.length < size) {
            return (T1[]) Arrays.copyOf(dataElements, size, arr.getClass());
        }
        System.arraycopy(dataElements, 0, arr, 0, size);

        if (arr.length > size) {
            int interval = arr.length - size;
            for (int i = arr.length - 1; i >= interval; i--) {
                arr[i] = null;
            }
        }
        return arr;
    }

    @Override
    public String toString() {
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

// -----------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

    /**
     * Возвращает итератор для элементов в этом списке в правильной последовательности.
     */
    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    @NotNull
    @Override
    public ListIterator<T> listIterator() { // TODO остановился здесь
        throw new UnsupportedOperationException();

    }

    @NotNull
    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @NotNull
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(@NotNull Collection c) {
        throw new UnsupportedOperationException();
    }

    /**
     * Итератор
     */
    private class CustomIterator implements Iterator<T> {
        int pos = 0;
        int lastPos = -1;
        int nowIteratorPoint = iteratorPoint;

        @Override
        public boolean hasNext() {
            return pos != size;
        }

        @SuppressWarnings("unchecked")
        @Override
        public T next() {
            checkImmutabilityOfList();
            if (pos >= size) {
                throw new NoSuchElementException();
            }
            lastPos = pos++;
            return (T) dataElements[lastPos];
        }

        @Override
        public void remove() {
            checkImmutabilityOfList();
            if (lastPos == -1) {
                throw new IllegalStateException();
            }
            try {
                CustomArrayListGeneric.this.remove(pos = lastPos);
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

// -----------------------------------------------------------------------------------------------------------------
// -----------------------------------------------------------------------------------------------------------------

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
     * Увеличиваем длину массива объектов в 1.5 раз
     */
    private void increaseDataElementsLength() {
        if (dataElements.length == size) {
            dataElements = Arrays.copyOf(dataElements, (int) (dataElements.length * 1.5));
        }
    }

    /**
     * Уменьшаем длину массива объектов в 1.5 раз
     */
    private void decreaseDataElementsLength() {
        if (dataElements.length > size * 1.5) {
            dataElements = Arrays.copyOf(dataElements, (int) (dataElements.length / 1.5) + 1);
        }
    }

}
