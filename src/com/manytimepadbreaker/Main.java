package com.manytimepadbreaker;

/**
 * args[0] ciphers folder path
 * args[1] desired cipher (last 3 digits)
 */
public class Main {
    public static void main(String[] args) {
        XORdecipher decipher = new XORdecipher(args[0]);
        //System.out.println(decipher.decode(Integer.valueOf(args[1])));
        System.out.println(decipher.testdecode(Integer.valueOf(args[1])));
    }
}
