package com.vinzzz.algorithms.iv_graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {

    List<WeightedEdge>[] adjList;
    int V;
    int E;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        adjList =  (ArrayList<WeightedEdge>[]) new ArrayList[V];
    }

    public void add(int v, int w, int weight) {
        adjList[v].add(new WeightedEdge(v,w,weight));
        adjList[w].add(new WeightedEdge(w, v, weight));
    }
}
