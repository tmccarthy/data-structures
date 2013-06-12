package au.id.tmm.datastructures;

/**
 * Interface defining a simple Iterator.
 */
public interface Iterator <E> {

    /**
     * Test if the Iterator has another element.
     */
    public boolean hasNext();

    /**
     * Return the next element in the sequence.
     */
    public E next();
}
