package com.cs.wechat.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Binary Wang(https://github.com/binarywang)
 */
public class EncodePwdUtils {
    private static final BCryptPasswordEncoder encode = new BCryptPasswordEncoder();

    /*private static EncodeUtils instance = new EncodeUtils();
    private static EncodeUtils getInstance(){return instance;}*/

    public static String toEncode(String s) {
        //BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String hashPass = encode.encode(s);
        return hashPass;
    }

    public static boolean decode(String s,String encodeS) {
        //BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        return encode.matches(s,encodeS);
    }

}
