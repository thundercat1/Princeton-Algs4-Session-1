import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {
    private Queue<String> qString;
    private Queue<Integer> qInt;

    @Before
    public void setUp() throws Exception {
        qString = new Queue<String>();
        qInt = new Queue<Integer>();
    }

    @Test
    public void testEnqueueNewItem() {
        qString.enqueue("Hello");
        qInt.enqueue(3);
    }

    @Test
    public void testEnqueueThenDequeueOneItem() {
        qString.enqueue("Hello");
        assertEquals("Hello", qString.dequeue());
        qInt.enqueue(3);
        assertEquals("3 is properly dequeued", (double) 3, (double) qInt.dequeue(), .01);
    }

    @Test
    public void testIsEmpty() {
        qString.enqueue("Hello");
        assertFalse(qString.isEmpty());
        qString.dequeue();
        assertTrue(qString.isEmpty());
    }

    @Test
    public void testMultipleEnqueuesAndDequeues() {
        qString.enqueue("Hello");
        qString.enqueue("my");
        qString.enqueue("name");
        assertEquals("Hello", qString.dequeue());
        assertEquals("my", qString.dequeue());
        qString.enqueue("is");
        qString.enqueue("Jerry");
        assertEquals("name", qString.dequeue());
        assertEquals("is", qString.dequeue());
    }
}