package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_12 {

    public static void main(String[] args) {
        Stack<String> arg = new Stack<>();
        arg.push("a");
        arg.push("b");
        arg.push("c");
        arg.push("d");

        StdOut.println("Copy stack : " + arg.copy(arg).toString());
        StdOut.println("Arg stack : " + arg.toString());
    }

    public static class Stack<Item> implements Iterable<Item> {
        private Node<Item> first;     // top of stack
        private int n;                // size of the stack

        // helper linked list class
        private static class Node<Item> {
            private Item item;
            private Node<Item> next;
        }

        /**
         * Initializes an empty stack.
         */
        public Stack() {
            first = null;
            n = 0;
        }

        /**
         * Returns true if this stack is empty.
         *
         * @return true if this stack is empty; false otherwise
         */
        public boolean isEmpty() {
            return first == null;
        }

        /**
         * Returns the number of items in this stack.
         *
         * @return the number of items in this stack
         */
        public int size() {
            return n;
        }

        /**
         * Adds the item to this stack.
         *
         * @param item the item to add
         */
        public void push(Item item) {
            Node<Item> oldfirst = first;
            first = new Node<Item>();
            first.item = item;
            first.next = oldfirst;
            n++;
        }

        /**
         * Removes and returns the item most recently added to this stack.
         *
         * @return the item most recently added
         * @throws NoSuchElementException if this stack is empty
         */
        public Item pop() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            Item item = first.item;        // save item to return
            first = first.next;            // delete first node
            n--;
            return item;                   // return the saved item
        }


        /**
         * Returns (but does not remove) the item most recently added to this stack.
         *
         * @return the item most recently added to this stack
         * @throws NoSuchElementException if this stack is empty
         */
        public Item peek() {
            if (isEmpty()) throw new NoSuchElementException("Stack underflow");
            return first.item;
        }


        /**
         * Returns a copy of a stack containing STRING
         *
         * @param stack a stack containing strings
         * @return copy of stack
         */
        public Stack copy(Stack stack) {
            Stack<String> result = new Stack<>();

            Iterator iterator = stack.iterator();

            while (iterator.hasNext()) {
                result.push((String) iterator.next());
            }

            result = reverse(result);
            return result;
        }

        private Stack<String> reverse(Stack<String> stack) {
            Stack<String> result = new Stack<>();
            while (!stack.isEmpty()) {
                result.push(stack.pop());
            }

            return result;
        }


        /**
         * Returns a string representation of this stack.
         *
         * @return the sequence of items in this stack in LIFO order, separated by spaces
         */
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Item item : this) {
                s.append(item);
                s.append(' ');
            }
            return s.toString();
        }


        /**
         * Returns an iterator to this stack that iterates through the items in LIFO order.
         *
         * @return an iterator to this stack that iterates through the items in LIFO order
         */
        public Iterator<Item> iterator() {
            return new ListIterator<Item>(first);
        }

        // an iterator, doesn't implement remove() since it's optional
        private class ListIterator<Item> implements Iterator<Item> {
            private Node<Item> current;

            public ListIterator(Node<Item> first) {
                current = first;
            }

            public boolean hasNext() {
                return current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }
}
