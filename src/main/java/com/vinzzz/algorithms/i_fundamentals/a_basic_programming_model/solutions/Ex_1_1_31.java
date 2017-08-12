package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdDraw;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * Reference : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_31.java
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 *
 */

public class Ex_1_1_31 {

    public static void main(String[] args) {
        System.out.println("Enter number of dots : ");
        int N = StdIn.readInt();
        System.out.println("Enter the probability for connecting lines");
        double p = StdIn.readDouble();
        p = Math.max(0, Math.min(1, p));

        drawRandConn(N, p);
    }

    private static void drawRandConn(int N, double p) {
        StdDraw.setCanvasSize(1024, 1024);
        //circle is of radius 1 so draw center at origin
        StdDraw.setScale(-1.0, 1.0);
        StdDraw.setPenRadius(.015);

        //determine the x & y of the point by equally distributing them around the circle
        double[][] d = new double[N][2];
        for (int i = 0; i < N; i++)
        {
            //x
            d[i][0] = Math.cos(2 * Math.PI * i / N);
            //y
            d[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(d[i][0], d[i][1]);
        }

        StdDraw.setPenRadius();

        for (int i = 0; i < N - 1; i++)
            for (int j = i + 1; j < N; j++)
                //get random  true / false based on probability
                //for each pair of point
                if (StdRandom.bernoulli(p))
                    StdDraw.line(d[i][0], d[i][1], d[j][0], d[j][1]);
    }
}
