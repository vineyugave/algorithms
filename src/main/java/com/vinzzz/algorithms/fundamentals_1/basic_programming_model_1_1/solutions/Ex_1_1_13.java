package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1.solutions;

import java.util.Arrays;

/**Transpose M x N matrix
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 * @see <a href = "https://chortle.ccsu.edu/VectorLessons/vmch13/vmch13_14.html">Transpose</a>
 */

public class Ex_1_1_13 {

    public static void main(String[] args) {
        int[][] result = transpose(init(3,4));
        System.out.print("result = ");
        System.out.print(Arrays.deepToString(result));
    }

    private static int[][] init(int r, int c) {
        int[][] temp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                temp[i][j] = j;
            }
        }
        System.out.print("temp = ");
        System.out.print(Arrays.deepToString(temp));
        return temp;
    }

    private static int[][] transpose(int[][] arg) {

        if (arg == null) return null;

        int rows = arg.length;
        int columns = arg[0].length;

        int[][] transposedArray = new int[columns][rows];

        for (int i = 0; i < rows ; i++) {
            //for square matrices we can init j =1 and do it in-place instead of
            //creating a new array. In that case ar[j][i] = arg[i][j]
            for (int j = 0; j < columns; j++) {
                transposedArray[j][i] = arg[i][j];
            }
        }

        return transposedArray;
    }
}
