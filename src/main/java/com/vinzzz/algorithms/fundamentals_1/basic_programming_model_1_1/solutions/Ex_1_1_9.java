package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1.solutions;

import com.vinzzz.algorithms.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_9 {
    static String s = "";

    public static void main(String[] args) {
        // can also use Integer.toBinaryString(N)
        int N = 432432425;
        for (int i = N; i > 0; i /= 2) {
            s = s + i % 2;
        }
        StdOut.println(s);
    }
}
