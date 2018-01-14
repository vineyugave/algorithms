package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.Stack;
import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_04 {

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String input = StdIn.readLine();
            StdOut.println("IsBalanced : " + checkParenthesis(input));
        }
    }

    public static boolean checkParenthesis(String equation) {
        if (equation == null) return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < equation.length(); i++) {
            char in = equation.charAt(i);

            if (in == '[' || in == '(' || in == '{') {
                stack.push(in);
            }

            if (in == ']' || in == ')' || in == '}') {
                char out = stack.pop();
                switch (out) {
                    case '[':
                        if (in != ']') return false;
                        break;
                    case '(':
                        if (in != ')') return false;
                        break;
                    case '{':
                        if (in != '}') return false;
                        break;
                }
            }
        }
        return true;
    }
}
