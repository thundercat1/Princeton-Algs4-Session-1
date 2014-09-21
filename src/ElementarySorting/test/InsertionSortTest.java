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
        assertEquals(1, InsertionSort.less(1, 3));
        assertEquals(0, InsertionSort.less(5, 5));
        assertEquals(-1, InsertionSort.less(6, 2));
    }


}