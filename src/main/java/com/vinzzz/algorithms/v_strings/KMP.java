package com.vinzzz.algorithms.v_strings;

public class KMP {
    private static final int R = 256;
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        dfa = new int[R][M];

        //construct DFA
        dfa[pat.charAt(0)][0] = 1;
        for (int i = 1, X = 0; i < M; i++) {
            for (int j = 0; j < R; j++) {
                // copy mismatch
                dfa[j][i] = dfa[j][X];
            }
            //match
            dfa[pat.charAt(i)][i] = i + 1;
            X = dfa[pat.charAt(i)][X];
        }
    }

    public int search(String text) {
        int N = text.length();
        int M = pat.length();
        int i,j;
        for ( i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[pat.charAt(i)][j];
        }
        if(j == M) return i - j;

        return -1;
    }
}
