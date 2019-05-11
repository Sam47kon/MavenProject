package GrandTasks.Week9_10;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class CustomHashMap<K, V> implements Map<K, V> {
    private MyNode<K, V>[] hashTable;
    private Set<Map.Entry<K, V>> entrySet;
    private int size;
    private double threshold;   // порог размера

    public CustomHashMap() {
        hashTable = new MyNode[16];
        threshold = hashTable.length * 0.75;
    }


    /**
     * Для вставки в нужную ячейку массива hashTable по переданному ключу
     *
     * @return индекс, куда положить пару
     */
    private int hash(final K key) {
        int hash = 17 * 37 + key.hashCode();
        return hash % hashTable.length;
    }

    /**
     * Для вставки в нужную ячейку массива hashTable по переданному node
     *
     * @return индекс, куда положить пару
     */
    private int hash(MyNode<K, V> node) {
        return node.hashCode() % hashTable.length;
    }

    private void expandTable() {

    }
//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

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
        return false;
    }

    /**
     * Содержит ли данная коллекция объект value
     *
     * @return true, если имеется такой объект
     */
    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    /**
     * Возвращает объект коллецкии по ключу key, если таковой есть
     */
    @Override
    public V get(Object key) {
        return null;
    }

    /**
     * Вставить пару ключ key и значение value в коллекцию CustomHashMap
     */
    @Nullable
    @Override
    public V put(K key, V value) {
        if (size + 1 >= threshold) {
            threshold *= 2;
        }

        MyNode<K, V> newNode = new MyNode<>(key, value, null);
//        int index = hash(newNode);    // без разницы это или:
        int index = newNode.hash();
        if (hashTable[index] == null) {
            hashTable[index] = newNode;
            return null;
        }


        hashTable[index] = newNode;
        return null;
    }

    /**
     * Удаляет объект коллекции по ключу key, если таковой имеется
     *
     * @return удаленный объект
     */
    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @NotNull
    @Override
    public Set<K> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<V> values() {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        return super.equals(obj);
//    }
//
//    @Override
//    public String toString() {
//        return super.toString();
//    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    class MyNode<k, v> implements Map.Entry<k, v> {
        private MyNode<k, v> next;
        private int hash;
        final k key;
        v value;

        private MyNode(k key, v value, MyNode<k, v> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        private int hash() {
            return hashCode() % hashTable.length;
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
        public final int hashCode() {
            hash = 17 * 37 + key.hashCode();
            hash = hash * 37 + value.hashCode();
            return hash;
        }

        @SuppressWarnings("unchecked")
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                MyNode<k, v> node = (MyNode) obj; // unchecked
                return Objects.equals(value, node.getValue()) && Objects.equals(key, node.getKey());
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
