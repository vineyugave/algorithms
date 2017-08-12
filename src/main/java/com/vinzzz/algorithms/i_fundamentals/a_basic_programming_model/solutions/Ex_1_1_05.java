package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_05 {

    public static void main(String[] args) {
        StdOut.print(checkIfBetween0and1(.7, 0.5));
    }

    private static boolean checkIfBetween0and1(double a, double b) {
        return (a > 0 && b > 0 && a < 1 && b < 1);
    }
}
