package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;
import com.manytimepadbreaker.Static.CP1250Decoder;

public class Main {

    //Index last 3 digits
    private static int indexEnding = 512;

    public static void main(String[] args) {

        BinaryLoader xorLoader = new BinaryLoader("C:\\Users\\micha\\Downloads\\XOR-ciphertext\\", 1000, "xor");
        Binary binary = xorLoader.getBinary(String.valueOf(indexEnding));
        byte[][] cipher = binary.getBytes();

        KeyBreaker keyBreaker = new KeyBreaker();
        byte[] key = keyBreaker.key256(cipher);

        System.out.println("Rozwiązanie dla pliku: "+binary.getFileName()+"\n");

        for(int j=0;j<cipher.length;j++){
            byte[] message = ByteXor.xor(key, cipher[j]);

            for(int i = 0; i<message.length;i++){
                System.out.print(CP1250Decoder.byteToChar(message[i]));
            }
        }
    }
}
