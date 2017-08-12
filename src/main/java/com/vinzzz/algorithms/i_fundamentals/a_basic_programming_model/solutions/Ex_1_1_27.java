package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * @see <a href="http://algs4.cs.princeton.edu/11model/Binomial.java.html">Binomial Theorem Java Soln</a>
 */

public class Ex_1_1_27 {

    public static void main(String[] args) {
        Counter c = new Counter();
        StdOut.println(binomial(30, 15, 0.5, c));
        StdOut.println(c.count);
    }

    public static double binomial(int N, int k, double p, Counter c) {
        if (N == 0 && k == 0) return 1.0;
        if (N < 0 || k < 0) return 0.0;
        c.increment();

        return (1.0 - p) * binomial(N - 1, k, p, c) + p * binomial(N - 1, k - 1, p, c);
    }

    public static double binomial() {
        //todo memoization technique for binomial theorem
        return -1;
    }

    private static class Counter {
        public int count;

        public Counter() {
            count = 0;
        }

        public void increment() {
            count++;
        }
    }
}
