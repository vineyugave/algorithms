package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Counter;
import com.vinzzz.libs.stdlib.StdDraw;

/**
 * For a better implementation check out {@link VisualCounter}
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_10 {

    public static void main(String[] args) {
        VisualCounter visualCounter = new VisualCounter(200, 100);
        for (int i = 0; i < 100; i++) {
            visualCounter.increment();
        }

        for (int i = 0; i < 100; i++) {
            visualCounter.decrement();
        }
    }

    /**
     * Counter decrement / increment operatons plotted on a graph
     */
    public static class VisualCounter {
        int n;
        int max;
        Counter c;


        public VisualCounter(int n, int max) {
            /**
             * Total num of operations
             */
            this.n = n;
            /**
             * Max total value of tally
             */
            this.max = max;
            c = new Counter(this.toString());

            StdDraw.setCanvasSize(800, 600);
            StdDraw.setXscale(0, n);
            StdDraw.setYscale(0, max * 2);
            StdDraw.line(0, max, n, max);
        }

        public void increment() {
            draw();
            if (n < 0) return;
            if (c.tally() < max) c.increment();
            n--;
        }

        public void decrement() {
            draw();
            if (n < 0) return;
            c.decrement();
            n--;
        }

        private void draw() {
            StdDraw.point(n, max +c.tally());
        }

        @Override
        public String toString() {
            return "VisualCounter{" +
                    "n=" + n +
                    ", max=" + max +
                    '}';
        }
    }
}
