package com.vinzzz.algorithms.iv_graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimsAlgo {
    EdgeWeightedGraph graph;
    boolean[] marked;
    Queue<WeightedEdge> mst;
    PriorityQueue<WeightedEdge> pq;

    public PrimsAlgo(EdgeWeightedGraph graph) {
        this.graph = graph;
        mst = new LinkedList<>();
        pq = new PriorityQueue<>();
        marked = new boolean[graph.V];

        visit(0);

        while (!pq.isEmpty()) {
            WeightedEdge minEdge = pq.poll();
            int v = minEdge.either();
            int w = minEdge.other(v);

            if (marked[v] && marked[w]) continue;

            mst.add(minEdge);

            if(!marked[v]) visit(v);
            if(!marked[w]) visit(w);
        }
    }

    private void visit(int x) {
        marked[x] = true;
        List<WeightedEdge> edges = graph.adjList[x];
        pq.addAll(edges);

    }
}
