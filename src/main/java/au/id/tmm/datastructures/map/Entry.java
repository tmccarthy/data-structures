package au.id.tmm.datastructures.map;

/**
 * Class representing a Key-Value pair in a Map.
 */
public class Entry<K, V> {

    private K key;
    private V value;

    /**
     * Full constructor.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Reduced constructor, the value is set to null.
     * @param key
     */
    public Entry(K key) {
        this(key, null);
    }

    /**
     * Retrieve key.
     */
    public K getKey() {
        return this.key;
    }

    /**
     * Retrieve value.
     */
    public V getValue() {
        return this.value;
    }

    /**
     * Set value.
     */
    public void setValue(V value) {
        this.value = value;
    }
}
