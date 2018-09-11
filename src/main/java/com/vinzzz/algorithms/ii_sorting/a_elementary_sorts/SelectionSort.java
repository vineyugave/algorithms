package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;

public class SelectionSort {
    int[] data;

    public SelectionSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        for (int i = 0; i < data.length; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (isLess(data[j], data[min])) {
                    min = j;
                }
            }
            swap(data, min, i);
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
        SelectionSort selectionSort = new SelectionSort(n);
        selectionSort.printArray();
        selectionSort.sort();
        selectionSort.printArray();
    }
}
