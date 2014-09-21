import junit.framework.TestCase;

public class PercolationStatsTest extends TestCase {

    public void testMean() throws Exception {
        PercolationStats t = new PercolationStats(100, 100);
        assertNotNull("mean exists", t.mean());
        assertEquals("Mean is close to actual value", .593, t.mean(), 0.01);
    }

    public void testStdDev() throws Exception {
        PercolationStats t = new PercolationStats(200, 200);
        assertNotNull("stdDev exists", t.stddev());
        assertEquals("StdDev is close to the right value", .008, t.stddev(), .007);
        assertEquals("95% high is about right", .60, t.confidenceHi(), .1);
        assertEquals("95% low is about right", .58, t.confidenceLo(), .1);
    }

    public void testPercolationStatsFunkyCases() {
        PercolationStats t = new PercolationStats(1,10);
        assertEquals("one cell will percolate when 100% are opened", 1, t.mean(), .01);
        assertEquals("one cell never deviates", 0, t.stddev(), .01);
        assertEquals("One cell's confidenceHi is 1", 1, t.confidenceHi(), .01);

        t = new PercolationStats(500, 1);
        assertEquals("one trial with 500 cells gets pretty close to the mean", .59, t.mean(), .02);
        assertEquals("One trial's confidence interval is undefined", Double.NaN, t.confidenceHi());

    }

}