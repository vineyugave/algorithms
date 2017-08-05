package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1;

/**
 * Euclidean Algorithm - Greatest Common Divisor
 * <p>
 * The largest number that divides 2 or more numbers without leaving a remainder
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * @see <a href="https://en.wikipedia.org/wiki/Euclidean_algorithm">https://en.wikipedia.org/wiki/Euclidean_algorithm</a>
 */

public class GCD {

    public static int gcd(int p, int q) {
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String args[]) {
        System.out.println(gcd(3, 2));
    }

}
