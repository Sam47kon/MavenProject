package GrandTasks.Week9_10;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

//@SuppressWarnings("unchecked")
public class CustomHashMap<K, V> implements Map<K, V> {
    final private double fillFactor;
    private int size;
    private LinkedList<MyCouple<K, V>>[] hashTable;
    private double threshold;   // порог размера

    CustomHashMap() {
        hashTable = new LinkedList[16];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashMap(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        hashTable = new LinkedList[size];
        fillFactor = 0.75;
        threshold = hashTable.length * fillFactor;
    }

    CustomHashMap(int capacity, double fillFactor) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " + capacity);
        }
        size = capacity;
        if (fillFactor <= 0 || fillFactor >= 1) {
            throw new IllegalArgumentException("Illegal fillFactor: " + fillFactor);
        }
        hashTable = new LinkedList[size];
        this.fillFactor = fillFactor;
        threshold = hashTable.length * fillFactor;
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

    /**
     * Для вставки в нужную ячейку массива hashTable по переданному ключу
     *
     * @return индекс, куда положить пару
     */
    private int getIndex(final int hash) {
        return (hashTable.length - 1) & hash;
    }

    private int hash(final K key) {
        int hash = key.hashCode();
        return hash ^ (hash >>> 16);
    }

    private void increaseTable() {
        LinkedList<MyCouple<K, V>>[] oldTable = hashTable;
        hashTable = new LinkedList[oldTable.length * 2];
        size = 0;
        for (LinkedList<MyCouple<K, V>> couples : oldTable) {
            if (couples != null) {
                for (MyCouple<K, V> couple : couples) {
                    add(couple.key, couple.value);
                }
            }
        }
    }

    private V add(K key, V value) {
        MyCouple<K, V> newCouple = new MyCouple<>(key, value);
        int index = getIndex(hash(key));

        if (hashTable[index] == null) {
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(newCouple);
            size++;
            return null;
        }
        LinkedList<MyCouple<K, V>> couples = hashTable[index];
        for (MyCouple<K, V> couple : couples) {
            if (isCollision(couple.key, key)) {
                collision(newCouple, couples);
                return null;
            }
            if (Objects.equals(couple.key, key)) {  // if key exist (Если данный ключ уже существует в HashMap, значение перезаписывается)
                return couple.setValue(value); // set new value, return oldValue (даже если значение одинаковое, оно все равно перезаписывается)
            }
        }
        collision(newCouple, couples);
        return null;
    }

    private boolean isCollision(K key, K newKey) {
        return hash(key) == hash(newKey) &&
                !Objects.equals(key, newKey);
    }

    private void collision(MyCouple<K, V> newCouple, LinkedList<MyCouple<K, V>> couples) {
        couples.add(newCouple);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------
// Override Map

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
        int index = getIndex(hash((k)));
        if (hashTable[index] != null) {
            for (MyCouple<K, V> couple : hashTable[index]) {
                if (Objects.equals(key, couple.key)) {
                    return true;
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
            for (LinkedList<MyCouple<K, V>> couples : hashTable) {
                if (couples != null) {
                    for (MyCouple<K, V> couple : couples) {
                        if (Objects.equals(couple.value, value)) {
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
            int index = getIndex(hash((K) key));
            if (hashTable[index] == null) {
                return null;
            }
            LinkedList<MyCouple<K, V>> couples = hashTable[index];
            for (MyCouple<K, V> couple : couples) {
                if (Objects.equals(couple.key, key)) {
                    return couple.value;
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
        return add(key, value);
    }

    /**
     * Удаляет объект коллекции по ключу key, если таковой имеется
     *
     * @return удаленный объект
     */
    @Override
    public V remove(Object key) {
        int index = getIndex(hash((K) key));
        if (hashTable[index] == null) {
            return null;
        }
        LinkedList<MyCouple<K, V>> couples = hashTable[index];
        V oldElement;
        for (MyCouple<K, V> couple : couples) {
            if (key.equals(couple.key)) {
                oldElement = couple.value;
                couples.remove(couple);
                size--;
                return oldElement;
            }
        }
        return null;
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
        Set<K> keySet = new HashSet<>();
        if (size > 0) {
            for (LinkedList<MyCouple<K, V>> couples : hashTable) {
                if (couples != null) {
                    for (MyCouple<K, V> couple : couples) {
                        keySet.add(couple.key);
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
        Collection<V> values = new ArrayList<>();
        if (size > 0) {
            for (LinkedList<MyCouple<K, V>> couples : hashTable) {
                if (couples != null) {
                    for (MyCouple<K, V> couple : couples) {
                        values.add(couple.value);
                    }
                }
            }
        }
        return values;
    }

    // Возвращает множество всех пар (ключ, значение)
    @NotNull
    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        if (size > 0) {
            for (LinkedList<MyCouple<K, V>> couples : hashTable) {
                if (couples != null) {
                    for (MyCouple<K, V> couple : couples) {
                        set.add(new MyCouple<>(couple.key, couple.value));
                    }
                }
            }
        }
        return set;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("{");
        if (size == 0) {
            return st.append("}").toString();
        }

        for (LinkedList<MyCouple<K, V>> couples : hashTable) {
            if (couples != null) {
                for (MyCouple<K, V> couple : couples) {
                    st.append(couple.toString()).append(";");
                }
            }
        }
        return st.append("}").toString();
    }

    class MyCouple<k, v> implements Map.Entry<k, v> {
        k key;
        int hash;
        v value;

        private MyCouple(k key, v value) {
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

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                MyCouple<?, ?> couple = (MyCouple<?, ?>) obj; // unchecked
                return Objects.equals(value, couple.value) && Objects.equals(key, couple.key);
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}