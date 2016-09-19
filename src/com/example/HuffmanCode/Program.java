package com.example.HuffmanCode;

/**
 * Created by egorc on 07.08.2016.
 */
public class Program {
    public static void main(String[] args){
        String msg = "it was the best of times it was the worst of times";
        Coder coder = new Coder();
        String r = coder.encode(msg);
        System.out.println(r);

        float s = r.length();
        System.out.println(s / msg.length() / 8);
    }
}
