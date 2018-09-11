package com.vinzzz.algorithms.iv_graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDiGraph {
    List<DirectedWeigthedEdge>[] adjList;
    int V;
    int E;

    public EdgeWeightedDiGraph(int v) {
        V = v;
        adjList = (ArrayList<DirectedWeigthedEdge>[]) new ArrayList[V];
    }

    public void addEdge(int v, int w, int weight) {
        adjList[v].add(new DirectedWeigthedEdge(v,w, weight));
        E++;
    }
}
