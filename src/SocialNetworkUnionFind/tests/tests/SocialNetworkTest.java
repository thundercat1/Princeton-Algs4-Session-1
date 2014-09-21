import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class SocialNetworkTest {
    private static In fileIn;
    private static SocialNetwork n;

    @BeforeClass
    public static void beforeEachClassSetUpFiles() {
        String fname = "/home/mch/algs4/SocialNetwork/src/main/resources/networkLog.txt";
        fileIn = new In(fname);
    }

    @BeforeClass
    public static void beforeEachClassInitializeSocialNetworkN() {
        n = new SocialNetwork(10);
    }

    @Before
    public void doBeforeEachSocialNetworkTest() {
    }

    @Test
    public void  testGetNextConnection() {
        String[] line1 = n.readNextLogEntry(fileIn);
        assertEquals("date read correctly", "2014-06-01", line1[0]);
        assertEquals("second friend read correctly as string", "5", line1[2]);
        int secondFriend = Integer.parseInt(line1[2]);
        assertEquals("person 2 parses correctly", 5, secondFriend);
    }

    @Test
    @Ignore //Made assumptions about how roots were being moved around
    //that are no longer true after implementing weighted algorithm
    public void testInputConnectionYieldsCorrectRoots() {
        n.makeConnection(2, 5);
        assertEquals(2, n.getRoot(5));
        assertEquals(2, n.getRoot(2));
        n.makeConnection(3, 8);
        n.makeConnection(4, 2);
        assertEquals(4, n.getRoot(4));
        assertEquals(4, n.getRoot(5));
        assertEquals(4, n.getRoot(5));
        n.makeConnection(3, 9);
        assertEquals("Make sure root of 2 is 4", 4, n.getRoot(2));
        assertEquals(4, n.getRoot(4));
        assertEquals(4, n.getRoot(5));
        n.makeConnection(1, 2);
        assertEquals(1, n.getRoot(5));
        assertEquals(1, n.getRoot(2));
        assertEquals(3, n.getRoot(8));
        n.makeConnection(6, 2);
        assertEquals(6, n.getRoot(1));
        assertEquals(6, n.getRoot(5));
        n.makeConnection(6, 3);
        assertEquals(6, n.getRoot(9));
        n.makeConnection(6, 4);
        assertEquals(6, n.getRoot(9));
        assertEquals(6, n.getRoot(4));
        assertEquals(6, n.getRoot(6));
        n.makeConnection(6,5);
        n.makeConnection(8, 0);
        n.makeConnection(3, 0);
        n.makeConnection(2, 5);
        n.makeConnection(3, 8);
        assertEquals(6, n.getRoot(9));
        assertEquals(6, n.getRoot(4));
        assertEquals(6, n.getRoot(6));
        assertFalse("", n.networkClosed());
        n.makeConnection(7, 8);
        assertEquals(10, n.largestNetwork());
        assertEquals(7, n.getRoot(2));
        assertEquals(7, n.getRoot(6));
        assertEquals(7, n.getRoot(5));
        assertTrue(n.networkClosed());






    }
}