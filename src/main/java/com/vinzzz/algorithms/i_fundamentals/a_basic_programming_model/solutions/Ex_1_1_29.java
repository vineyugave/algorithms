package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_29 {

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,4,4,7,8,9};
        int i = rank(a, 4, 0, a.length);
        int j = count(a, 4);

        StdOut.printf("The elements from %d to %d are all equal \n", i, i+j-1);
    }

    private static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) return rank(a, key, lo, mid - 1);
        else if (key > a[mid]) return rank(a, key, mid + 1, hi);
        else {
            //find all elements equal to the key
            while (--mid >= 0 && a[mid] == key);
            return ++mid;
        }
    }

    private static int count(int[] a, int key) {
        int c = 0;
        for (int i = rank(a, key, 0, a.length - 1); i < a.length && a[i] == key; i++) {
            c++;
        }
        return c;
    }
}

