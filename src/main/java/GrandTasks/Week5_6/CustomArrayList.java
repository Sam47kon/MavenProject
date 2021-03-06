package GrandTasks.Week5_6;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CustomArrayList implements List {

    private Object[] dataElements = new Object[10];
    private int size = 0;

    public static void main(String[] args) {
        CustomArrayList myCustomList = new CustomArrayList();
        myCustomList.add(1);
        System.out.println(myCustomList.get(0));
        myCustomList.add(2);
        System.out.println(myCustomList.get(1));
        myCustomList.add(3);
        System.out.println(myCustomList.get(2));
        System.out.println(myCustomList.toString());

    }

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
        return Arrays.copyOf(dataElements, size);
    }

    /**
     * Добавляет указанный элемент в конец этого списка и возвращает true
     *
     * @param newDataElement - указанный элемент
     */
    @Override
    public boolean add(Object newDataElement) {//
        if (newDataElement == null) {
            throw new NullPointerException("Исключение нулевого указателя");
        }
        increaseDataElementsLength();
        dataElements[size++] = newDataElement;
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
        increaseDataElementsLength();
        System.arraycopy(dataElements, index, dataElements, index + 1, size++ - index);
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
    public Object remove(int index) {
        checkIndexExistence(index);
        Object oldElement = dataElements[index];
        decreaseDataElementsLength();
        for (int i = index; i < size - 1; i++) {
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
    public boolean addAll(@NotNull Collection addedCollection) {
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
    public boolean addAll(int index, @NotNull Collection addedCollection) {
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
    public boolean containsAll(@NotNull Collection specifiedCollection) {
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
    public Object[] toArray(@NotNull Object[] arr) {
        if (arr.length < size) {
            return Arrays.copyOf(dataElements, size);
        }
        System.arraycopy(dataElements, 0, arr, 0, size);
        if (arr.length > size) {
            int interval = arr.length - size;
            for (int i = arr.length - 1; i >= interval; i--) {
                arr[i] = null;
            }
        }
        return dataElements;
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

    void toStringMy() {
        System.out.print("[");
        for (int i = 0; i < dataElements.length; i++) {
            System.out.print(dataElements[i] + ", ");
        }
        System.out.println("]");
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

// В аргументах arraycopy() передаётся 1 откуда массив,
// 2 начальная позиция копирования откуда массиве,
// 3 куда массив,
// 4 начальная позиция копирования  куда массиве,
// 5 количество копируемых элементов.
// Любое нарушение границ массива приведёт к исключению.

}
