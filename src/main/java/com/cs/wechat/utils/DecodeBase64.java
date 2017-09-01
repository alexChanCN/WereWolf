package com.cs.wechat.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * Created by cs on 2017/8/25.
 */
public class DecodeBase64 {
    public static String Decode(String nickName) {
        try {
           nickName =  new String(Base64.decodeBase64(nickName.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return nickName;
    }
}
