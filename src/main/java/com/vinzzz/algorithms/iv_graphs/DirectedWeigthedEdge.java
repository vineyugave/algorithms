package com.vinzzz.algorithms.iv_graphs;

public class DirectedWeigthedEdge implements Comparable<DirectedWeigthedEdge>{
    int from;
    int to;
    int weight;

    public DirectedWeigthedEdge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(DirectedWeigthedEdge that) {
        if(this.weight < that.weight) return -1;
        else if(this.weight > that.weight) return 1;
        return 0;
    }
}
