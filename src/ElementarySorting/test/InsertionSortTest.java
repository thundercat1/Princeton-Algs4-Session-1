import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    private int[] intArray;

    @Before
    public void setUpInitialComparables() {
        //intArray = {3, 1, 2, 6, 8, 5, 5, 9};
    }

    @Test
    public void testCompareComparableItems() {
        assertTrue(InsertionSort.less(1, 3));
        assertFalse(InsertionSort.less(5, 5));
        assertFalse(InsertionSort.less(6, 2));
        assertTrue(InsertionSort.less('b','g'));
    }


}