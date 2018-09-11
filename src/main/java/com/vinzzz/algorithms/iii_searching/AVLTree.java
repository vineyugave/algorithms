package com.vinzzz.algorithms.iii_searching;

public class AVLTree<Value extends Comparable<Value>> {

    private Node root;

    private class Node {
        Node right;
        Node left;
        int height;
        Value value;

        public Node(Value value) {
            this.value = value;
        }
    }

    private int height(Node x) {
        if(x == null) return -1;
        return x.height;
    }

    private int balanceFactor(Node x) {
        return height(x.left) - height(x.right);
    }

    public void put(Value value) {
        root = put(root, value);
    }

    private Node put(Node x, Value value) {

        if(x == null) {
            return new Node(value);
        }

        int compare = value.compareTo(x.value);
        if(compare < 0) {
           x.left = put(x.left, value);
        }else if(compare > 0){
            x.right = put(x.right, value);
        }

        x.height = 1 + Math.max(height(x.left), height(x.right));

        return balance(x);
    }

    private Node balance(Node x) {
        int balanceFactor = balanceFactor(x);

        if(balanceFactor > 1) {
            //left-right
            if(balanceFactor(x.left) < 0){
                x.left = rotateLeft(x.left);
            }

            //left-left
            x = rotateRight(x);
        } else if(balanceFactor < -1) {
            //right-left
            if(balanceFactor(x.right) > 0) {
                x.right = rotateRight(x.right);
            }

            //right-right
            x = rotateLeft(x);
        }

        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;

        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        return x;
    }
}
