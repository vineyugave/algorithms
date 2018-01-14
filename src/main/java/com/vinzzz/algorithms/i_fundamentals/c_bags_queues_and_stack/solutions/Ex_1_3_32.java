package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_32 {

    public static void main(String[] args) {
        Steque<String> steque = new Steque<>();
        steque.push("A");
        steque.push("B");
        steque.push("C");
        steque.enqueue("-");

        Iterator<String>  iterator = steque.iterator();

        while(iterator.hasNext()){
            StdOut.println(iterator.next());
        }
    }

    private static class Steque<T> implements Iterable<T>{
        Node<T> first;
        Node<T> last;

        public Steque() {
            this.first = null;
            this.last = null;
        }

        private class Node<T> {
            Node<T> next;
            T data;

            public Node(T data) {
                this.data = data;
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new StequeIterator();
        }


        public void push(T data){
            if(first == null){
                first = last =  new Node<>(data);
            }else{
                Node<T> newNode = new Node<>(data);
                newNode.next = first;
                first = newNode;
            }
        }

        public T pop(){
            if(first == null) throw new NoSuchElementException();

            Node<T> temp = first;
            if(first == last){
                first = last = null;
            }else{
                first = first.next;
            }

            return temp.data;
        }

        public void enqueue(T data){
            if(first == null && last == null) {
                first = last = new Node<>(data);
            }else{
                Node<T> temp = new Node<>(data);
                last.next = temp;
                last = temp;
            }
        }

        //Iterator
        private class StequeIterator implements Iterator<T> {

            private Node<T> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        }
    }
}
