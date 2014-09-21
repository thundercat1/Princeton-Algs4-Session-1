import junit.framework.TestCase;

public class PercolationTest extends TestCase {


    public void testOpen() throws Exception {
        Percolation p = new Percolation(10);
        p.open(1,1);
    }

    public void testIsOpen() throws Exception {
        Percolation p = new Percolation(10);
        p.open(1,1);
        assertTrue("p(1,1) is open", p.isOpen(1,1));
        assertFalse("p(2,1) is not open yet", p.isOpen(2,1));
        p.open(2,1);
        assertTrue("p(2,1) is open now", p.isOpen(2,1));
    }

    public void testIsFull() throws Exception {
        Percolation p = new Percolation(10);
        assertFalse("top left not full yet", p.isFull(1,1));
        assertFalse("bottom right not full yet", p.isFull(10,10));
        p.open(1,1);
        assertTrue("Top left is full", p.isFull(1,1));
        p.open(10,10);
        assertFalse("Bottom right is still not full", p.isFull(10,10));
        assertFalse("2,1 is not full yet", p.isFull(2,1));
        p.open(2,1);
        assertTrue("(2,1) gets full from (1,1)", p.isFull(2,1));
    }

    public void testPercolates() throws Exception {

        Percolation p = new Percolation(2);

        assertFalse(p.percolates());
        p.open(1,1);
        p.open(2,2);
        assertFalse("Does't percolate with diagonal", p.percolates());
        p.open(2,1);
        assertTrue("(2,1) is filled up by (1,1)", p.isFull(2,1));
        assertTrue("percolates now", p.percolates());

        p = new Percolation(3);
        assertFalse(p.percolates());
        p.open(1,1);
        p.open(2,1);
        p.open(2,2);
        assertFalse(p.percolates());
        p.open(3,1);
        p.open(3,3);
        assertTrue(p.percolates());
        assertFalse("No backwash", p.isFull(3,3));
        assertTrue(p.isFull(2,2));
    }
}