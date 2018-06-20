package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;
import com.manytimepadbreaker.Static.CP1250Decoder;

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

        for(int j=0;j<cipher.length;j++){
            byte[] message = ByteXor.xor(key, cipher[j]);

            for(int i = 0; i<message.length;i++){
                decoded += CP1250Decoder.byteToChar(message[i]);
            }
        }

        return decoded;
    }
}
