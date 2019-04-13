package GrandTasks.Week5_6;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AndreyArrayList<E> implements List<E> {

    int defaultSize = 10;

    private Object[] myArray = new Object[defaultSize];

    private int size = 0; //

//    public void setMyArray(Object[] myArray) {
//        this.myArray = myArray;
//    }


    @Override
    //add element
    public boolean add(E element) {

        growArray();
        myArray[size++] = element;

        return true;
    }

    //увеличение массива ---------------------------------------------------------------------------------------------

    public void growArray() {
        if (size == myArray.length) {
            Object[] tmp = myArray;
            myArray = new Object[tmp.length * 2];
            System.arraycopy(tmp, 0, myArray, 0, tmp.length);

        }
    }


    //add element-------------------------------------------------------------------------------------------------------

    @Override
    public void add(int index, E element) {
        growArray();
        System.arraycopy(myArray, index, myArray, index + 1, size - index);
        myArray[index] = element;
        size++;
//        }


    }

    //get ++---------------------------------------------------------------------------------------------------------------

    @Override
    public E get(int index) {
        return (E) myArray[index];
    }

    //size ++------------------------------------------------------------------------------------------------------

    @Override
    public int size() {
        return size;
    }

    //indexOf++         ------------------------------------------------------------------------------------------------
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(myArray[i])) {
                return i;
            }
        }
        return -1;
    }

    //remove-----------------------------------------------------------------------------------------------------------------

    @Override
    public E remove(int index) {
        E result = (E) myArray[index];
        Object[] tmp = myArray;
        myArray = new Object[tmp.length - 1];
        System.arraycopy(tmp, 0, myArray, 0, index);
        System.arraycopy(tmp, index + 1, myArray, index, size - 1 - index);
        size--;

        return result;

    }

    //set----------------------------------------------------------------------------------------------------------

    @Override
    public E set(int index, E element) {
        E result = (E) myArray[index];

        return (E) (myArray[index] = element);

    }


    //----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }


    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public String toString() {
        return String.valueOf(myArray);
    }


}
