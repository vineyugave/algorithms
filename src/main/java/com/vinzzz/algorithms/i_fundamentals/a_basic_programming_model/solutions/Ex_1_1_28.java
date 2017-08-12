package com.vinzzz.algorithms.i_fundamentals.a_basic_programming_model.solutions;

import java.util.Arrays;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_1_28 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 3, 5, 6, 2, 4};
        Arrays.sort(a);
        int[] noDups = removeDuplicates(a);
        System.out.println(rank(noDups, 3, 0, noDups.length));

    }

    private static int[] removeDuplicates(int[] a) {
        int numOfDups = a.length;
        for (int i = 0; i < a.length; i++) {
            if (i > 0 && a[i] == a[i - 1]) numOfDups--;
        }

        int[] temp = new int[numOfDups];
        int k = 0;
        for (int j = 0; j < a.length; j++) {
            if (j == 0 || a[j] != a[j - 1]) {
                temp[k] = a[j];
                k++;
            }
        }
        return temp;
    }

    private static int rank(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;

        if (key < a[mid]) return rank(a, key, lo, mid - 1);
        else if (key > a[mid]) return rank(a, key, mid + 1, hi);
        else return mid;
    }
}
