package com.fankf.file.util;

import org.springframework.util.Base64Utils;

import java.io.UnsupportedEncodingException;

/**
 * @author fankf
 * @date 2021/7/15 18:38
 * @description
 */
public class Base64Util extends Base64Utils {

    public static void main(String[] args) {
        String str = "dsadsad";
        byte[] decode = new byte[0];
        try {
            decode = decode(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(decode.toString());

    }
}

