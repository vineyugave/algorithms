package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdRandom;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * Reference : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-1-BasicProgModel/Ex_1_1_37.java
 */

public class Ex_1_1_37 {

    public static void badShuffle(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(N);     // between 0 and N-1
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    public static void main(String[] args)
    {
        System.out.println("Enter number of array elements :");
        int m = StdIn.readInt();
        System.out.println("Enter number of time to shuffle :");
        int n = StdIn.readInt();

        // closure
        Ex_1_1_36.IShuffle shuffle = new Ex_1_1_36.IShuffle()
        {
            public void shuffle(int[] a)
            {
                badShuffle(a);
            }
        };

        Ex_1_1_36.ShuffleTest(shuffle, m, n);
    }
}
