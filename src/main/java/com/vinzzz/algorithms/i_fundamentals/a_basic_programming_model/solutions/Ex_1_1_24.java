package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_24 {

    public static void main(String[] args) {
        StdOut.println("Enter two numbers :");
        int[] num = StdIn.readInts();

        int result = gcd(num[0], num[1]);
        StdOut.println("GCD = " + result);
    }

    private static int gcd(int p, int q) {
        StdOut.printf("p: %d | q: %d \n", p, q);
        if (p % q == 0) return q;
        int r = p % q;
        return gcd(q, r);
    }
}
