package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.Queue;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 *          Source : https://github.com/aistrate/AlgorithmsSedgewick/blob/master/1-Fundamentals/1-3-BagsQueuesStacks/Ex_1_3_37.java
 */

public class Ex_1_3_37 {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]),
                m = Integer.parseInt(args[1]);

        Queue<Integer> q = new Queue<Integer>();
        for (int i = 0; i < n; i++)
            q.enqueue(new Integer(i));

        int k = 0;
        while (!q.isEmpty()) {
            int x = q.dequeue();

            if (++k % m == 0)
                StdOut.print(x + " ");
            else
                q.enqueue(x);
        }
        StdOut.println();
    }
}

//    This will return the safe place in O(n).
//        Source : https://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
//
//static int josephus(int n, int k)
//        {
//        if (n == 1)
//        return 1;
//        else
//    /* The position returned by josephus(n - 1, k)
//    is adjusted because the recursive call
//    josephus(n - 1, k) considers the original
//    position k%n + 1 as position 1 */
//        return (josephus(n - 1, k) + k-1) % n + 1;
//        }