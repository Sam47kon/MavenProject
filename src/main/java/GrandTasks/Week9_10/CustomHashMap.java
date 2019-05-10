package GrandTasks.Week9_10;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class CustomHashMap<K, V> implements Map<K, V> {
    private int size;
    private MyEntry<K, V>[] table;
    private Set<Map.Entry<K, V>> entrySet;

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Nullable
    @Override
    public V put(K key, V value) {
        return null;
    }

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

    static class MyEntry<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        MyEntry<K, V> next;

        public MyEntry(int hash, K key, V value, MyEntry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) { // возвращает старое значение, устанавливает новое
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        @Override
        public final int hashCode() {
            int result = 17 * 37 + key.hashCode();
            result = result * 37 + value.hashCode();
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof Map.Entry) {
                return Objects.equals(value, ((MyEntry) obj).getValue()) && Objects.equals(key, ((MyEntry) obj).getKey());
            }
            return false;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}
