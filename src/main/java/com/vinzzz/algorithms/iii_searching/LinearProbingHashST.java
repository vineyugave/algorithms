package com.vinzzz.algorithms.iii_searching;

public class LinearProbingHashST<Key, Value> {

    private int M;
    private int N;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashST(int M) {
        this.M = M;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key k){
        return (k.hashCode() & 0x7FFFFFFF) % M;
    }

    public void put(Key key, Value val){

        int i;
        for (i = hash(key); keys[i] != null; i = (i+1)%M){
            if (keys[i].equals(key)) { values[i] = val; return; }
        }
        keys[i] = key;
        values[i] = val;
        N++;
    }

    public Value get(Key key){
        for (int i = hash(key); keys[i] != null; i = (i+1)%M){
            if (keys[i].equals(key)) { return values[i] ; }
        }

        return null;
    }
}
