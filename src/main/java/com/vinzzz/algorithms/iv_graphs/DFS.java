package com.vinzzz.algorithms.iv_graphs;

import java.util.*;

public class DFS {

    private int E;
    private int V;
    private List<Integer>[] adj;
    private boolean[] marked;
    private int count;
    private int[] edgeTo;
    private int s;
    private Queue<Integer> queue;

    public DFS(int V) {
        this.V = V;
        adj = (List<Integer>[]) new List[this.V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        marked = new boolean[V];
        edgeTo = new int[V];

        //BFS
        queue = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // s needs to be set here ...
    public void DFS(int v) {
        marked[v] = true;
        count++;
        for (int w : adj[v]) {
            if (!isMarked(w)) {
                edgeTo[w] = v;
                DFS(w);
            }
        }
    }

    public void bfs(int v) {
        marked[v] = true;
        queue.add(v);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int w : adj[u]) {
                edgeTo[w] = u;
                marked[w] = true;
                queue.add(w);
            }
        }
    }

    private boolean hasPathToo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathToo(V)) return null;

        Stack<Integer> path = new Stack<>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        path.add(v);
        return path;
    }

    private boolean isMarked(int V) {
        return marked[V];
    }

}
