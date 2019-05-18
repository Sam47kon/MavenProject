package GrandTasks.Week9_10;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CustomHashMap<K, V> implements Map<K, V> {
    private int size;
    private TreeSet<MyNode<K, V>>[] hashTable;
    private double threshold;   // порог размера
    final private double fillFactor;

    CustomHashMap() {
        hashTable = new TreeSet[16];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashMap(int capacity) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        hashTable = new TreeSet[size];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashMap(int capacity, double fillFactor) {
        if (size < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        if (fillFactor <= 0 || fillFactor >= 1) {
            throw new IllegalArgumentException("Illegal fillFactor: " + fillFactor);
        }
        hashTable = new TreeSet[size];
        this.fillFactor = fillFactor;
        threshold = hashTable.length * fillFactor;
    }

    /**
     * Для вставки в нужную ячейку массива hashTable по переданному ключу
     *
     * @return индекс, куда положить пару
     */
    private int getIndex(final K key) {
        int hash = 17 * 37 + key.hashCode();
        return hash % hashTable.length;
    }

    private void increaseTable() {
        TreeSet<MyNode<K, V>>[] oldTable = hashTable;
        hashTable = new TreeSet[oldTable.length * 2];
        size = 0;
        for (TreeSet<MyNode<K, V>> nodes : oldTable) {
            if (nodes != null) {
                for (MyNode<K, V> node : nodes) {
                    put(node.key, node.value);
                }
            }
        }
    }

    private boolean itCollision(MyNode<K, V> node, MyNode<K, V> newNode) {
        return node.hashCode() == newNode.hashCode() &&
                !Objects.equals(node.key, newNode.key) &&
                !Objects.equals(node.value, newNode.value);
    }

    private void collision(MyNode<K, V> newNode, TreeSet<MyNode<K, V>> nodes) {
        nodes.add(newNode);
        size++;
    }

    private Comparator<MyNode<K, V>> nodeComparator = new Comparator<MyNode<K, V>>() {
        @Override
        public int compare(MyNode<K, V> node1, MyNode<K, V> node2) {
            return 0;
        }
    };


//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    class MyNode<k, v> implements Map.Entry<k, v> {
        k key;
        int hash;
        v value;

        private MyNode(k key, v value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public k getKey() {
            return key;
        }

        @Override
        public v getValue() {
            return value;
        }

        @Override
        public v setValue(v newValue) { // возвращает старое значение, устанавливает новое
            v oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public int hashCode() {
            hash = 17 * 37 + key.hashCode();
            return hash;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                MyNode<?, ?> node = (MyNode<?, ?>) obj; // unchecked
                return Objects.equals(value, node.value) && Objects.equals(key, node.key);
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// Override Map

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Содержит ли данная коллекция объект с ключем key
     *
     * @return true, если есть такой ключ
     */
    @Override
    public boolean containsKey(Object key) {
        K k = (K) key;
        int index = getIndex(k);
        if (hashTable[index] != null) {
            if (hashTable[index] != null) {
                for (MyNode<K, V> node : hashTable[index]) {
                    if (Objects.equals(k, node.key)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Содержит ли данная коллекция объект value
     *
     * @return true, если имеется такой объект
     */
    @Override
    public boolean containsValue(Object value) {
        if (size > 0) {
            for (TreeSet<MyNode<K, V>> nodes : hashTable) {
                if (nodes != null) {
                    for (MyNode<K, V> node : nodes) {
                        if (Objects.equals(node.value, value)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Возвращает объект коллецкии по ключу key, если таковой есть
     */
    @Override
    public V get(Object key) {
        if (size > 0) {
            K k = (K) key;
            int index = getIndex(k);
            if (hashTable[index] == null) {
                return null;
            }
            TreeSet<MyNode<K, V>> nodeList = hashTable[index];
            for (MyNode<K, V> node : nodeList) {
                if (Objects.equals(node.key, k)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    /**
     * Вставить пару ключ key и значение value в коллекцию CustomHashMap
     *
     * @return oldValue, если значение перезаписанно, иначе null
     */
    @Nullable
    @Override
    public V put(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
            increaseTable();
        }

        MyNode<K, V> newNode = new MyNode<>(key, value);
        int index = getIndex(key);

        if (hashTable[index] == null) {
            hashTable[index] = new TreeSet<>(nodeComparator);
            hashTable[index].add(newNode);    // TODO
            size++;
            return null;
        }

        TreeSet<MyNode<K, V>> nodes = hashTable[index];
        for (MyNode<K, V> node : nodes) {
            if (Objects.equals(node.key, key)) {  // if key exist (Если данный ключ уже существует в HashMap, значение перезаписывается)
                return node.setValue(value); // set new value, return oldValue (даже если значение одинаковое, оно все равно перезаписывается)
            }
            if (itCollision(node, newNode)) {
                collision(newNode, nodes); // if collision - insert new node
                return null;
            }
        }
        return null;
    }

    /**
     * Удаляет объект коллекции по ключу key, если таковой имеется
     *
     * @return удаленный объект
     */
    @Override
    public V remove(Object key) {
        K k = (K) key;
        int index = getIndex(k);
        if (hashTable[index] == null) {
            return null;
        }
        TreeSet<MyNode<K, V>> nodes = hashTable[index];
        V oldElement = null;
        for (MyNode<K, V> node : nodes) {
            if (k.equals(node.key)) {
                oldElement = node.value;
                nodes.remove(node);
                size--;
            }
        }
        return oldElement;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> map) {
        if (map.size() > 0) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    @Override
    public void clear() {
        if (size != 0) {
            for (int i = 0; i < hashTable.length; i++) {
                hashTable[i] = null;
            }
            size = 0;
        }
    }

    // возвращает множество всех ключей
    @NotNull
    @Override
    public Set<K> keySet() {
        Set<K> keySet = new TreeSet<>();
        if (size > 0) {
            for (TreeSet<MyNode<K, V>> nodes : hashTable) {
                if (nodes != null) {
                    for (MyNode<K, V> node : nodes) {
                        keySet.add(node.key);
                    }
                }
            }
        }
        return keySet;
    }

    // Возвращает коллекцию всех значений
    @NotNull
    @Override
    public Collection<V> values() {
        Collection<V> values = new TreeSet<>(); // или аррейлист
        if (size > 0) {
            for (TreeSet<MyNode<K, V>> nodes : hashTable) {
                if (nodes != null) {
                    for (MyNode<K, V> node : nodes) {
                        values.add(node.value);
                    }
                }
            }
        }
        return values;
    }

    // Возвращает множество всех пар (ключ, значение) ТУДУ ду вайл?
    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> nodeSet = new HashSet<>();
        if (size > 0) {
            for (TreeSet<MyNode<K, V>> nodes : hashTable) {
                if (nodes != null) {
                    for (MyNode<K, V> node : nodes) {
                        nodeSet.add(new MyNode<>(node.key, node.value));
                    }
                }
            }
        }
        return nodeSet;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("{");
        if (size == 0) {
            return st.append("}").toString();
        }

        for (TreeSet<MyNode<K, V>> nodes : hashTable) {
            if (nodes != null) {
                for (MyNode<K, V> node : nodes) {
                    st.append(node.toString()).append(";");
                }
            }
        }
        return st.append("}").toString();
    }
}