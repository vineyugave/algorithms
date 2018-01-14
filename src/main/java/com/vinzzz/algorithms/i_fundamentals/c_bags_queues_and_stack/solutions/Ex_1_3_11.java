package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdIn;
import com.vinzzz.libs.stdlib.StdOut;

import java.util.Stack;

/**
 * 12+34-56-**
 * Evaluated value :3.0
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_11 {

    public static void main(String[] args) {
        String arg = StdIn.readLine();
        StdOut.println("Evaluated value :" + evaluatePostFix(arg));
    }

    //Assumption valid postfix expression
    public static final String evaluatePostFix(String postFixExpression) {
        postFixExpression = postFixExpression.trim().replaceAll(" ", "");
        Stack<String> values = new Stack<>();

        for (int i = 0; i < postFixExpression.length(); i++) {
            String s = String.valueOf(postFixExpression.charAt(i));

            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                values.push(evaluate(values.pop(), values.pop(), s));
            } else {
                values.push(s);
            }
        }
        return values.pop();
    }

    private static String evaluate(String v1, String v2, String op) {
        switch (op) {
            case "+":
                return String.valueOf(Float.parseFloat(v1) + Float.parseFloat(v2));
            case "-":
                return String.valueOf(Float.parseFloat(v1) - Float.parseFloat(v2));
            case "*":
                return String.valueOf(Float.parseFloat(v1) * Float.parseFloat(v2));
            case "/":
                return String.valueOf(Float.parseFloat(v1) / Float.parseFloat(v2));

            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
