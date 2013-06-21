package au.id.tmm.datastructures.set;

import au.id.tmm.datastructures.Collection;

/**
 * Interface defining methods available for Sets. Sets can be ordered
 * or unordered, and contain no duplicate elements.
 */
public interface Set<E> extends Collection<E> {

    /**
     * Adds an element to the set. Returns false a matching element
     * was already in the set.
     */
    @Override
    public boolean add(E e);

    /**
     * Remove an element from the Set.
     * @return false if an error occurred or if the given element
     *         was not in the Set, true otherwise
     */
    @Override
    public boolean remove(E e);

    /**
     * Empty the Set.
     */
    @Override
    public void clear();

    /**
     * Test if the Set contains the given element, that is, test if the
     * Set contains an element {@code o} such that {@code o.equals(e)}
     * returns {@code true}.
     */
    @Override
    public boolean contains(E e);

    /**
     * Test if the Set is empty.
     * @return true if the set has no elements, false otherwise
     */
    @Override
    public boolean isEmpty();

    /**
     * Return the number of elements in the Set.
     */
    @Override
    public int getSize();

}
