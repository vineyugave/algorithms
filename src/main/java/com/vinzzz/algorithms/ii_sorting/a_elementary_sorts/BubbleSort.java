package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;

public class BubbleSort {

    int[] data;

    public BubbleSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (isLess(data[j + 1], data[j])) swap(data, j + 1, j);
            }
        }
    }

    private boolean isLess(Comparable d1, Comparable d2) {
        return d1.compareTo(d2) < 0;
    }

    private void swap(int[] array, int i, int j) {
        if (i < array.length && j < array.length) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public void printArray() {
        for (int i = 0; i < data.length; i++) {
            StdOut.print(data[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int n[] = {5, 6, 7, 1, 2, 4, 9, 3, 0};
        BubbleSort bubbleSort = new BubbleSort(n);
        bubbleSort.printArray();
        bubbleSort.sort();
        bubbleSort.printArray();
    }
}
