package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Point2D;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

import java.util.ArrayList;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_1 {

    public static void main(String[] args) {
        int N = StdIn.readInt();
        StdOut.println(distanceBetweenClosestPairOfPoints(N));
    }

    private static double distanceBetweenClosestPairOfPoints(int n) {

        ArrayList<Point2D> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Point2D point2D = new Point2D(StdRandom.uniform(0.0, 1.0), StdRandom.uniform(0.0, 1.0));
            point2D.draw();
            points.add(point2D);
        }

        //set it to max dist at first
        double minDist = 1.0;
        Point2D from = null;
        Point2D to = null;
        for (int i = 0; i < points.size() - 1; i++) {
            for (int j = i+1; j < points.size(); j++) {
                double dist = points.get(i).distanceSquaredTo(points.get(j));
                if(minDist > dist) {
                    minDist = dist;
                    from = points.get(i);
                    to = points.get(j);
                }
            }
        }

        if(from!= null && to != null) from.drawTo(to);
        return minDist;
    }


}
