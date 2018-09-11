package com.vinzzz.algorithms.ii_sorting.a_elementary_sorts;

import com.vinzzz.libs.stdlib.StdOut;

public class MergeSort {

    int[] data;
    int[] aux;

    public MergeSort(int[] data) {
        this.data = data;
    }

    public void sort() {
        aux = new int[data.length];
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] a, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(a, low, mid);
        sort(a, mid + 1, high);
        merge(a, low, mid, high);
    }

    private void sortBottomTop() {
        int N = data.length;
        aux = new int[N];

        for (int jump = 1; jump < N; jump = jump + jump) {
            for (int i = 0; i < N - jump; i += jump + jump) {
                merge(data, i, i + jump - 1, Math.min(i + jump + jump - 1, N - 1));
            }
        }
    }

    private void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;

        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > high) a[k] = aux[i++];
            else if (aux[i] > aux[j]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    public void printArray() {
        for (int i = 0; i < data.length; i++) {
            StdOut.print(data[i] + " ");
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        int n[] = {5, 6, 7, 1, 2, 4, 9, 3, 0, 19, 13, 11, 99, 102, 77, 44};
        MergeSort mergeSort = new MergeSort(n);
        mergeSort.printArray();
        mergeSort.sort();
//        mergeSort.sortBottomTop();
        mergeSort.printArray();
    }
}
