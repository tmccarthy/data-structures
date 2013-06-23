package au.id.tmm.datastructures.set;

import au.id.tmm.datastructures.Iterator;
import au.id.tmm.datastructures.list.List;

/**
 * Basic, abstract implementation of the {@link Set} interface backed
 * by a {@link List}. This abstract class simply prevents the addition
 * of an element if the {@link List#contains(Object)} method returns
 * true, and lets the List implementation handle all other operations.
 * @param <E>
 */
public abstract class ListSet<E> implements Set<E> {

    private List<E> list;

    /**
     * Constructor, allows subclasses to provide the concrete List
     * implementation.
     */
    public ListSet(List<E> list) {
        this.list = list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E e) {

        if (this.list.contains(e)) {
            return false;
        } else {
            this.list.add(e);
            return true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(E e) {
        return this.list.remove(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        this.list.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(E e) {
        return this.list.contains(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getSize() {
        return this.list.getSize();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Iterator<E> iterator() {
        return this.list.iterator();
    }
}
