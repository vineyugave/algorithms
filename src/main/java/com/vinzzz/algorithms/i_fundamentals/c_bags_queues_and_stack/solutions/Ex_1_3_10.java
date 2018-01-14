package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.Stack;

/**
 * ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * Postfix expression : 12+34-56-**
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_10 {

    public static void main(String[] args) {
        String arg = StdIn.readLine();
        StdOut.println("Postfix expression : " + infixToPostFix(arg));
    }

    // Assumption : equation is balanced
    private static String infixToPostFix(String eq) {
        eq = eq.trim().replaceAll(" ", "");
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        for (int i = 0; i < eq.length(); i++) {
            String s = String.valueOf(eq.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals("(")) {
                // no-op
            } else if (s.equals(")")) {
                vals.push(ops.pop());
            } else {
                vals.push(s);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!ops.empty()) {
            result.append(ops.pop());
        }

        while (!vals.empty()) {
            result.append(vals.pop());
        }
        result = result.reverse();
        return result.toString();
    }
}
