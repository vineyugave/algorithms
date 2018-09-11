package com.vinzzz.algorithms.iii_searching;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private int N;
        private Node right;
        private Node left;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }

        public void put(Key key, Value value) {
            root = put(root, key, value);
        }

        private Node put(Node x, Key key, Value value) {

            if (x == null) return new Node(key, value, 1);

            int compare = key.compareTo(x.key);

            if (compare < 0) x.left = put(x.left, key, value);
            else if (compare > 0) x.right = put(x.right, key, value);
            else x.value = value;
            x.N = x.left.N + x.right.N + 1;
            return x;
        }

        public Value get(Key key) {
            return get(root, key);
        }

        private Value get(Node x, Key key) {
            if (x == null) return null;

            int compare = key.compareTo(x.key);

            if (compare < 0) return get(x.left, key);
            else if (compare > 0) return get(x.right, key);
            else return x.value;
        }

        public Value getMin() {
            return getMin(root);
        }

        private Value getMin(Node x) {
            if (x.left == null) return x.value;
            return getMin(x.left);
        }

        public Value getMax() {
            return getMax(root);
        }

        public Key getCeiling(Key key) {
            return getCeiling(root, key);
        }

        private Key getCeiling(Node x, Key key) {

            if (x == null) return null;

            int compare = key.compareTo(x.key);

            if (compare == 0) return x.key;

            if (compare < 0) return getCeiling(x.right, key);

            Key k = getCeiling(x.left, key);

            if (key.compareTo(k) >= 0) {
                return k;
            } else {
                return x.key;
            }

        }

        public Key getFloor(Key key) {
            return getFloor(root, key);
        }

        private Key getFloor(Node x, Key key) {
            if (x == null) return null;

            int compare = key.compareTo(x.key);

            if (compare == 0) return x.key;

            if (compare > 0) return getCeiling(x.left, key);

            Key k = getCeiling(x.right, key);

            if (key.compareTo(k) >= 0) {
                return k;
            } else {
                return x.key;
            }
        }


        public Key select(int k) {
            return select(root, k).key;
        }

        private Node select(Node x, int k) {
            // Return Node containing key of rank k.
            if (x == null) return null;
            int t = size(x.left);
            if (t > k) return select(x.left, k);
            else if (t < k) return select(x.right, k - t - 1);
            else return x;
        }

        public int rank(Key k) {
            return rank(root, k);
        }

        private int rank(Node x, Key k) {
            if (key == null) return 0;

            int compare = k.compareTo(x.key);

            if (compare < 0) return rank(x.left, k);
            else if (compare > 0) return 1 + size(x) + rank(x.right, k);
            else return size(x.left);


        }

        public Node delete(Key k) {
            return delete(root, k);
        }

        private Node delete(Node x, Key k) {
            if (root == null) return null;

            int compare = k.compareTo(x.key);
            if (compare < 0) x.left = delete(x.left, k);
            else if (compare > 0) x.right = delete(x.right, k);
            else {
                if (x.right == null) return x.left;
                if (x.left == null) return x.right;
                Node t = x;
                x = min(x.right);
                x.right = deleteMin(t.right);
                x.left = t.left;
            }
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        private Node min(Node x) {
            if (x.left == null) return x;
            else return min(x.left);
        }

        private Node deleteMin(Node x) {
            if (x.left == null) return x.right;
            x.left = deleteMin(x.left);
            x.N = size(x.left) + size(x.right) + 1;
            return x;
        }

        private Value getMax(Node x) {
            if (x.right == null) return x.value;
            return getMax(x.right);
        }

        public int size(Node n) {
            if (n == null) return 0;
            return n.N;
        }


        // for keys see stdlib.BST
    }
}
