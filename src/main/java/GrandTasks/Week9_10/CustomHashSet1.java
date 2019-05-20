package GrandTasks.Week9_10;

public class CustomHashSet1<E> /*implements Set<E>*/ {
//    private CustomHashMap<E, Object> map;
//    private static final Object obj = new Object();
//
//
//    private int size;
//    private MyNode<E>[] hashTable;
//    private double threshold;   // порог размера
//    final private double fillFactor;
//
//    // region utility
//    class MyNode<K> {
//        K key;
//        int hash;
//        MyNode<K> next;
//
//
//        private MyNode(K key, MyNode<K> next) {
//            this.key = key;
//            this.next = next;
//        }
//
//        public K getKey() {
//            return key;
//        }
//
//        @Override
//        public int hashCode() {
//            hash = 17 * 37 + key.hashCode();
//            return hash;
//        }
//
//        @SuppressWarnings("unchecked")
//        @Override
//        public boolean equals(Object obj) {
//            if (obj == this) {
//                return true;
//            }
//            if (obj instanceof MyNode) {
//                MyNode<K> node = (MyNode<K>) obj; // unchecked
//                return Objects.equals(key, node.key);
//            }
//            return false;
//        }
//
//        @Override
//        public String toString() {
//            return key + "";
//        }
//    }
//
//    private int getIndex(final E key) {
//        int hash = 17 * 37 + key.hashCode();
//        return hash % hashTable.length;
//    }
//
//    private void increaseTable() {
//        MyNode<E>[] oldTable = hashTable;
//        hashTable = new MyNode[oldTable.length * 2];
//        size = 0;
//        for (MyNode<E> node : oldTable) {
//            if (hashTable != null) {
//                add(node.key);
//            }
//        }
//    }
//// endregion------------------------------------------------------------------------------------------------------------
//    // region constructors
//
//    CustomHashSet1() {
//        hashTable = new MyNode[16];
//        fillFactor = 0.75;
//        threshold = hashTable.length * fillFactor;
//    }
//
//    CustomHashSet1(int capacity) {
//        if (capacity < 0) {
//            throw new IllegalArgumentException("Illegal capacity: " + capacity);
//        }
//        size = capacity;
//        hashTable = new MyNode[size];
//        fillFactor = 0.75;
//        threshold = hashTable.length * fillFactor;
//
//    }
//
//    CustomHashSet1(int capacity, double fillFactor) {
//        if (capacity < 0) {
//            throw new IllegalArgumentException("Illegal capacity: " + capacity);
//        }
//        size = capacity;
//        if (fillFactor <= 0 || fillFactor >= 1) {
//            throw new IllegalArgumentException("Illegal fillFactor: " + fillFactor);
//        }
//        hashTable = new MyNode[size];
//        threshold = hashTable.length * (this.fillFactor = fillFactor);
//    }
//
//// endregion------------------------------------------------------------------------------------------------------------
//    // region override
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public boolean contains(Object obj) { // TODO
//        return map.containsKey(obj);
//    }
//
//    @NotNull
//    @Override
//    public Iterator<E> iterator() { // TODO
//        return map.keySet().iterator();
//    }
//
//    @NotNull
//    @Override
//    public Object[] toArray() { // TODO
//        Object[] array = new Object[size()];
//        Iterator<E> iterator = map.keySet().iterator();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = iterator.next();
//        }
//        return array;
//    }
//
//    @NotNull
//    @Override
//    public <T> T[] toArray(@NotNull T[] array) { // TODO
//        return null;
//    }
//
//    @Override
//    public boolean add(E element) {
//        if (size + 1 >= threshold) {
//            threshold *= 2;
//            increaseTable();
//        }
//        MyNode<E> newNode = new MyNode<>(element, null);
//        int index = getIndex(element);
//        if (hashTable[index] == null) {
//            hashTable[index] = newNode;
//            size++;
//            return true;
//        }
//        if (hashTable[index].key.equals(element)) {
//            return false;
//        }
//        addNode(hashTable[index], newNode);
//        return true;
//    }
//
//    private void addNode(MyNode<E> tableNode, MyNode<E> newNode) {
//        if (tableNode.next == null) {
//            tableNode.next = newNode;
//        } else {
//            addNode(tableNode.next, newNode);
//        }
//    }
//
//    @Override
//    public boolean remove(Object element) {
//        E key = (E) element;
//        int index = getIndex(key);
//        if (hashTable[index] == null) {
//            return false;
//        }
//        MyNode<E> nodes = hashTable[index];
//        for (MyNode<E> node = nodes; node != null; node = node.next) {
//
//            if (node.next == null) {
//                if (element.equals(node.key)) {
//                    node.key = null;
//                    node = null;
//                    return true;
//                }
//            }
//
//            if (element.equals(node.key)) {
//                node.key = null;
//                if (node.next == null) {
//
//                }
//                size--;
//            }
//        }
//        return map.remove(element) == null;
//    }
//
//
//    @Override
//    public boolean containsAll(@NotNull Collection<?> collection) { // готово
//        for (Object obj : collection) {
//            if (!contains(obj)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public boolean addAll(@NotNull Collection<? extends E> collection) { // готово
//        int count = 0;
//        for (E e : collection) {
//            if (add(e)) {
//                count++;
//            }
//        }
//        return count > 0;
//    }
//
//    @Override
//    public boolean retainAll(@NotNull Collection<?> collection) {
//
//        return false;
//    }
//
//    @Override
//    public boolean removeAll(@NotNull Collection<?> collection) {
//        boolean changed = false;
//        for (Object obj : collection) {
//            if (contains(obj)) {
//                remove(obj);
//                changed = true;
//            }
//        }
//        return changed;
//    }
//
//    @Override
//    public void clear() {
//        map.clear();
//    }
//
//
//    public String toString() {
//        StringBuilder st = new StringBuilder();
//        Iterator<E> iterator = map.keySet().iterator();
//        st.append("{");
//        for (int i = 0; i < size() - 1; i++) {
//            st.append(iterator.next()).append(", ");
//        }
//        return st.append(iterator.next()).append("}").toString();
//    }
//// endregion -----------------------------------------------------------------------------------------------------------
}
