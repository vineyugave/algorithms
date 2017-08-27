package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction;

import com.vinzzz.libs.stdlib.StdDraw;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Source : https://github.com/morrxy/algs4/blob/master/exercise/1.2.10/VisualCounter.java
 */

public class VisualCounter {

    private int count = 0;
    /** current exp times */
    private int timesOfExp = 0;
    /** maximum absolute value this counter support */
    private int maxCount;

    public VisualCounter(int N, int max) {
        maxCount = max;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, max * 2);
        StdDraw.line(0, max, N, max);
    }

    public void increment() {
        timesOfExp += 1;
        count++;
        if (count > maxCount) {
            count = maxCount;
        }
        addOneCount(count, timesOfExp);
    }

    public void decrement() {
        timesOfExp += 1;
        count--;
        if (count < -maxCount) {
            count = -maxCount;
        }
        addOneCount(count, timesOfExp);
    }

    private void addOneCount(int count, int timesOfExp) {
        double x = (timesOfExp - 1) * 1 + .5;
        double y = maxCount + count / 2.0;
        double halfWidth = .5;
        double halfHeight = Math.abs(count / 2.0);
        StdDraw.rectangle(x, y, halfWidth, halfHeight);
    }

    public int tally() {
        return count;
    }

    public String toString() {
        return count + "";
    }

    public static void main(String[] args) {
        int T = 200;
        int max = 100;
        VisualCounter vc = new VisualCounter(T, max);

        for (int i = 0; i < T; i++) {
            if (StdRandom.bernoulli()) {
                vc.increment();
            } else {
                vc.decrement();
            }
        }
    }

}
