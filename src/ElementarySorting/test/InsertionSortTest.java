import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    private Integer[] intArray;
    int[] trialSize;

    @Before
    public void setUpBeforeTest() {
        intArray = new Integer[] {10, 15, 11, 3, 1, 2, 6, 8, 5, 25, 5, 9};
        trialSize = new int[] {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000};
    }

    @Test
    public void testBasicSelectionSort() {
        InsertionSort.selectionSort(intArray);
        assertTrue(SortHelper.isSorted(intArray));
        assertEquals((int) 1, (int) intArray[0]);
        assertEquals((int) 8, (int) intArray[6]);
    }

    @Test
    public void testAccuracyOfInsertionSort() {
        InsertionSort.insertionSort(intArray);
        assertTrue(SortHelper.isSorted(intArray));
        assertEquals((int) 1, (int) intArray[0]);
        assertEquals((int) 8, (int) intArray[6]);
    }

    @Test
    @Ignore
    public void performanceTestSelectSort() {
        for (int i = 0; i < trialSize.length; i++) {
            Double[] arr = new Double[trialSize[i]];

            for (int j = 0; j < trialSize[i]; j++) {
                arr[j] = StdRandom.uniform();
            }

            double start = System.currentTimeMillis();
            InsertionSort.selectionSort(arr);
            double end = System.currentTimeMillis();
            StdOut.println("Selection Sorted " + String.valueOf(trialSize[i]) + " values in " +
                String.valueOf(end - start) + " millis");
        }

        StdOut.println();
        StdOut.println();
    }


    @Test
    @Ignore
    public void performanceTestInsertionSort() {
        for (int i = 0; i < trialSize.length; i++) {
            Double[] arr = new Double[trialSize[i]];

            for (int j = 0; j < trialSize[i]; j++) {
                arr[j] = StdRandom.uniform();
            }

            double start = System.currentTimeMillis();
            InsertionSort.insertionSort(arr);
            double end = System.currentTimeMillis();
            StdOut.println("Insertion Sorted " + String.valueOf(trialSize[i]) + " values in " +
                    String.valueOf(end - start) + " millis");
            assertTrue(SortHelper.isSorted(arr));
        }

        StdOut.println();
        StdOut.println();

    }

    @Test
    @Ignore
    public void performanceTestInsertionSortWithForLoop() {
        for (int i = 0; i < trialSize.length; i++) {
            Double[] arr = new Double[trialSize[i]];

            for (int j = 0; j < trialSize[i]; j++) {
                arr[j] = StdRandom.uniform();
            }

            double start = System.currentTimeMillis();
            InsertionSort.insertionSortForLoop(arr);
            double end = System.currentTimeMillis();
            StdOut.println("Insertion Sorted with For Loops " + String.valueOf(trialSize[i]) + " values in " +
                    String.valueOf(end - start) + " millis");
            assertTrue(SortHelper.isSorted(arr));
        }

        StdOut.println();
        StdOut.println();

    }

    @Test
    public void testAccuracyOfShellSort() {
        InsertionSort.shellSort(intArray);
        assertTrue(SortHelper.isSorted(intArray));
        assertEquals((int) 1, (int) intArray[0]);
        assertEquals((int) 8, (int) intArray[6]);
    }

    @Test
    @Ignore
    public void performanceTestShellSortWithForLoop() {
        for (int i = 0; i < trialSize.length; i++) {
            Double[] arr = new Double[trialSize[i]];

            for (int j = 0; j < trialSize[i]; j++) {
                arr[j] = StdRandom.uniform();
            }

            double start = System.currentTimeMillis();
            InsertionSort.shellSort(arr);
            double end = System.currentTimeMillis();
            StdOut.println("ShellSorted with For Loops " + String.valueOf(trialSize[i]) + " values in " +
                    String.valueOf(end - start) + " millis");
            assertTrue(SortHelper.isSorted(arr));
        }

        StdOut.println();
        StdOut.println();
    }


}