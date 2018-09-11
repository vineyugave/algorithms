package com.vinzzz.algorithms.iv_graphs;

import java.util.PriorityQueue;

public class Dijkstra {
    DirectedWeigthedEdge[] edgeTo;
    double[] distTo;
    PriorityQueue<Integer> pq;
    EdgeWeightedDiGraph graph;

    public Dijkstra(EdgeWeightedDiGraph graph) {
        this.graph = graph;
        distTo = new double[graph.V];
        edgeTo = new DirectedWeigthedEdge[graph.V];
        pq = new PriorityQueue<>();
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }

        relax(0);

        while (!pq.isEmpty()) {
//            relax();
        }
    }

    private void relax(int v) {
        for (DirectedWeigthedEdge edge : graph.adjList[v]) {
            int w = edge.to;
            if(distTo[w] > distTo[v] + edge.weight) {
                distTo[w] = distTo[v] + edge.weight;
                edgeTo[w] = edge;
            }
        }
    }
}
