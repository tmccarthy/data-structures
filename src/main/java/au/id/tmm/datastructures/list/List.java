package au.id.tmm.datastructures.list;

public interface List <E> extends au.id.tmm.datastructures.Iterable {

    public void add(E toAdd);
    public void add(int index, E toAdd);

    public void remove(int index);

    public E get(int index);

    public void set(int index, E toSet);

    public void clear();

    public int size();

    @Override
    public boolean equals(Object other);
}
