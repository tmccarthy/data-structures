package au.id.tmm.datastructures.set;

import au.id.tmm.datastructures.list.LinkedList;

/**
 * Concrete implementation of {@link ListSet} backed by a {@link LinkedList}.
 */
public class LinkedListSet<E> extends ListSet<E> {

    public LinkedListSet() {
        super(new LinkedList<E>());
    }

}
