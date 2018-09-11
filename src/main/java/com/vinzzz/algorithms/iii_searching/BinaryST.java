package com.vinzzz.algorithms.iii_searching;

public class BinaryST<Key extends Comparable, Value> {

    private Key[] keys;
    private Value[] values;
    private int N;

    public BinaryST(int capacity) {
        this.keys = (Key[]) new Comparable[capacity];
        this.values = (Value[]) new Object[capacity];
    }

    public void put(Key key, Value value) {
        int rank = rank(key);
        if (rank < N && key.compareTo(keys[rank]) == 0) {
            values[rank] = value;
            return;
        }

        for (int i = N; i < rank; i--) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[rank] = key;
        values[rank] = value;
        N++;
    }

    public Value get(Key key) {
        if (N < 1) return null;

        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) {
            N--;
            return values[rank];
        }
        return null;
    }

    public void delete(Key key) {
        if (N < 1) return;

        int rank = rank(key);
        if (rank < N && keys[rank].compareTo(key) == 0) {
            values[rank] = null;
        }
    }

    public int size() {
        return N;
    }

    // Binary search
    public int rank(Key key) {

        int lo = 0;
        int hi = N - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (keys[mid].compareTo(key) > 0) {
                hi = mid - 1;
            } else if (keys[mid].compareTo(key) < 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

}
