package com.vinzzz.algorithms.fundamentals_1.basic_programming_model_1_1;

import com.vinzzz.algorithms.util.*;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */
public class ex_1_1_3 {

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
        //enter filename in command line arguments
        int[] numbers = In.readInts(args[0]);

        if (checkIfEqual(numbers))
            System.out.println("equal");
        else
            System.out.println("not equal");
    }
}
