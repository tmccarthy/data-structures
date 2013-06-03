package au.id.tmm.datastructures.list;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LinkedListTest {
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final int startIndex = 0;
    private static final String startLetter = String.valueOf(alphabet.charAt(startIndex));

    private static final int midIndex = 12;
    private static final String midLetter = String.valueOf(alphabet.charAt(midIndex));

    private static final int lastIndex = 25;
    private static final String lastLetter = String.valueOf(alphabet.charAt(lastIndex));

    @Test
    public void testAdd() throws Exception {
        LinkedList<String> alphabetList = new LinkedList<String>();

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

        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        alphabetList.add(testAddIndex, testAddString);

        assertEquals(alphabetList.get(testAddIndex), testAddString);

    }

    @Test
    public void testRemove() throws Exception {
        final int testRemoveIndex = 13;

        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        String oldAtIndexPlusOne = alphabetList.get(testRemoveIndex + 1);

        alphabetList.remove(testRemoveIndex);

        assertEquals(alphabetList.get(testRemoveIndex), oldAtIndexPlusOne);

    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testRemoveAtEnd() throws Exception {
        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        alphabetList.remove(alphabet.length() - 1);

        alphabetList.get(alphabet.length() - 1);
    }

    @Test
    public void testGet() throws Exception {
        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        assertEquals(alphabetList.get(startIndex), startLetter);
        assertEquals(alphabetList.get(midIndex), midLetter);
        assertEquals(alphabetList.get(lastIndex), lastLetter);
    }

    @Test
    public void testSet() throws Exception {
        final int testSetIndex = 13;
        final String testSetString = "TEST";

        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        alphabetList.set(testSetIndex, testSetString);

        assertEquals(alphabetList.get(testSetIndex), testSetString);
    }

    @Test
    public void testClear() throws Exception {
        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        alphabetList.clear();

        assertEquals(alphabetList.size(), 0);
    }

    @Test
    public void testSize() throws Exception {
        LinkedList<String> alphabetList = this.generateAlphabetLinkedList();

        assertEquals(alphabetList.size(), alphabet.length());
    }

    @Test
    public void testIterator() throws Exception {
        int i = 0;

        au.id.tmm.datastructures.Iterator<String> it = this.generateAlphabetLinkedList().iterator();

        while (it.hasNext()) {
            assertEquals(it.next(), String.valueOf(alphabet.charAt(i++)));
        }

    }

    private LinkedList<String> generateAlphabetLinkedList() {
        LinkedList<String> alphabetList = new LinkedList<String>();

        for (int i = 0; i < alphabet.length(); i++) {
            alphabetList.add(String.valueOf(alphabet.charAt(i)));
        }

        return alphabetList;
    }
}
