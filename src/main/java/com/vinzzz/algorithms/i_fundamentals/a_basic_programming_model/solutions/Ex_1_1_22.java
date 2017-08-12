package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

/**
 * Recursive Binary Search
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_22 {

    public static void main(String[] args) {
        //pre condition arg array is sorted
        int[] arg = new int[100];
        for (int i = 0; i < 100; i++) {
            arg[i] = i;
        }

        rank(3, arg);
    }

    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        System.out.printf("lo: %d | mid: %d | hi: %d | depth: %d | \n", lo, mid, hi, depth);
        if (key < a[mid]) return rank(key, a, lo, mid - 1, ++depth);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, ++depth);
        else return mid;
    }
}
