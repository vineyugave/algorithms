package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.In;
import com.vinzzz.libs.stdlib.StdDraw;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdStats;

/**
 * Histogram Drawing
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 *          <p>
 *          Reference : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_32.java
 */

public class Ex_1_1_32 {

    public static void main(String[] args) {
        int n = StdIn.readInt();
        double l = StdIn.readDouble();
        double r = StdIn.readDouble();

        //enter absolute file path
        double[] values = In.readDoubles("/Users/vugave/Projects/algorithms/src/main/java/com/vinzzz/algorithms/i_fundamentals/a_basic_programming_model/data/largeT.txt");

        histogram(values, n, l, r);
    }

    public static void histogram(double[] values, int n, double l, double r) {
        int[] counts = new int[n];

        for (int i = 0; i < values.length; i++) {
            int k = getInterval(values[i], n, l, r);
            if (k >= 0)
                counts[k]++;
        }

        int maxCount = StdStats.max(counts);

        StdDraw.setCanvasSize(1024, 512);
        StdDraw.setXscale(l, r);
        StdDraw.setYscale(0, maxCount);

        double w = (r - l) / n;

        for (int i = 0; i < n; i++) {
            double x = l + (i + 0.5) * w,
                    y = counts[i] / 2.0,
                    rw = 0.5 * w,
                    rh = counts[i] / 2.0;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

    private static int getInterval(double v, int n, double l, double r) {
        if (v < l || v >= r)
            return -1;
        else
            return (int) (n * (v - l) / (r - l));
    }
}
