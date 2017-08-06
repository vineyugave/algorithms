package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1.solutions;

/**Logarithm is the inverse of exponentiation
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * @see <a href = "https://en.wikipedia.org/wiki/Binary_logarithm">Binary Logarithm</a>
 */

public class Ex_1_1_14 {

    public static void main(String[] args) {
        System.out.println(lg(1027));
    }

    private static int lg(int value) {
        int i = 0;
        if (value <= 0) return (int) Double.NEGATIVE_INFINITY;

        while(value > 1){
            i++;
            value /= 2;
        }

        return i;
    }
}
