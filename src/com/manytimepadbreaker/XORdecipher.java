package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;
import com.manytimepadbreaker.Static.CP1250Decoder;

import java.util.List;

public class XORdecipher {

    private BinaryLoader binaryLoader;

    public XORdecipher(String ciphersUrl){
        this.binaryLoader = new BinaryLoader(ciphersUrl,1000, "xor");
    }

    public String decode(int indexEnding){
        String decoded = "";

        Binary binary = binaryLoader.getBinary(String.valueOf(indexEnding));
        byte[][] cipher = binary.getBytes();


        KeyBreaker keyBreaker = new KeyBreaker();
        byte[] key = keyBreaker.key256(cipher);

        /*for(int j=0;j<cipher.length;j++){
            byte[] message = ByteXor.xor(key, cipher[j]);

            for(int i = 0; i<message.length;i++){
                decoded += CP1250Decoder.byteToChar(message[i]);
            }
        }*/

        return decoded;
    }

    public String testdecode(int indexEnding){
        String decoded = "";
        Binary binary = binaryLoader.getBinary(String.valueOf(indexEnding));

        byte[][] cipherOLD = binary.getBytes();
        List<Byte>[] cipher = binary.getBytes2();
        KeyBreaker keyBreaker = new KeyBreaker();

        byte[][] cipherwithoutlastrow = new byte[cipher.length-1][256];
        for(int i = 0; i < cipher.length-1;i++){
            for(int j=0; j<256; j++){
                cipherwithoutlastrow[i][j] = cipher[i].get(j);
            }
        }

        byte[] key = keyBreaker.key256(cipherwithoutlastrow);

        for(int j=0;j<cipher.length;j++){
            byte[] message = ByteXor.xor(key, cipher[j]);

            for(int i = 0; i<message.length;i++){
                decoded += CP1250Decoder.byteToChar(message[i]);
            }
        }

        return decoded;
    }
}
