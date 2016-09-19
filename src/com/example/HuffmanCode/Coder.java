package com.example.HuffmanCode;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by egorc on 11.09.2016.
 */
public class Coder {
    public PriorityQueue<Node> queue;
    public HashMap<Character, String> dict = new HashMap<>();

    public String encode(String msg) {
        String result = "";
        Node root = buildTree(msg);
        dfs(root, "");
        for (int i = 0; i < msg.length(); i++) {
            Character ch = msg.charAt(i);
            result += dict.get(ch);
        }
        return result;
    }

    public void dfs(Node n, String code) {
        if (n.isLeaf()) {
            dict.put(n.data, code);
            return;
        }
        dfs(n.left, code + "0");
        dfs(n.right, code + "1");
    }

    public Node buildTree(String msg) {
        HashMap<Character, Integer> freqs = getCharFrequency(msg);
        return buildTree(freqs);
    }

    public Node buildTree(HashMap<Character, Integer> freqs) {
        Set<Character> keys = freqs.keySet();
        queue = new PriorityQueue<>(freqs.size());

        for (Character k: keys) {
            Node n = new Node(k, freqs.get(k), null, null);
            queue.add(n);
        }

        while (queue.size() > 1) {
            Node n1 = queue.poll();
            Node n2 = queue.poll();
            Node n3 = new Node(null, n1.freq + n2.freq, n1, n2);
            queue.add(n3);
        }

        return queue.poll();
    }

    public HashMap<Character, Integer> getCharFrequency(String msg) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < msg.length(); i++) {
            Character ch = msg.charAt(i);
            if (result.containsKey(ch)) {
                Integer freq = result.get(ch);
                freq++;
                result.put(ch, freq);
            } else {
                result.put(ch, 1);
            }
        }

        return result;
    }
}
