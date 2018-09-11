package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * H sort implementation
 */
public class ShellSort {

    int[] data;

    public ShellSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        int h = 1;
        while (h < data.length / 3) h = 3 * h + 1;

        while (h > 0) {
            for (int i = h; i < data.length; i++) {
                for (int j = i; j - h >= 0; j -= h) {
                    if (isLess(data[j], data[j - h])) swap(data, j, j - h);
                }
            }
            h = h / 3;
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
        ShellSort shellSort = new ShellSort(n);
        shellSort.printArray();
        shellSort.sort();
        shellSort.printArray();
    }
}
