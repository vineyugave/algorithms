package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_20 {

    public static void main(String[] args) {
        double result = lnFactorial(10);
        System.out.println(result);
    }

    private static double lnFactorial(int n) {
        if (n <= 0) return (int) Float.NEGATIVE_INFINITY;
        if (n == 1) return 0;
        //ln(mn) = ln(m) + ln(n);
        return lnFactorial(n-1) + Math.log(n);
    }
}
