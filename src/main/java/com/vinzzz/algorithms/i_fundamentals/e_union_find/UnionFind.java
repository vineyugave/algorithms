package com.vinzzz.algorithms.i_fundamentals.e_union_find;

import com.vinzzz.libs.stdlib.StdOut;

/**
 * Weighted Quick Union found implementation
 */
public class UnionFind {

    private int N[];
    private int weight[];
    private int count;

    public UnionFind(int count) {
        this.count = count;
        N = new int[count];
        weight = new int[count];

        for (int i = 0; i < count; i++) {
            N[i] = i;
            weight[i] = 1;
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    private int find(int p) {
        while (p != N[p]) {
            p = N[p];
        }
        return p;
    }

    private void union(int p, int q) {
        int a = find(p);
        int b = find(q);

        if (a == b) return;

        if (weight[p] < weight[q]) {
            N[q] = a;
            weight[p] += weight[q];
        } else {
            N[p] = b;
            weight[q] += weight[p];
        }
        count --;
    }

    public static void main(String[] args) {
        UnionFind unionFind = new UnionFind(10);

        unionFind.union(1,2);
        unionFind.union(2,3);
        StdOut.println("1, 3 isConnected : " + unionFind.isConnected(1,3));
    }
}