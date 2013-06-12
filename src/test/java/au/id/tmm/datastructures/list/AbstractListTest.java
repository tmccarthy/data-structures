package au.id.tmm.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractListTest {

    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int startIndex = 0;
    private static final String startLetter = String.valueOf(alphabet.charAt(startIndex));

    private static final int midIndex = 12;
    private static final String midLetter = String.valueOf(alphabet.charAt(midIndex));

    private static final int lastIndex = 25;
    private static final String lastLetter = String.valueOf(alphabet.charAt(lastIndex));

    public abstract List<String> constructNewConcreteList();

    @Test
    public void testAdd() throws Exception {
        List<String> alphabetList = this.constructNewConcreteList();

        for (int i = 0; i < alphabet.length(); i++) {
            alphabetList.add(String.valueOf(alphabet.charAt(i)));
        }

        assertEquals(alphabetList.get(startIndex), startLetter);
        assertEquals(alphabetList.get(midIndex), midLetter);
        assertEquals(alphabetList.get(lastIndex), lastLetter);
    }

    @Test
    public void testAddByIndex() throws Exception {
        final int testAddIndex = 13;
        final String testAddString = "TEST";

        List<String> alphabetList = this.generateAlphabetList();

        alphabetList.add(testAddIndex, testAddString);

        assertEquals(alphabetList.get(testAddIndex), testAddString);

    }

    @Test
    public void testRemove() throws Exception {
        final int testRemoveIndex = 13;

        List<String> alphabetList = this.generateAlphabetList();

        String oldAtIndexPlusOne = alphabetList.get(testRemoveIndex + 1);

        alphabetList.remove(testRemoveIndex);

        assertEquals(alphabetList.get(testRemoveIndex), oldAtIndexPlusOne);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveAtEnd() throws Exception {
        List<String> alphabetList = this.generateAlphabetList();

        alphabetList.remove(alphabet.length() - 1);

        alphabetList.get(alphabet.length() - 1);
    }

    @Test
    public void testRemoveByObject() throws Exception {

        final String testRemoveString = "C";

        List<String> alphabetList = this.generateAlphabetList();

        assertTrue(alphabetList.contains(testRemoveString));

        alphabetList.remove(testRemoveString);

        assertFalse(alphabetList.contains(testRemoveString));
    }

    @Test
    public void testGet() throws Exception {
        List<String> alphabetList = this.generateAlphabetList();

        assertEquals(alphabetList.get(startIndex), startLetter);
        assertEquals(alphabetList.get(midIndex), midLetter);
        assertEquals(alphabetList.get(lastIndex), lastLetter);
    }

    @Test
    public void testSet() throws Exception {
        final int testSetIndex = 13;
        final String testSetString = "TEST";

        List<String> alphabetList = this.generateAlphabetList();

        alphabetList.set(testSetIndex, testSetString);

        assertEquals(alphabetList.get(testSetIndex), testSetString);
    }

    @Test
    public void testContains() throws Exception {
        final String testExpectContainsString = "C";
        final String testExpectNotContainsString = "*";

        List<String> alphabetList = this.generateAlphabetList();

        assertTrue(alphabetList.contains(testExpectContainsString));
        assertFalse(alphabet.contains(testExpectNotContainsString));

    }

    @Test
    public void testClear() throws Exception {
        List<String> alphabetList = this.generateAlphabetList();

        alphabetList.clear();

        assertEquals(alphabetList.getSize(), 0);
    }

    @Test
    public void testSize() throws Exception {
        List<String> alphabetList = this.generateAlphabetList();

        assertEquals(alphabetList.getSize(), alphabet.length());
    }

    @Test
    public void testIsEmpty() throws Exception {
        List<String> alphabetList = this.generateAlphabetList();
        List<String> emptyList = this.constructNewConcreteList();

        assertFalse(alphabetList.isEmpty());
        assertTrue(emptyList.isEmpty());
    }

    @Test
    public void testIterator() throws Exception {
        int i = 0;

        au.id.tmm.datastructures.Iterator<String> it = this.generateAlphabetList().iterator();

        while (it.hasNext()) {
            assertEquals(it.next(), String.valueOf(alphabet.charAt(i++)));
        }

    }

    private List<String> generateAlphabetList() throws Exception {
        List<String> alphabetList = this.constructNewConcreteList();

        for (int i = 0; i < alphabet.length(); i++) {
            alphabetList.add(String.valueOf(alphabet.charAt(i)));
        }

        return alphabetList;
    }
}
