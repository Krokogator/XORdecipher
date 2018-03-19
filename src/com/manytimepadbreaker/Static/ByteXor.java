package com.manytimepadbreaker.Static;

/**
 * Created by Michał(Krokogator) on 17.03.2018.
 */
public class ByteXor {
    public static byte[] xor(byte[] a, byte[] b){
        byte[] result = new byte[a.length];
        for (int i = 0; i < a.length; i++){ result[i] = xor(a[i], b[i]); }
        return result;
    }

    public static byte xor(byte a, byte b){
        return (byte) (a ^ b);
    }
}
