package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

import java.util.*;

/**
 * Move to first
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_40 {

    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        moveToFront(list, 'a');
        moveToFront(list, 'b');
        moveToFront(list, 'c');
        moveToFront(list, 'a');

    }

    private static void moveToFront(LinkedList list, Character c) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == c) {
                iterator.remove();
            }
        }

        list.add(c);

        StdOut.println(Arrays.toString(list.toArray()));
    }

}
