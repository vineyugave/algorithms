package com.vinzzz.algorithms.v_strings;

public class MSD {

    public static int R = 256;
    public static final int M = 15; // cutoff for small arrays
    public static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {

        if (hi <= lo + M) {
            insertionSort(a, lo, hi, d);
            return;
        }

        //count
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d)]++;
        }

        //transform to index
        for (int i = 0; i < R + 1; i++) {
            count[R + 1] += count[R];
        }

        //distribute
        for (int i = lo; i <= hi; i++) {
            aux[count[a[i].charAt(d) + 1]++] = a[i];
        }

        //copy back
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }
    }

    public static void insertionSort(String[] a, int lo, int hi, int d) { // Sort from a[lo] to a[hi], starting at the dth character.
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
    }

    private static boolean less(String v, String w, int d) {
        return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void swap(String[] array, int i, int j) {
        if (i < array.length && j < array.length) {
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
