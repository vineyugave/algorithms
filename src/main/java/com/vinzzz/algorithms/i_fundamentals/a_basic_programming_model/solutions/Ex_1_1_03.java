package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdIn;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */
public class Ex_1_1_03 {

    private static boolean checkIfEqual(int[] args) {
        if (!(args.length > 0)) return false;
        int i = 1;
        int first = args[0];
        while (i < args.length) {
            if (first != args[i]) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers = StdIn.readInts();

        if (checkIfEqual(numbers))
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
