package au.id.tmm.datastructures.map;

import au.id.tmm.datastructures.Array;
import au.id.tmm.datastructures.Iterator;
import au.id.tmm.datastructures.list.LinkedList;
import au.id.tmm.datastructures.list.List;
import au.id.tmm.datastructures.set.LinkedListSet;
import au.id.tmm.datastructures.set.Set;

/**
 * Map implementation backed by a hash table.
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private static final float DEFAULT_EXPANSION_RATIO = 2.0f;

    private final float loadFactor;
    private final float expansionRatio;

    private int size = 0;
    private Array<List<Entry<K, V>>> array;

    /**
     * Full constructor, sets initial capacity, load factor and expansion ratio
     * to given values.
     */
    public HashMap(int initialCapacity, float loadFactor, float expansionRatio) {
        this.loadFactor = loadFactor;
        this.expansionRatio = expansionRatio;
        this.array = new Array<List<Entry<K, V>>>(initialCapacity);
    }

    /**
     * Reduced constructor, sets the initial capacity and load factor to the
     * given values and sets expansion ratio to default value of
     * {@value HashMap#DEFAULT_EXPANSION_RATIO}
     */
    public HashMap(int initialCapacity, float loadFactor) {
        this(initialCapacity, loadFactor, DEFAULT_EXPANSION_RATIO);
    }

    /**
     * Reduced constructor, sets initial capacity. Load factor is set to
     * default value of {@value HashMap#DEFAULT_LOAD_FACTOR}, expansion ratio
     * is set to default value of {@value HashMap#DEFAULT_EXPANSION_RATIO}.
     */
    public HashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * Default constructor, sets initial capacity to default value of
     * {@value HashMap#DEFAULT_INITIAL_CAPACITY}, load factor to default
     * value of {@value HashMap#DEFAULT_LOAD_FACTOR} expansion ratio
     * is set to default value of {@value HashMap#DEFAULT_EXPANSION_RATIO}.
     */
    public HashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V put(K key, V value) {
        this.expandIfLoadFactorExceeded();

        Entry<K, V> existingEntry = this.getEntry(key);

        if (existingEntry == null) {
            this.addEntry(new Entry<K, V>(key, value));
            this.size++;
            return null;
        } else {
            V formerValue = existingEntry.getValue();
            existingEntry.setValue(value);
            return formerValue;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V remove(K key) {

        Entry<K, V> existingEntry = this.getEntry(key);

        if (existingEntry == null) {
            return null;
        } else {
            this.array.get(computeBin(key)).remove(existingEntry);
            this.size--;
            return existingEntry.getValue();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public V get(K key) {
        Entry <K, V> matchingEntry = this.getEntry(key);
        if (matchingEntry == null) {
            return null;
        } else {
            return matchingEntry.getValue();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsKey(K key) {

        for (Iterator<Entry<K, V>> it = this.array.get(computeBin(key)).iterator(); it.hasNext(); ) {
            if (it.next().getKey().equals(key)) {
                return true;
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean containsValue(V value) {
        return this.getValueSet().contains(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<K> getKeySet() {

        // TODO use more appropriate Set
        Set<K> returnedSet = new LinkedListSet<K>();

        for (Iterator<Entry<K, V>> it = this.getEntrySet().iterator(); it.hasNext(); ) {
            returnedSet.add(it.next().getKey());
        }

        return returnedSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<V> getValueSet() {

        // TODO use more appropriate Set
        Set<V> returnedSet = new LinkedListSet<V>();

        for (Iterator<Entry<K, V>> it = this.getEntrySet().iterator(); it.hasNext(); ) {
            returnedSet.add(it.next().getValue());
        }

        return returnedSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Entry<K, V>> getEntrySet() {

        // TODO use more appropriate Set
        Set<Entry<K, V>> returnedSet = new LinkedListSet<Entry<K, V>>();

        for (int i = 0; i < this.array.length(); i++) {
            if (this.array.get(i) != null) {
                for (Iterator<Entry<K, V>> it = this.array.get(i).iterator(); it.hasNext(); ) {
                    returnedSet.add(it.next());
                }
            }
        }

        return returnedSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {

        for (int i = 0; i < this.array.length(); i++) {
            if (this.array.get(i) != null) {
                this.array.get(i).clear();
            }
        }

        this.size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.size;
    }

    private void expandIfLoadFactorExceeded() {
        while (this.hasExceededLoadFactor()) {
            this.setNewCapacity((int) (this.array.length() * this.expansionRatio));
        }
    }

    private boolean hasExceededLoadFactor() {
        return (this.getSize() / this.array.length()) > this.loadFactor;
    }

    private void setNewCapacity(int newCapacity) {

        Set<Entry<K, V>> existingEntries = this.getEntrySet();

        this.array = new Array<List<Entry<K, V>>>(newCapacity);

        for (Iterator<Entry<K, V>> it = existingEntries.iterator(); it.hasNext(); ) {
            this.addEntry(it.next());
        }
    }

    private Entry<K, V> getEntry(K key) {
        int bin = computeBin(key);

        if (this.array.get(bin) == null) {
            return null;
        } else {
            for (Iterator<Entry<K, V>> it = this.array.get(bin).iterator(); it.hasNext(); ) {
                Entry<K, V> thisEntry = it.next();

                if (thisEntry.getKey().equals(key)) {
                    return thisEntry;
                }
            }

            return null;
        }
    }

    private void addEntry(Entry<K, V> entry) {
        int bin = this.computeBin(entry.getKey());
        if (this.array.get(bin) == null) {
            this.array.set(bin, new LinkedList<Entry<K, V>>());
        }

        this.array.get(bin).add(entry);
    }

    private int computeBin(K key) {
        return key.hashCode() % this.array.length();
    }
}
