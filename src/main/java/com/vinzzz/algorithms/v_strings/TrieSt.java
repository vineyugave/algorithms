package com.vinzzz.algorithms.v_strings;

import com.vinzzz.libs.stdlib.Queue;

public class TrieSt<Value> {

    public static final int R = 256;
    private Node root;

    private static class Node {
        Object value;
        Node[] next = new Node[R];
    }


    public Value get(String key) {
        Node x = get(root, key, 0);
        if (x == null) return null;
        return (Value) x.value;
    }

    public Node get(Node x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) return x;

        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);

    }

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node x, String key, Value value, int d) {
        if (x == null) return new Node();

        if (d == key.length()) {
            x.value = value;
            return x;
        }

        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, value, d + 1);
        return x;
    }

    public Iterable<String> keys() {
        return getKeysWithPrefix("");
    }

    public Iterable<String> getKeysWithPrefix(String pre) {
        Queue<String> queue = new Queue<>();
        collect(get(root, pre, 0), pre, queue);
        return queue;
    }

    private void collect(Node x, String pre, Queue<String> queue) {
        if (x == null) return;

        if (x.value != null) queue.enqueue(pre);

        for (char c = 0; c < 256; c++) {
            collect(x.next[c], pre + c, queue);
        }

    }

    public Iterable<String> keysThatMatch(String s) {
        Queue<String> queue = new Queue<>();
        collect(root, "", s, queue);
        return queue;
    }

    private void collect(Node x, String pre, String pat, Queue<String> queue) {
        int d = pre.length();

        if (x == null) return;
        if (d == pat.length() && x.value != null) queue.enqueue(pre);
        if (d == pat.length()) return;

        char next = pat.charAt(d);
        for (char c = 0; c < d; c++) {
            if (next == ',' || next == c) {
                collect(x.next[c], pre + c, pat, queue);
            }
        }

    }

    public String longestPrefixOf(String s) {
        // TODO: 4/25/18
        return null;
    }
}
