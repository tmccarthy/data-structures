package au.id.tmm.datastructures.list;

import au.id.tmm.datastructures.Collection;

/**
 * Interface defining the methods available for Lists within this data
 * structures project. Lists are ordered {@link Collection}s that allow
 * duplicates and are generally ordered in insertion order.
 */
public interface List <E> extends Collection<E> {

    /**
     * Add an element to the end of the List.
     */
    @Override
    public boolean add(E toAdd);

    /**
     * Insert an element into the given index in the List.
     */
    public void add(int index, E toAdd);

    /**
     * Remove the given element from the List.
     * @return true if the element was successfully removed, false otherwise
     *         (e.g. if the element was not in the List)
     */
    @Override
    public boolean remove(E toRemove);

    /**
     * Remove the element at the given index.
     */
    public void remove(int index);

    /**
     * Retrieve the element at the given index.
     */
    public E get(int index);

    /**
     * Set the element at the given index.
     */
    public void set(int index, E toSet);

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear();

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E e);

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty();

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize();
}
