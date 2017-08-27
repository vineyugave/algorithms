package com.vinzzz.algorithms.i_fundamentals.b_data_abstraction.solutions;

import com.vinzzz.libs.stdlib.Counter;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_2_09 {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Counter c = new Counter("RANK_COUNTER");
        StdOut.println("Item found : " + (rank(2, a, c) > -1 ? true : false));
        StdOut.println("No. of checks : " + c.toString());
    }


    public static int rank(int key, int[] a, Counter c) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            c.increment();
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
