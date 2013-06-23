package au.id.tmm.datastructures.map;

public class HashMapTest extends AbstractMapTest {

    @Override
    public Map<Integer, String> constructNewConcreteMap(int initialCapacity) {
        return new HashMap<Integer, String>(initialCapacity);
    }
}
