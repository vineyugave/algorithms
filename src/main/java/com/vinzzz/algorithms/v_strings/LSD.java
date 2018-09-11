package com.vinzzz.algorithms.v_strings;

public class LSD {

    public static void sort(String[] a, int W) {
        int N = a.length;
        int R = 256;
        String aux[] = new String[N];

        //count
        int[] count = new int[R + 1];
        for (int d = W - 1; d > 0; d--) {
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            //transform to index
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // distribute
            for (int j = 0; j < N; j++) {
                aux[count[a[j].charAt(d)]++] = a[j];
            }

            //copy back
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
