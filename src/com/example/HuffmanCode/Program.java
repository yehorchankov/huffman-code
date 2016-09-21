package com.example.HuffmanCode;

/**
 * Created by egorc on 07.08.2016.
 */
public class Program {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String msg = in.next();
        Coder coder = new Coder();
        String r = coder.encode(msg);
        System.out.print(r + "\n");
        System.out.print(coder.decode());
    }
}
