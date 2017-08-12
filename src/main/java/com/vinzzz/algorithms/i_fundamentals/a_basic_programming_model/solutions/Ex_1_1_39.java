package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_39 {

    public static int experiment(int n) {
        int[] a = new int[n],
                b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform(100000, 1000000);
            b[i] = StdRandom.uniform(100000, 1000000);
        }

        Arrays.sort(b);

        int count = 0;
        for (int i = 0; i < n; i++)
            if (BinarySearch.rank(a[i], b) >= 0)
                count++;

        return count;
    }

    public static void batch(int t, int n) {
        long count = 0;
        for (int i = 0; i < t; i++)
            count += experiment(n);

        double avg = 1.0 * count / t;

        StdOut.printf("%8d: %9.2f\n", n, avg);
    }

    public static void main(String[] args) {
        int t = StdIn.readInt();

        int[] ns = {1000, 10000, 100000, 1000000};

        for (int i = 0; i < ns.length; i++)
            batch(t, ns[i]);

        /*
                 1000:      0.96
                10000:    110.68
               100000:  10527.36
              1000000: 670822.20
         */
    }
}
