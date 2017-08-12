package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_11 {

    public static void main(String[] args) {
        print2DArray(init(10, 10));
    }

    //init 2d array and make diagonal elements true
    private static boolean[][] init(int r, int c) {
        boolean[][] test = new boolean[r][c];
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                if (i == j)
                    test[i][j] = true;
            }
        }
        return test;
    }

    private static void print2DArray(boolean[][] arg) {
        if (arg == null) return;

        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < arg[0].length; j++) {
                if (arg[i][j] == true)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
        }
    }
}
