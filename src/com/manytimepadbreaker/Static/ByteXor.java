package com.manytimepadbreaker.Static;

import java.util.List;

/**
 * Created by Michał(Krokogator) on 17.03.2018.
 */
public class ByteXor {
    public static byte[] xor(byte[] a, List<Byte> b){
        byte[] result = new byte[a.length];
        for (int i = 0; i < b.size(); i++){ result[i] = xor(a[i], b.get(i)); }
        return result;
    }

    public static byte xor(byte a, byte b){
        return (byte) (a ^ b);
    }
}
