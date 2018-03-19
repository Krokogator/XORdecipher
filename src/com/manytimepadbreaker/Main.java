package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;
import com.manytimepadbreaker.Static.CP1250Decoder;

public class Main {

    public static void main(String[] args) {

        BinaryLoader xorLoader = new BinaryLoader("C:\\Users\\micha\\Desktop\\XOR-ciphertext\\", 1000, "xor");
        //BinaryLoader textLoader = new BinaryLoader("C:\\Users\\micha\\Desktop\\normalText\\",2,"txt");

        xorLoader.getBinary("312").getContent();
        byte[][] bytes256 = xorLoader.getBinary("312").getBytes();
        /*


        for(int i = 0;i<bytes.length;i++){
            if(i%256==0) { System.out.print("\n\n"); }
            System.out.print(String.format("%02X ", bytes[i]));
        }

        System.out.println("\n\n256 table test\n\n");

        byte[][] bytes256 = xorLoader.getBinary("312").getBytes();
        for(int i=0;i<bytes256.length;i++){
            for (int j=0;j<bytes256[i].length;j++){
                System.out.print(String.format("%02X ", bytes256[i][j]));
            }
            System.out.print("\n\n");
        }

        */

        KeyBreaker keyBreaker = new KeyBreaker();

        /*
        byte[] xored = ByteXor.xor(bytes256[41], bytes256[42]);
        for(int i = 0; i < 256; i++){
            System.out.print(String.format("%02X ", xored[i]));
        }*/

        for (byte b:keyBreaker.key256(bytes256)) {
            System.out.print(String.format("%02X ", b));
        }


        for(int j=0;j<43;j++){
            byte[] xored = ByteXor.xor(keyBreaker.key256(bytes256), bytes256[j]);

            for(int i = 0; i<xored.length;i++){
                System.out.print(CP1250Decoder.byteToChar(xored[i]));
            }
        }
    }
}
