package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.Locale;
import java.util.Stack;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_09 {

    public static void main(String[] args) {
        String arg = StdIn.readLine();
        StdOut.println("Balanced equation : " + balanceDelimiters(arg));
    }

    private static String balanceDelimiters(String equation) {
        equation = equation.trim().replaceAll(" ", "");
        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            String s = String.valueOf(equation.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String val = null;
                String op = null;

                if (!vals.empty()) {
                    val = vals.pop();
                }
                if (!ops.empty()) {
                    op = ops.pop();
                }

                if (val == null && op == null) {
                    throw new IllegalArgumentException("Invalid equation");
                } else if (op == null) {
                    val = String.format(Locale.getDefault(), "(%s)", val);
                    vals.push(val);
                } else if (!vals.isEmpty()) {
                    val = String.format(Locale.getDefault(), "(%s %s %s)", vals.pop(), op, val);
                    vals.push(val);
                } else {
                    throw new IllegalArgumentException("Invalid equation");
                }
            } else {
                vals.push(s);
            }
        }
        return vals.pop();
    }
}
