import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;

public class MyUnionFindTest {
    private MyUnionFind virginUF;
    private MyUnionFind uf257;
    private MyUnionFind smallAllConnected;
    private MyUnionFind tallTree;
    private static MyUnionFind ufTestSequence;

    @Before
    public void setUpBetweenEveryTest() {
        virginUF = new MyUnionFind(10);

        uf257 = new MyUnionFind(10);
        uf257.makeFriends(2,5);
        uf257.makeFriends(5,7);

        smallAllConnected = new MyUnionFind(3);
        smallAllConnected.makeFriends(1,0);
        smallAllConnected.makeFriends(0,2);

        tallTree = new MyUnionFind(5);
        tallTree.makeFriends(0,1);
        tallTree.makeFriends(3,2);
        tallTree.makeFriends(3,4);


    }

    @BeforeClass
    public static void setUpBeforeEveryClass() {
        ufTestSequence = new MyUnionFind(10);
    }

    @Test
    public void testTreeSize() {
        assertEquals("rootTreeSize intially 1", 1, virginUF.treeSize(5));

        assertEquals("2 root in 257 is 3", 3, uf257.treeSize(2));
        assertEquals("5 root in 257 is 0", 0, uf257.treeSize(5));
        assertEquals("7 root in 257 is 0", 0, uf257.treeSize(7));
    }

    @Test
    public void testConnected() {
        assertFalse("Virgin UF doesn't have connections", virginUF.connected(2,5));
        assertTrue("Even virginUF has self-connections though", virginUF.connected(2,2));

        assertFalse("2 and 8 aren't connected in 257", uf257.connected(2,8));
        assertTrue("2,5 are connected in 257", uf257.connected(2,5));
        assertTrue("Reflexive connection is recognized", uf257.connected(5,2));
        assertTrue("Connection passed through intermediary", uf257.connected(2, 7));
    }

    @Test
    public void testRootMethod() {
        assertEquals("Root off virgin UF is self", 5, virginUF.root(5));
        assertEquals("Root of 5 is 2 in 257", 2, uf257.root(5));
        assertEquals("Root of 7 is 2 in 257", 2, uf257.root(7));
    }

    @Test
    public void testAllConnected() {
        assertFalse("257 not all connected", uf257.allConnected());
        assertFalse("virginUF not all connected", virginUF.allConnected());
        assertTrue("Small all connected claims all connections made", smallAllConnected.allConnected());

        assertFalse("tallTree not connected yet", tallTree.allConnected());
        tallTree.makeFriends(1,3);
        assertTrue("tall tree now is all connected", tallTree.allConnected());
    }

    @Test
    @Ignore //No longer valid since weigghting has been added
    //to root rearranging algorithm
    public void testRootFindingWithNetworkInputSequence() {
        ufTestSequence.makeFriends(2, 5);
        assertEquals(2, ufTestSequence.root(5));
        ufTestSequence.makeFriends(3, 8);
        ufTestSequence.makeFriends(4, 2);
        assertEquals(4, ufTestSequence.root(5));
    }


}