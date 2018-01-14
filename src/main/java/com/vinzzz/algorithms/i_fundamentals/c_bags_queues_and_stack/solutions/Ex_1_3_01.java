package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_01 {

    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(3);

        StdOut.println("Stack is full = " + stack.isFull());
        stack.push("a");
        stack.push("b");
        stack.push("c");
        StdOut.println("Stack is full = " + stack.isFull());
    }

    public static class FixedCapacityStackOfStrings {
        private String[] a; // stack entries
        private int N; // size

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        public boolean isFull() {
            return N == a.length;
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public void push(String item) {
            a[N++] = item;
        }

        public String pop() {
            return a[--N];
        }
    }

}
