package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_18 {

    public static void main(String[] args) {

        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < 1000; i++) {
            accumulator.addDataValue(StdRandom.random());
        }

        StdOut.println("mean : " + accumulator.mean());
        StdOut.println("var : " + accumulator.var());
        StdOut.printf("stddev : " + accumulator.stddev());

    }

    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public Accumulator() {
        }

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }
}

