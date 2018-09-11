package com.vinzzz.algorithms.iii_searching;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Rules :
 * <p>Left leaning red node</p>
 * <p>No node has 2 red links connected to it </p>
 * <p>Every paht from root to null link has equal black links</p>
 *
 * @param <Key>
 * @param <Value>
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;

    private class Node {
        Node left;
        Node right;
        Key key;
        Value value;
        boolean color;

        public Node(Key key, Value value, boolean color) {
            this.key = key;
            this.value = value;
            this.color = color;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key,value);
        root.color = BLACK;
    }

    public Node put (Node x, Key key, Value value) {
        if(x == null) {
            return new Node(key, value, RED);
        }

        int compare = x.key.compareTo(key);
        if(compare > 0) {
            x.left = put(x.left, key, value);
        }else if (compare < 0) {
            x.right = put(x.right, key,value);
        }else{
            x.value = value;
        }

        if(isRed(x.right) && !isRed(x.left)) x = rotateLeft(x);
        if(isRed(x.left) && isRed(x.left.left)) x = rotateRight(x);
        if(isRed(x.left) && isRed(x.right)) flipColors(x);

        return x;
    }
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
