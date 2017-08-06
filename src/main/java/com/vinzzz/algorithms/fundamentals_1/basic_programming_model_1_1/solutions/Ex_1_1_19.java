package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1.solutions;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_19 {

    public static void main(String[] args) {
        long[] result = fibonacci(1);
        System.out.print(Arrays.toString(result));
    }

    private static long[] fibonacci(int n) {
        if (n < 0) return null;

        n++;

        long[] array = new long[n];
        array[0] = 0;
        if(n > 1) array[1] = 1;

        for (int i = 2; i < n; i++) {
            array[i] = array[i-2] + array[i-1];
        }

        return array;
    }
}
