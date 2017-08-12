package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_09 {
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
