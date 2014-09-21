import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class RandomizedQueueTest {
    private RandomizedQueue<String> rq;
    private RandomizedQueue<Integer> ri;

    @Before
    public void setUp() throws Exception {
        rq = new RandomizedQueue<String>();
        ri = new RandomizedQueue<Integer>();
    }

    @Test
    public void testAddingAndRemovingOneItem() {
        rq.enqueue("Hello");
        assertEquals("Hello", rq.dequeue());
    }

    public void testAddingAndSampingOneItem() {
        rq.enqueue("you");
        assertEquals("You", rq.sample());
        assertEquals(1, rq.size());
    }

    @Test
    public void testEmptyingQueue() {
        rq.enqueue("something");
        rq.enqueue("else");
        assertFalse(rq.isEmpty());
        rq.dequeue();
        rq.dequeue();
        assertTrue(rq.isEmpty());
    }

    @Test
    public void testAddMoreThanInitialArraySize() {
        rq.enqueue("something");
        rq.enqueue("something else");
        rq.enqueue("and again");
        rq.enqueue("no way this works");
        rq.enqueue("but this does?");

        /*
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        StdOut.println(rq.dequeue());
        */

    }

    @Test
    public void testIterator() throws Exception {
        rq.enqueue("Hello");
        rq.enqueue("you");
        rq.enqueue("are");
        rq.enqueue("almost");
        rq.enqueue("done");
        Iterator itr = rq.iterator();
        while (itr.hasNext()) {
            //StdOut.println(itr.next());
            itr.next();
        }
    }

    @Test
    public void testGrowAndShrinkArray() {
        for (int i = 0; i < 32; i++) {
            rq.enqueue(String.valueOf(i));
        }

        for (int i = 32; i > 0; i--) {
            rq.dequeue();
            //StdOut.println(rq.dequeue());
        }
        int a = 0;
        rq.isEmpty();
        for (int i = 0; i < 32; i++) {
            rq.enqueue(String.valueOf(i));
        }

        for (int i = 32; i > 0; i--) {
            rq.dequeue();
            //StdOut.println(rq.dequeue());
        }
    }

    @Test
    public void testAddingAroundResizePoint() {
        rq.enqueue("a");
        rq.enqueue("b");
        rq.enqueue("c");
        rq.enqueue("d");

        rq.dequeue();
        rq.dequeue();
        rq.dequeue();

        rq.enqueue("e");
        rq.enqueue("f");
    }

    @Test
    public void testTryingToRecreateFailingRandomTest() {
        double[] p = {10, 90};
        for (int i = 0; i < 50; i++) {
            int draw = StdRandom.uniform(0,100);
            if (draw <= p[0]) {
                    ri.enqueue(StdRandom.uniform(0, 1000));
                    //StdOut.println("Added an item");
                }
            else {
                try {
                    ri.dequeue();
                } catch (NoSuchElementException e) {
                    //StdOut.println("Caught expected exception");
                }

            }
        }

    }

    @Test
    public void performanceTest() {
        int[] testSizes = {5000, 10000, 20000, 40000, 80000, 160000, 320000};

        for (int i = 0; i < testSizes.length; i++) {
            double startTime = System.currentTimeMillis();
            for (int j = 0; j < testSizes[i]; j++) {
                ri.enqueue(j);
            }
            for (int j = 0; j < testSizes[i]/2; j++) {
                ri.dequeue();
                ri.sample();
            }
            double time = System.currentTimeMillis() - startTime;
            StdOut.println(String.valueOf(testSizes[i]) + " trials in " + String.valueOf(time/1000) + " Seconds");
        }

    }



}