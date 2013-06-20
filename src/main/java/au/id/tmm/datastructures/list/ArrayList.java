package au.id.tmm.datastructures.list;

import au.id.tmm.datastructures.Iterator;

/**
 * Simple implementation of a dynamic array.
 */
@SuppressWarnings("ManualArrayCopy")
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 15;
    private static final float DEFAULT_EXPANSION_RATIO = 2f;

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

        if (index > this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        if (this.arrayIsFull()) {
            this.expandArray();
        }

        for (int i = size - 1; i > index; i--) {
            array[i + 1] = array[i];
        }

        array[index] = toAdd;

        this.size++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(E toRemove) {
        try {
            this.remove(this.getFirstIndexOfElement(toRemove));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        if (index >= this.size) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = index; i < this.size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[this.size - 1] = null;

        this.size--;
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
        try {
            this.getFirstIndexOfElement(e);
            return true;
        } catch (NoSuchElementException e1) {
            return false;
        }
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

    /**
     * Indicates if the array is full
     */
    private boolean arrayIsFull() {
        return this.size == this.array.length;
    }

    /**
     * Expands the array by the expansion ratio associated with this class
     */
    private void expandArray() {
        this.array = this.copyToNewArray(this.array, (int) (this.array.length * this.expansionRatio));
    }

    /**
     * Copies the contents of an array into a new array with the given capacity.
     * The new capacity must be greater than or equal to the length of the
     * old array.
     */
    private E[] copyToNewArray(E[] oldArray, int newCapacity) {
        if (oldArray.length >= newCapacity) {
            throw new ArrayIndexOutOfBoundsException();
        }

        E[] newArray = this.newArray(newCapacity);

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        return newArray;
    }

    /**
     * Creates a new array of type E[]. This would normally be done with
     * {@link java.lang.reflect.Array#newInstance)))}, but we're avoiding use
     * of the libraries here, so we do it ourselves instead.
     */
    @SuppressWarnings("unchecked")
    private E[] newArray(int capacity) {
        return (E[]) new Object[capacity];
    }

    /**
     * Returns the first index of an element that matches the given element (ie
     * equals() returns true). This is implemented using a simple linear search,
     * since the array is not sorted.
     */
    private int getFirstIndexOfElement(E toFind) throws NoSuchElementException {
        for (int i = 0; i < this.size; i++) {
            if (this.array[i].equals(toFind)) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Private utility exception class to give descriptive feedback when
     * {@link ArrayList#getFirstIndexOfElement(Object)} does not find a matching
     * element. This exception is caught and handled within this class.
     */
    private static class NoSuchElementException extends Exception {
        public NoSuchElementException() {
            super();
        }
    }
}
