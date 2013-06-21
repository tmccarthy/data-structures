package au.id.tmm.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractListTest {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int START_INDEX = 0;
    private static final String START_LETTER = String.valueOf(ALPHABET.charAt(START_INDEX));

    private static final int MID_INDEX = 12;
    private static final String MID_LETTER = String.valueOf(ALPHABET.charAt(MID_INDEX));

    private static final int LAST_INDEX = 25;
    private static final String LAST_LETTER = String.valueOf(ALPHABET.charAt(LAST_INDEX));

    public abstract List<String> constructNewConcreteList();

    @Test
    public void testAdd() throws Exception {
        List<String> alphabetList = this.constructNewConcreteList();

        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabetList.add(String.valueOf(ALPHABET.charAt(i)));
        }

        assertEquals(alphabetList.get(START_INDEX), START_LETTER);
        assertEquals(alphabetList.get(MID_INDEX), MID_LETTER);
        assertEquals(alphabetList.get(LAST_INDEX), LAST_LETTER);
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

        alphabetList.remove(ALPHABET.length() - 1);

        alphabetList.get(ALPHABET.length() - 1);
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

        assertEquals(alphabetList.get(START_INDEX), START_LETTER);
        assertEquals(alphabetList.get(MID_INDEX), MID_LETTER);
        assertEquals(alphabetList.get(LAST_INDEX), LAST_LETTER);
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
        assertFalse(ALPHABET.contains(testExpectNotContainsString));

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

        assertEquals(alphabetList.getSize(), ALPHABET.length());
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
            assertEquals(it.next(), String.valueOf(ALPHABET.charAt(i++)));
        }

    }

    private List<String> generateAlphabetList() throws Exception {
        List<String> alphabetList = this.constructNewConcreteList();

        for (int i = 0; i < ALPHABET.length(); i++) {
            alphabetList.add(String.valueOf(ALPHABET.charAt(i)));
        }

        return alphabetList;
    }
}
