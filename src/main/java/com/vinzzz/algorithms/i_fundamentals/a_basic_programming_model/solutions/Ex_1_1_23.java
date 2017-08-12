package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.In;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_23 {

    public static void main(String[] args) {
        StdOut.println("Enter absolute path of filename :");
        String filename = StdIn.readString();
        int[] a = In.readInts(filename);
        Arrays.sort(a);

        StdOut.println("Enter the search key, we will find it for you : ");
        int[] key = StdIn.readInts();
        for (int i = 0; i < key.length; i++) {
            if (rank(key[i], a) == -1) printResult(key[i], false);
            else printResult(key[i], true);
        }
    }

    private static void printResult(int key, boolean isPresent) {
        if (isPresent) StdOut.printf("%d is present \n", key);
        else StdOut.printf("%d is NOT present \n", key);
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, ++depth);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, ++depth);
        else return mid;
    }
}
