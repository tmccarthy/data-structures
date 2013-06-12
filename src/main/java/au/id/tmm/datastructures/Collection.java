package au.id.tmm.datastructures;

/**
 * Interface defining the methods available for collections within the data
 * structures project.
 */
public interface Collection<E> extends Iterable<E> {

    /**
     * Adds an element to the Collection.
     * @return false if an error occurred, true otherwise.
     */
    public boolean add(E e);

    /**
     * Remove an element from the Collection.
     * @return false if an error occurred or if the given element was not in the
     * Collection, true otherwise
     */
    public boolean remove(E e);

    /**
     * Empty the Collection.
     */
    public void clear();

    /**
     * Test if the Collection contains the given element, that is, test if the
     * Collection contains an element {@code o} such that {@code o.equals(e)}
     * returns {@code true}.
     */
    public boolean contains(E e);

    /**
     * Test if the Collection is empty.
     * @return true if the collection has no elements, false otherwise
     */
    public boolean isEmpty();

    /**
     * Return the number of elements in the Collection.
     */
    public int getSize();

}
