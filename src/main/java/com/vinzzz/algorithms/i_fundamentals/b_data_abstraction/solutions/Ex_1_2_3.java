package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Interval1D;
import com.vinzzz.libs.stdlib.Interval2D;
import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Source : https://github.com/morrxy/algs4/blob/master/exercise/1.2.03/Interval2D_client.java
 */

public class Ex_1_2_3 {

    public static void main(String[] args) {
        int N = 10;
        double min = 0.1;
        double max = 0.9;

        Interval2D[] inters = new Interval2D[N];
        Interval1D[][] inters_1d = new Interval1D[N][2];

        for (int i = 0; i < N; i++) {
            double[] d1 = make_doubles(min, max);
            Interval1D x = new Interval1D(d1[0], d1[1]);
            d1 = make_doubles(min, max);
            Interval1D y = new Interval1D(d1[0], d1[1]);

            inters_1d[i][0] = x;
            inters_1d[i][1] = y;

            inters[i] = new Interval2D(x, y);
            inters[i].draw();
        }

        int n = calculate_intersect_pairs(inters);
        StdOut.println("the number of pairs of intervals that intersects: " + n);

        int n1 = contained_each_other(inters_1d);
        StdOut.println("the number of intervals that are contained in one another: " + n1);
    }

    public static double[] make_doubles(double min, double max) {
        double[] a = new double[2];
        a[0] = StdRandom.uniform(min, max);
        a[1] = StdRandom.uniform(min, max);
        Arrays.sort(a);
        return a;
    }

    public static int calculate_intersect_pairs(Interval2D[] inters) {
        int count = 0;
        int len = inters.length;

        for (int i = 0; i <= len - 2; i++) {
            for (int j = i + 1; j <= len -1; j++) {
                if (inters[i].intersects(inters[j])) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static int contained_each_other(Interval1D[][] inters) {
        int count = 0;
        int len = inters.length;

        for (int i = 0; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
                if (all_overlap(inters[i], inters[j])) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static boolean all_overlap(Interval1D[] int1, Interval1D[] int2) {
        // boolean result = false;

        Interval1D x1 = int1[0];
        Interval1D y1 = int1[1];
        Interval1D x2 = int2[0];
        Interval1D y2 = int2[1];

        if (x1.left() != x2.left()) return false;
        if (x1.right() != x2.right()) return false;
        if (y1.left() != y2.left()) return false;
        if (y1.right() != y2.right()) return false;

        return true;
    }

}
