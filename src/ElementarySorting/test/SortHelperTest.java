import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortHelperTest {
    private Integer[] intArray;
    private Integer[] sortedIntArray;

    @Before
    public void setUpInitialComparables() {
        intArray = new Integer[] {3, 1, 2, 6, 8, 5, 5, 9};
        sortedIntArray = new Integer[] {1, 3, 4, 5, 7};

    }

    @Test
    public void testCompareComparableItems() {
        assertTrue(SortHelper.less(1, 3));
        assertFalse(SortHelper.less(5, 5));
        assertFalse(SortHelper.less(6, 2));
        assertTrue(SortHelper.less('b','g'));
    }

    @Test
    public void testIsSortedMethodCorrectResults() {
        assertFalse(SortHelper.isSorted(intArray));
        assertTrue(SortHelper.isSorted(sortedIntArray));
    }


}