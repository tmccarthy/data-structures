package au.id.tmm.datastructures.list;

import au.id.tmm.datastructures.Iterator;

/**
 * Simple implementation of a dynamic array.
 */
@SuppressWarnings("ManualArrayCopy")
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    private static final float DEFAULT_EXPANSION_RATIO = 1.5f;

    private float expansionRatio;

    private E[] array;

    private int size = 0;

    /**
     * Full constructor, allowing the caller to set the initial capacity of the
     * array and the ratio by which the capacity will be increased when the
     * array becomes full.
     */
    public ArrayList(int initialCapacity, float expansionRatio) {
        this.expansionRatio = expansionRatio;
        this.array = newArray(initialCapacity);
    }

    /**
     * Constructor allowing the caller to set the inital capacity of the array.
     */
    public ArrayList(int initialCapacity) {
        this(initialCapacity, DEFAULT_EXPANSION_RATIO);
    }

    /**
     * Construct an empty ArrayList. Initial capacity is set to
     * {@value ArrayList#DEFAULT_INITIAL_CAPACITY}.
     */
    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E toAdd) {

        if (this.arrayIsFull()) {
            this.expandArray();
        }

        this.array[size++] = toAdd;

        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(int index, E toAdd) {
        // TODO add by index.
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(E toRemove) {
        // TODO remove the first matching element
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        // TODO remove by index
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public E get(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            return this.array[index];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void set(int index, E toSet) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            this.array[index] = toSet;
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("UnusedAssignment")
    @Override
    public void clear() {
        for (E currentElement : this.array) {
            currentElement = null;
        }
        size = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E e) {
        // TODO return true if there is a matching element in the array
        return false;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return new ConcreteArrayListIterator();
    }

    private class ConcreteArrayListIterator implements Iterator<E> {

        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return array[currentIndex + 1] != null;
        }

        @Override
        public E next() {
            return array[++currentIndex];
        }
    }

    private boolean arrayIsFull() {
        return this.size == this.array.length;
    }

    private void expandArray() {
        this.array = this.copyToNewArray(this.array, (int) (this.array.length * this.expansionRatio));
    }

    private E[] copyToNewArray(E[] oldArray, int newCapacity) {
        if (oldArray.length > newCapacity) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E[] newArray = this.newArray(newCapacity);

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    @SuppressWarnings("unchecked")
    private E[] newArray(int capacity) {
        return (E[]) new Object[capacity];
    }
}
