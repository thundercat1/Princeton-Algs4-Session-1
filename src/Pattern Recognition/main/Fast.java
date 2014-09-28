import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mch on 9/21/14.
 */
public class Fast {
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

        //points is sorted by y- position
        Arrays.sort(points);

        for (int i = 0; i < N - 3; i++) {
            Point p = points[i];

            Point[] sortedPoints = new Point[N-1];

            //Copy the points array into sortedPoints, which we'll sort by slope from p
            int z = 0;
            while (z < sortedPoints.length) {
                if (z < i) {
                    sortedPoints[z] = points[z];
                } else {
                    sortedPoints[z] = points[z + 1];
                }
                z++;
            }

            //sort by slope from p
            Arrays.sort(sortedPoints, p.SLOPE_ORDER);

            //Construct an array of the slope to every point compared to p
            double[] slope = new double[sortedPoints.length];
            for (int j = 0; j < slope.length; j++) {
                slope[j] = p.slopeTo(sortedPoints[j]);
            }


            double slopeMatchValue = slope[0];
            int idx = 0;
            int run;

            while (idx < slope.length) {
                run = 1;
                while (idx < slope.length && slope[idx] == slopeMatchValue) {
                    run++;
                    idx++;
                }

                if (run >= 4) {
                    Point[] segmentPoints = new Point[run];
                    segmentPoints[0] = p;

                    for(int q = 1; q < segmentPoints.length; q++) {
                        segmentPoints[q] = sortedPoints[idx - run + q];
                    }
                    Arrays.sort(segmentPoints);
                    if (newSegment(segmentPoints, Ms, finalPoints)) documentLine(segmentPoints, Ms, finalPoints);

                }

                if (idx < slope.length) slopeMatchValue = slope[idx];

            }
        }


        StdDraw.show(0);
    }

    private static boolean newSegment(Point[] pointArray, ArrayList<Double> Ms, ArrayList<Point> finalPoints) {
        //If the slope and final point are the same, then it's a duplicate.
        double m = pointArray[0].slopeTo(pointArray[1]);

        for (int i = 0; i < Ms.size(); i++) {
            if (Ms.get(i) == m) {
                //if the slope is the same
                if (finalPoints.get(i) == pointArray[pointArray.length - 1]) return false;
            }
        }
        return true;
    }

    private static void documentLine(Point[] pointArray, ArrayList<Double> Ms, ArrayList<Point> finalPoints) {

        for (int i = 0; i < pointArray.length; i++) {
            StdOut.print(pointArray[i].toString());
            if (i < pointArray.length - 1) StdOut.print(" -> ");
        }
        StdOut.println();
        StdDraw.setPenRadius(.001);
        pointArray[0].drawTo(pointArray[pointArray.length-1]);

        Ms.add(pointArray[0].slopeTo(pointArray[1]));
        finalPoints.add(pointArray[pointArray.length - 1]);
    }


}
