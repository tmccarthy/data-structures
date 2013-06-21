package au.id.tmm.datastructures;

/**
 * Simple wrapper around raw arrays.
 */
public class Array<E> implements Iterable<E> {

    E[] rawArray;

    /**
     * Create new Array of the given (fixed) size.
     */
    @SuppressWarnings("unchecked")
    public Array(int index) {
        this.rawArray = (E[]) new Object[index];
    }

    /**
     * Retrieve the element at the given index.
     */
    public E get(int index) {
        return rawArray[index];
    }

    /**
     * Set the element at the given index;
     */
    public void set(int index, E newValue) {
        this.rawArray[index] = newValue;
    }

    /**
     * Compute the length of the Array.
     */
    public int length() {
        return rawArray.length;
    }

    /**
     * Return an iterator over this Array.
     */
    @Override
    public Iterator<E> iterator() {
        return new ConcreteArrayIterator();
    }

    /**
     * A concrete iterator for the raw Array.
     */
    private class ConcreteArrayIterator implements Iterator<E> {

        private int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return (currentIndex + 1 < rawArray.length);
        }

        @Override
        public E next() {
            return rawArray[++currentIndex];
        }
    }

}
