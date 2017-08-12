package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_30 {

    public static void main(String[] args) {
        int[][] test = new int[][]{{1, 2, 3}, {6, 4, 8}, {3, 1, 2}};

        boolean[][] result = checkForPrimes(test);
        System.out.println(Arrays.deepToString(result));
    }

    private static boolean[][] checkForPrimes(int[][] a) {
        boolean[][] prime = new boolean[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                int num = a[i][j];
                // 1,2,3 are prime
                if(num <= 3 && num > 0) prime[i][j] = true;

                //prime number divisible by itself
                --num;
                while (num > 3) {
                    //prime number not divisible by any other number than 1 or itself
                    if((a[i][j] % num) == 0) prime[i][j] = true;
                    num--;
                }
            }
        }
        return prime;
    }
}
