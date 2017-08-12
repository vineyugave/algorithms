package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Reference : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_35.java
 */

public class Ex_1_1_35 {

    private static final int SIDES = 6;


    public static void main(String[] args) {
        System.out.println("Enter the number of dice trials :");
        int n = StdIn.readInt();
        double[] exact = diceSimulation();

        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7d", i);
        StdOut.println();

        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", exact[i]);
        StdOut.println();

        double[] experim = experimentDiceSimulation(n);
        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", experim[i]);
        StdOut.println();

        // Empirical results match exact ones to 3 decimal places when
        // n >= 10,000,000  (< 1 sec.)
    }

    private static double[] diceSimulation() {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= SIDES * SIDES;

        return dist;
    }

    private static double[] experimentDiceSimulation(int n) {
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 0; i < n; i++)
            dist[throwDice()]++;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= n;

        return dist;
    }

    public static int throwDice()
    {
        return StdRandom.uniform(1, SIDES+1) + StdRandom.uniform(1, SIDES+1);
    }
}
