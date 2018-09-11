package com.vinzzz.algorithms.iv_graphs;

public class WeightedEdge implements Comparable<WeightedEdge> {
    int v;
    int w;
    int weight;

    public WeightedEdge(int v, int w, int weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    public int other(int x) {
        if (x == v) return w;
        return v;
    }

    @Override
    public int compareTo(WeightedEdge o) {
        if (weight > o.weight) {
            return 1;
        } else if (weight < o.weight) {
            return -1;
        } else {
            return 0;
        }
    }
}
