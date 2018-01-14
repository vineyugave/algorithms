package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

import java.util.NoSuchElementException;

/**
 * Double linked LinkedList
 *
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_31 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.enqueue("A");
        list.enqueue("B");
        list.enqueue("C");

        StdOut.println(list.dequeue());
        StdOut.println(list.dequeue());
    }

    public static class LinkedList<T> {

        DoubleNode<T> first;
        DoubleNode<T> last;

        public LinkedList() {
            this.first = null;
            this.last = null;
        }

        private static class DoubleNode<T> {
            DoubleNode<T> prev;
            DoubleNode<T> next;
            T data;

            public DoubleNode(T data) {
                this.data = data;
            }
        }

        public void enqueue(T data) {
            if (first == null && last == null) {
                first = last = new DoubleNode<>(data);
            } else {
                DoubleNode<T> newNode = new DoubleNode<>(data);
                last.next = newNode;
                newNode.prev = last;
                last = newNode;
            }
        }

        public T dequeue() {
            if (first == null && last == null) throw new NoSuchElementException();

            DoubleNode<T> tempNode = last;
            last = tempNode.prev;
            last.next = null;

            return tempNode.data;
        }

    }
}
