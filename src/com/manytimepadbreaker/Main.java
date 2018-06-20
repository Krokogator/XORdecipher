package com.manytimepadbreaker;

public class Main {
    public static void main(String[] args) {
        XORdecipher decipher = new XORdecipher(args[0]);
        System.out.println(decipher.decode(Integer.valueOf(args[1])));
    }
}
