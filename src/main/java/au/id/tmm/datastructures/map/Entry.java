package au.id.tmm.datastructures.map;

public class Entry<K, V> {

    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Entry(K key) {
        this(key, null);
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
