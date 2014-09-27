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


        int N = fileIn.readInt();
        Point[] points = new Point[N];

        for (int i = 0; i < N; i++) {
            points[i] = new Point(fileIn.readInt(), fileIn.readInt());
            points[i].draw();
        }

        for (int i = 0; i < N; i++) {
            Point p = points[i];

            for (int j = i+1; j < N; j++) {
                ArrayList<Point> colinear= new ArrayList<Point>(2);
                Point q = points[j];
                colinear.add(p);
                colinear.add(q);
                double targetSlope = p.slopeTo(q);

                for (int k = j + 1; k < N; k++) {
                    Point r = points[k];
                    if (p.slopeTo(r) == targetSlope) colinear.add(r);
                }

                if (colinear.size() >= 4){
                    documentLine(colinear);
                    StdOut.println();
                }
            }
        }

        StdDraw.show(0);
    }

    private static void documentLine(ArrayList<Point> colinear) {

        Point[] pointArray = new Point[colinear.size()];
        pointArray = colinear.toArray(pointArray);
        Arrays.sort(pointArray);
        for (int i = 0; i < pointArray.length; i++) {
            StdOut.print(pointArray[i].toString());
            if (i < pointArray.length - 1) StdOut.print(" -> ");
        }
        StdDraw.setPenRadius(.001);
        pointArray[0].drawTo(pointArray[pointArray.length-1]);
    }


}
