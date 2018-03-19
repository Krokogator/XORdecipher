package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;
import com.manytimepadbreaker.Static.CP1250Decoder;

public class Main {

    public static void main(String[] args) {

        BinaryLoader xorLoader = new BinaryLoader("C:\\Users\\micha\\Downloads\\XOR-ciphertext\\", 1000, "xor");

        byte[][] bytes256 = xorLoader.getBinary("312").getBytes();

        KeyBreaker keyBreaker = new KeyBreaker();

        for (byte b:keyBreaker.key256(bytes256)) {
            System.out.print(String.format("%02X ", b));
        }

        for(int j=0;j<bytes256.length;j++){
            byte[] xored = ByteXor.xor(keyBreaker.key256(bytes256), bytes256[j]);

            for(int i = 0; i<xored.length;i++){
                System.out.print(CP1250Decoder.byteToChar(xored[i]));
            }
        }
    }
}
