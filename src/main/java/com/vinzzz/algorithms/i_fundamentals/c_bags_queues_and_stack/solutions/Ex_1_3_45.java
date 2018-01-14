package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.Stack;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_45 {

    public static void main(String[] args) {
//        for e.g :
//        1 4 7 9 8 6 5 3 0 2
//        2 was stacked on 0 as should have come out first

        StdOut.println(checIfValidStackSequence("1 4 7 9 8 6 5 3 0 2"));
        StdOut.println(checIfValidStackSequence("1 4 7 9 8 6 5 3 2 0"));
    }

    public static boolean checIfValidStackSequence(String sequence) {
        sequence = sequence.trim().replaceAll(" ", "");
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < sequence.length(); i++) {
//            StdOut.println(sequence.charAt(i));
//            StdOut.println(temp.toString());

            if (i == 0) {
                for (int j = 0; j < Character.getNumericValue(sequence.charAt(i)); j++) {
                    temp.push(j);
                }
            } else {
                if (temp.peek() < Character.getNumericValue(sequence.charAt(i))) {
                    for (int j = temp.peek() + 1; j < Character.getNumericValue(sequence.charAt(i)); j++) {
                        if (j != Character.getNumericValue(sequence.charAt(i - 1))) temp.push(j);
                    }
                } else {
                    if (temp.peek() != Character.getNumericValue(sequence.charAt(i))) {
                        return false;
                    } else {
                        temp.pop();
                    }
                }
            }
        }
        return true;
    }
}
