package com.manytimepadbreaker;

import com.manytimepadbreaker.Static.ByteXor;

import java.util.*;

/**
 * Created by Michał(Krokogator) on 17.03.2018.
 */
public class KeyBreaker {

    public byte[] key256(byte[][] encrtypted256){
        byte[] key = new byte[256];
        byte[] columnToDecrypt = new byte[encrtypted256.length];

        for(int i = 0; i < 256; i++){
            for(int j = 0; j < encrtypted256.length; j++){
                columnToDecrypt[j] = encrtypted256[j][i];
            }

            key[i] = decodeColumn(columnToDecrypt);
        }
        return key;
    }

    //Decodes keyByte of a single column (from different messages)
    private byte decodeColumn(byte[] byteRow){
        Map<Integer, Integer> byteChanceMap = new HashMap();

        //Create chance map
        for(int i = 0; i < (byteRow.length - 1); i++){
            fillInChanceMap(byteChanceMap, byteRow[i], byteRow[i+1]);
        }

        int max = Integer.MIN_VALUE;
        byte possibleKeyByte = 0;

        //Get byte with highest value
        for (Map.Entry<Integer, Integer> byteChance:byteChanceMap.entrySet()) {
            //System.out.print(byteChance.getValue()+", ");
            if(byteChance.getValue() > max){
                max = byteChance.getValue();
                possibleKeyByte = byteChance.getKey().byteValue();
            }
        }
        //System.out.print("\n\n");
        return possibleKeyByte;
    }

    private void fillInChanceMap(Map<Integer, Integer> chanceMap, byte value1, byte value2){
        byte xoredCiphers = ByteXor.xor(value1, value2);

        for(int i = 0; i < 256; i++){
            int val=0;
            try {
                 val = chanceMap.get((int)ByteXor.xor((byte) i, value1));
            } catch (Exception e){ }
            chanceMap.put((int)ByteXor.xor((byte) i, value1),calculateChance((byte) i, xoredCiphers)+val);
        }
    }

    private Integer calculateChance(byte i, byte xoredCiphers){
        byte outChar = ByteXor.xor(i, xoredCiphers);

        int outCharScore = getCharScore(outChar);
        int inCharScore = getCharScore(i);
        //System.out.print("i: "+i);
        //System.out.print(", c: "+CP1250Decoder.byteToChar(i));
        //System.out.println(", s: "+getCharScore(i));
        //System.out.print("out: "+outChar);
        //System.out.print(", c: "+CP1250Decoder.byteToChar(outChar));
        //System.out.println(", s: "+getCharScore(outChar));

        return outCharScore + inCharScore;
    }

    private int getCharScore(byte outChar){
        //Global big
        if(0x41<=outChar && outChar<=0x5A) { return 1; }

        //Global small
        if(97<=outChar && outChar<=122) { return 1; }

        //Polish letters
        if(Arrays.asList(new Integer[]{-45, -13, -116, -100, -93, -77, -113, -97, -91, -71, -81, -65, -58, -26, -54, -22, -47, -15, 32, 44, 46, 63}).contains(Integer.valueOf(outChar))){ return 1; }

        return -1;
    }
}
