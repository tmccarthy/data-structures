package au.id.tmm.datastructures.map;

import au.id.tmm.datastructures.set.Set;

/**
 * Interface defining the methods available for maps in this
 * data structures project.
 */
public interface Map<K, V> {

    /**
     * Put the given key-value pair in the map.
     * @return the previous mapping for K, or null if there wasn't one
     */
    public V put(K key, V value);

    /**
     * Remove the value corresponding to the given key from the map.
     * @return The value associated with the given key.
     */
    public V remove(K key);

    /**
     * Retrieve the Value associated with the given key.
     */
    public V get(K key);

    /**
     * Test if the map contains a mapping for the given key.
     */
    public boolean containsKey(K key);

    /**
     * Test if the map contains the given value.
     */
    public boolean containsValue(V value);

    /**
     * Retrieve a set containing the keys from the map.
     */
    public Set<K> getKeySet();

    /**
     * Retrieve a set containing the values from the map.
     */
    public Set<V> getValueSet();

    /**
     * Retrieve a set of the {@link Entry}s in the map.
     */
    public Set<Entry<K, V>> getEntrySet();

    /**
     * Empty the Map.
     */
    public void clear();

    /**
     * Test if the Map is empty.
     */
    public boolean isEmpty();

    /**
     * Compute the size of the map.
     */
    public int getSize();
}
