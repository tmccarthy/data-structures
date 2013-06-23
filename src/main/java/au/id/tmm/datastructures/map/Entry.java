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

    // Generated equals and hashcode methods.

    @SuppressWarnings("RedundantIfStatement")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (key != null ? !key.equals(entry.key) : entry.key != null) return false;
        if (value != null ? !value.equals(entry.value) : entry.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
