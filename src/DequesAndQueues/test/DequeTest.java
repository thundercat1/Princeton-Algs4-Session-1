import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class DequeTest {
    private Deque<String> d;
    private Deque<String> d2;

    @Before
    public void setUp() throws Exception {
        d = new Deque<String>();
        d2 = new Deque<String>();
    }

    @Test
    public void testInitialSetupParameters() {
        assertTrue(d.isEmpty());
        assertEquals(0, d.size());
    }

    @Test
    public void testAddingAndRemovingOneTopItem() {
        d2.addFirst("hi");
        assertEquals("d2 should return the same first item that was just added", "hi", d2.removeFirst());
    }

    @Test
    public void testAddingOneToTopThenRemovingItFromBottom() {
        d2.addFirst("hi");
        assertEquals("Item added on top can be pulled from bottom", "hi", d2.removeLast());
    }

    @Test
    public void testAddingOneToBottomAndRemovingItFromBottom() {
        d2.addLast("hi");
        assertEquals("hi", d2.removeLast());
    }

    @Test
    public void testAddingOneToBottomThenRemovingItFromTop() {
        d2.addLast("hi");
        assertEquals("hi", d2.removeFirst());
    }

    @Test
    public void testAddingSeveralToTopThenRemoving() {
        d2.addFirst("Hello");
        d2.addFirst("my");
        d2.addFirst("name");
        assertEquals("name", d2.removeFirst());
        assertEquals("my", d2.removeFirst());
    }

    @Test
    public void testAddingSeveralToTopThenRemovingFromBottom() {
        d2.addFirst("is");
        d2.addFirst("Jerry");
        assertEquals("is", d2.removeLast());
        assertEquals("Jerry", d2.removeLast());
        assertTrue("Empty after removing everything from bottom", d2.isEmpty());
    }

    @Test
    public void addSeveralToBottomThemRemoveFromTop() {
        d2.addLast("Would");
        d2.addLast("you");
        d2.addLast("like");
        assertEquals("Would", d2.removeFirst());
        assertEquals("you", d2.removeFirst());
        assertEquals("like", d2.removeFirst());
        assertTrue("Empty after removing everything from top", d2.isEmpty());
    }

    @Test
    public void testIterator() {
        d2.addFirst("I");
        d2.addLast("want");
        d2.addLast("to");
        d2.addLast("ride");

        Iterator itr = d2.iterator();
        assertTrue("has next element to start", itr.hasNext());
        assertEquals("First item from iterator is I", "I", itr.next());
        assertEquals("Next item is 'want'", "want", itr.next());
        assertEquals("to", itr.next());
        assertEquals("ride", itr.next());
        assertFalse("no next element when it's empty!", itr.hasNext());
    }

    @Test
    public void testRepeatedEmptying() {
        d2.addFirst("Hello");
        d2.addLast("you");
        assertEquals("you", d2.removeLast());
        assertEquals("Hello", d2.removeLast());
        d2.addFirst("blue");
        d2.addFirst("sky");
        assertEquals("blue", d2.removeLast());
        assertEquals("sky", d2.removeFirst());
        d2.addLast("purple");
        assertEquals("purple", d2.removeLast());

    }

    @Test
    public void testSizeDuringRepeatedEmptying() {
        assertEquals(0, d2.size());
        d2.addFirst("Hello");
        d2.addLast("you");
        assertEquals(2, d2.size());
        assertEquals("you", d2.removeLast());
        assertEquals(1, d2.size());
        assertEquals("Hello", d2.removeLast());
        assertEquals(0, d2.size());
        d2.addFirst("blue");
        assertEquals(1, d2.size());
        d2.addFirst("sky");
        assertEquals(2, d2.size());
        assertEquals("blue", d2.removeLast());
        assertEquals("sky", d2.removeFirst());
        assertEquals(0, d2.size());
        d2.addLast("purple");
        assertEquals("purple", d2.removeLast());
    }




}