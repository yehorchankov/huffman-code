package com.example.HuffmanCode;

/**
 * Created by egorc on 11.09.2016.
 */
public class Node implements Comparable<Node> {
    public Character data;
    public int freq;
    public Node left;
    public Node right;

    public Node (Character c, Integer freq, Node left, Node right) {
        this.data = c;
        this.freq = freq;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf(){
        return left == null && right == null;
    }

    @Override
    public int compareTo(Node o) {
        return this.freq - o.freq;
    }
}
