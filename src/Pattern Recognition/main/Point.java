import java.util.Comparator;


public class Point implements Comparable<Point> {

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        double rise = that.y - this.y;
        double run = that.x - this.x;

        if (run == 0) return Double.POSITIVE_INFINITY;

        return rise / run;
    }


    public int compareTo(Point that) {
        //is this smaller than that?
        if (this.y < that.y) return -1;
        if (this.y == that.y && this.x < that.x) return -1;
        return 1;

    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {

    }
}
