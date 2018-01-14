package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_29 {

    public static void main(String[] args) {

        CircularLinkedList<String> queue = new CircularLinkedList<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");

        StdOut.println("Last.next item : " + queue.getLast().next.t);
        StdOut.println("Dequeued item : " + queue.dequeue());
        StdOut.println("Last.next item : " + queue.getLast().next.t);
    }

    public static class CircularLinkedList<T> {

        public class Node {
            T t;
            Node next;

            public Node(T t) {
                this.t = t;
            }
        }

        private Node last = null;

        public void enqueue(T t) {
            Node old = last;
            last = new Node(t);

            if (old == null) {
                //first time add
                last.next = last;
            } else {
                last.next = old.next;
                old.next = last;
            }
        }

        public T dequeue() {
            T item = last.next.t;

            last.next = last.next.next;
            return item;
        }

        public Node getLast() {
            return last;
        }
    }
}
