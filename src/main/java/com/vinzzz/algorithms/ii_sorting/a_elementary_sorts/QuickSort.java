package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;
import com.vinzzz.libs.stdlib.StdRandom;

public class QuickSort {

    int[] data;

    public QuickSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        StdRandom.shuffle(data);
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] a, int low, int high) {
        if (low >= high) return;
        int k = partition(data, low, high);
        sort(a, 0, k - 1);
        sort(a, k + 1, high);
    }

    public void sort3way() {
        StdRandom.shuffle(data);
        sort3way(data, 0, data.length - 1);
    }

    private void sort3way(int[] a, int low, int high) {
        if (low >= high) return;

        int lt = low;
        int i = low + 1;
        int gt = high;
        Comparable v = a[low];
        while (i <= gt) {
            int comp = ((Comparable) a[i]).compareTo(v);
            if (comp < 0) exch(a, lt++, i++);
            if (comp > 0) exch(a, i, gt--);
            else i++;
        }
        sort(a, low, lt - 1);
        sort(a, gt + 1, high);

    }

    private int partition(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        Comparable v = a[low];

        while (true) {
            while (isLess(a[++i], v)) if (i == high) break;
            while (isLess(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }

        exch(a, low, j);
        return j;
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
        int n[] = {5, 6, 7, 1, 2, 4, 9, 3, 0};
        QuickSort quickSort = new QuickSort(n);
        quickSort.printArray();
//        quickSort.sort();
        quickSort.sort3way();
        quickSort.printArray();
    }
}
