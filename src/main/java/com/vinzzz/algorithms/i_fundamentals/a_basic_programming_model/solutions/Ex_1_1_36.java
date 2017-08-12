package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Reference : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_36.java
 */

public class Ex_1_1_36 {

    public static void main(String[] args) {
        System.out.println("Enter number of array elements :");
        int M = StdIn.readInt();
        System.out.println("Enter number of time to shuffle :");
        int N = StdIn.readInt();

        // closure
        IShuffle shuffle = new IShuffle()
        {
            public void shuffle(int[] a)
            {
                StdRandom.shuffle(a);
            }
        };

        ShuffleTest(shuffle, M, N);
    }

    public interface IShuffle
    {
        public void shuffle(int[] a);
    }

    public static void ShuffleTest(IShuffle shuffle, int m, int n)
    {
        int[][] s = new int[m][m];

        for (int k = 0; k < n; k++)
        {
            int[] a = new int[m];
            for (int i = 0; i < m; i++)
                a[i] = i;

            shuffle.shuffle(a);

            for (int i = 0; i < m; i++)
                s[i][a[i]]++;
        }

        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < m; j++)
                StdOut.printf("%7d", s[i][j]);
            StdOut.println();
        }
    }
}
