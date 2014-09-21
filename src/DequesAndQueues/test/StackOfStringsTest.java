import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackOfStringsTest {
    private StackOfStrings sEmpty;
    private StackOfStrings sFilled;

    @Before
    public void setUp() throws Exception {
        sEmpty = new StackOfStrings();
        sFilled = new StackOfStrings();
        sFilled.push("Entry 1");
        sFilled.push("Entry 2");
        sFilled.push("Entry 3");

    }

    @Test
    public void testPushExists() {
        sEmpty.push("Hello");
    }

    @Test
    public void testPopExists() {
        sFilled.pop();
    }

    @Test
    public void testPopGivesCorrectValue() {
        assertEquals("First pop on sFilled is entry 3", "Entry 3", sFilled.pop());
        assertEquals("Second p op gives entry 2", "Entry 2", sFilled.pop());
        assertEquals("Third pop gives entry 1", "Entry 1", sFilled.pop());
    }

    @Test
    public void testIsEmptyReturnsCorrectly() {
        assertFalse(sFilled.isEmpty());
        sFilled.pop();
        sFilled.pop();
        sFilled.pop();
        assertTrue(sFilled.isEmpty());
    }
}