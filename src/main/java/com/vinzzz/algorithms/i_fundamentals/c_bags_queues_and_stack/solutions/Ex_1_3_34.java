package com.vinzzz.algorithms.i_fundamentals.c_bags_queues_and_stack.solutions;

import com.vinzzz.libs.stdlib.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author <a href="mailto:viney@vinzzz.com">Viney Ugave</a>
 * @version 1.0
 */

public class Ex_1_3_34 {

    private class RandomBag<T> implements Iterable<T>{
        private T[] dataArray;
        private int length;

        public RandomBag(int length) {
            dataArray = (T[]) new Object[length];
            this.length = 0;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void add(T data){
            dataArray[length] = data;
            length++;
        }

        @Override
        public Iterator<T> iterator() {
            StdRandom.shuffle(dataArray, 0, length-1);
            return new RandombagIterator();
        }

        private class RandombagIterator implements Iterator<T>{

            private int i;
            @Override
            public boolean hasNext() {
                return i < length;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();

                T value = dataArray[i % length];
                i++;
                return value;
            }
        }
    }
}
