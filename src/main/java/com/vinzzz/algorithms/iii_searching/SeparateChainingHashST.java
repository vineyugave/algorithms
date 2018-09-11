package com.vinzzz.algorithms.iii_searching;

import com.vinzzz.libs.stdlib.SequentialSearchST;

public class SeparateChainingHashST<Key, Value>{

    int M;
    int N;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(10);
    }

    public SeparateChainingHashST(int m) {
        M = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key k){
        return (k.hashCode() & 0x7FFFFFFF) % M;
    }

    public Value get(Key k){
        return (Value) st[hash(k)].get(k);
    }

    public void put(Key k, Value value){
        st[hash(k)].put(k, value);
    }

    public static void main(String[] args) {
        SeparateChainingHashST<Integer, String> st = new SeparateChainingHashST<>(10);
        st.put(1, "a");
        st.put(2,"b");
        st.put(3,"c");
        st.put(4,"d");
        st.put(5,"e");
        st.put(12, "z");
    }
}
