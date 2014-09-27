import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    private Point p00;
    private Point p10;
    private Point p01;
    private Point p11;
    private Point p31;

    @Before
    public void setUpPointsBeforeTest() {

        p00 = new Point(0, 0);
        p10 = new Point(1, 0);
        p01 = new Point(0, 1);
        p11 = new Point(1, 1);
        p31 = new Point(3, 1);
    }

    @Test
    public void testCompareTo() {
        assertEquals("p00 should be smaller than p11", -1, p00.compareTo(p11));
        assertEquals("p11 should be bigger than p00", 1, p11.compareTo(p00));
        assertEquals("x axis is used to break ties", -1, p00.compareTo(p10));
    }

    @Test
    public void testSlopeTo() {
        assertEquals("slope p00 to p11 is 1", 1, p00.slopeTo(p11), .001);
        assertEquals("slope p11 to p00 is 1", 1, p11.slopeTo(p00), .001);
        assertEquals("positive zero slope on x axis", 0, p00.slopeTo(p10), .001);
        assertEquals("negative slope", -1, p01.slopeTo(p10), .001);
        assertEquals("fractional slope", .33333, p00.slopeTo(p31), .001);
        assertEquals("vertical line is positive infinity", Double.POSITIVE_INFINITY, p00.slopeTo(p01), .001);
    }

}