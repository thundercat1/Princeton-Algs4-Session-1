import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mch on 9/21/14.
 */
public class Brute {

    public static void main(String[] args) {
        //Command line argument for input filename should be provided

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        StdDraw.show(0);
        StdDraw.setPenRadius(0.01);  // make the points a bit larger

        In fileIn = new In(args[0]);


        //Ms and finalPoints are arrayLists tracking the slope and last point in
        //all colinear line segments found so far. They will be used to help check for
        //duplicate or overlapping line segments
        ArrayList<Double> Ms = new ArrayList<Double>(1);
        ArrayList<Point> finalPoints = new ArrayList<Point>(1);


        int N = fileIn.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(fileIn.readInt(), fileIn.readInt());
            points[i].draw();
        }

        for (int i = 0; i < N; i++) {
            Point p = points[i];

            for (int j = i+1; j < N; j++) {
                //Create ArrayList to track points found to be colinear with p & q
                ArrayList<Point> colinear= new ArrayList<Point>(2);
                Point q = points[j];
                colinear.add(p);
                colinear.add(q);

                //targetSlope is the slope between p & q -- any other points with the same slope from p
                //are colinear!
                double targetSlope = p.slopeTo(q);


                //Check all points right of q to see if they're colinear
                for (int k = j + 1; k < N; k++) {
                    Point r = points[k];
                    if (p.slopeTo(r) == targetSlope) colinear.add(r);
                }

                //If we've found at least four colinear points, and the set is a new segment, document it.
                if (colinear.size() >= 4) {
                    Point[] pointArray = new Point[colinear.size()];
                    pointArray = colinear.toArray(pointArray);
                    Arrays.sort(pointArray);

                    if (newSegment(pointArray, Ms, finalPoints)) {
                        documentLine(pointArray, Ms, finalPoints);
                        StdOut.println();
                    }

                }
            }
        }

        StdDraw.show(0);
    }

    private static boolean newSegment(Point[] pointArray, ArrayList<Double> Ms, ArrayList<Point> finalPoints) {
        //If the slope and final point are the same, then it's a duplicate.
        return true;
        /* Brute.java is supposed to return subsegments, not weed them out.
        double m = pointArray[0].slopeTo(pointArray[1]);

        for (int i = 0; i < Ms.size(); i++) {
            if (Ms.get(i) == m) {
                //if the slope is the same
                if (finalPoints.get(i) == pointArray[pointArray.length - 1]) return false;
            }
        }
        return true;
        */
    }

    private static void documentLine(Point[] pointArray, ArrayList<Double> Ms, ArrayList<Point> finalPoints) {

        for (int i = 0; i < pointArray.length; i++) {
            StdOut.print(pointArray[i].toString());
            if (i < pointArray.length - 1) StdOut.print(" -> ");
        }
        StdDraw.setPenRadius(.001);
        pointArray[0].drawTo(pointArray[pointArray.length-1]);

        Ms.add(pointArray[0].slopeTo(pointArray[1]));
        finalPoints.add(pointArray[pointArray.length - 1]);
    }


}
