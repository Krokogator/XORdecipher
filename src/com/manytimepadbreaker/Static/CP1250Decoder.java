package com.manytimepadbreaker.Static;

import java.io.UnsupportedEncodingException;

/**
 * Created by Michał(Krokogator) on 17.03.2018.
 */
public class CP1250Decoder {



    public static String byteToChar(byte b){
        byte[] bytes = new byte[1];
        bytes[0] = b;
        try {
            return new String(bytes, "windows-1250");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
