package au.id.tmm.datastructures;

/**
 * Interface defining the mechanism for retrieving an {@link Iterator} from an
 * {@link Iterable} class.
 */
public interface Iterable<E> {
    public Iterator<E> iterator();
}
