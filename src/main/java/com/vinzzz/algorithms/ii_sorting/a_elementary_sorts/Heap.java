package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * Binary heap for positive ints
 */
public class Heap {
    private int[] data;
    private int N = 0;

    public Heap(int maxN) {
        this.data = new int[maxN + 1];
        data[0] = -1;
    }

    public Heap(int[] n) {
        this.data = n;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int p) {
        if (data.length < N) return;

        data[++N] = p;
        swim(N);
    }

    public int delMax() {
        int max = data[1];
        exch(data, 1, N--);
        data[N + 1] = -1;
        sink(1);
        return max;
    }

    public int delMin() {
        int min = data[N];
        data[N--] = -1;
        exch(data, 1, N);
        swim(N);
        return min;
    }

    public void sort() {
        int N = data.length - 1;
        for (int i = N / 2; i >= 1; i--) {
            sink(i, N);
        }
        printArray();

        while (N > 1) {
            exch(data, 1, N--);
            sink(1);
        }
    }

    private void swim(int key) {
        while (key > 1 && isLess(data[key / 2], data[key])) {
            exch(data, key / 2, key);
            key /= 2;
        }
    }

    private void sink(int key) {
        while (key * 2 <= N) {
            int j = 2 * key;
            if (j < N && isLess(data[j], data[j + 1])) {
                j++;
            }
            if (!isLess(key, j)) break;
            exch(data, key, j);
            key = j;
        }
    }

    private void sink(int key, int N) {
        while (key * 2 <= N) {
            int j = 2 * key;
            if (j < N && isLess(data[j], data[j + 1])) {
                j++;
            }
            if (!isLess(key, j)) break;
            exch(data, key, j);
            key = j;
        }
    }

    private void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void printArray() {
        for (int i = 0; i < data.length; i++) {
            StdOut.print(data[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
//        int n[] = {5, 6, 7, 1, 2, 4, 9, 3, 0};
//        Heap heap = new Heap(n.length);
//        for (int a : n) {
//            heap.insert(a);
//        }
//        heap.printArray();
//        StdOut.println(heap.delMax());

        int n[] = {-1, 5, 6, 7, 1, 2, 4, 9, 3, 0};
        Heap heap = new Heap(n);
        heap.printArray();
        heap.sort();
        heap.printArray();
    }
}
