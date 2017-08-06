package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1.solutions;

import com.vinzzz.algorithms.stdlib.StdRandom;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * @see <a href = "https://en.wikipedia.org/wiki/Random_seed">Random seed</a>
 */

public class Ex_1_1_15 {

    public static void main(String[] args) {
        int N = 10;
        int M = 5;
        int[] arg = new int[N];

        for (int i = 0; i < N; i++) {
            arg[i] = StdRandom.uniform(M);
        }
        System.out.println(Arrays.toString(arg));

        int[] result = histogram(arg, M);

        System.out.println(Arrays.toString(result));
    }

    private static int[] histogram(int[] arg, int M) {
        int[] temp = new int[M];

        for (int i = 0; i < arg.length; i++) {
            if (arg[i] < M) temp[arg[i]]++;
        }
        return temp;
    }
}
