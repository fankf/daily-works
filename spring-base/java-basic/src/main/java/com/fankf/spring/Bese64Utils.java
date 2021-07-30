package com.fankf.spring;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

/**
 * @author fankf
 * @date 2021/7/26 9:40
 * @description
 */
public class Bese64Utils extends Base64Utils {
    public static void main(String[] args) {
        String str = "https://blog.csdn.net/weixin_42798851/article/details/118678116?spm=1001.2014.3001.5501";
        // encode decode
        byte[] encode = encode(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(encode));

        byte[] decode = decode(encode);
        System.out.println(new String(decode));
        //encodeUrlSafe decodeUrlSafe
        byte[] bytes = encodeUrlSafe(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(new String(encode));

        byte[] decodeUrlSafe = decodeUrlSafe(bytes);
        System.out.println(new String(decodeUrlSafe));

        // encodeToString decodeFromString
        String encodeToString = encodeToString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeToString);
        byte[] decodeFromString = decodeFromString(encodeToString);
        System.out.println(new String(decodeFromString));

        String encodeToUrlSafeString = encodeToUrlSafeString(str.getBytes(StandardCharsets.UTF_8));
        System.out.println(encodeToUrlSafeString);
        byte[] decodeFromUrlSafeString = decodeFromUrlSafeString(encodeToUrlSafeString);
        System.out.println(new String(decodeFromUrlSafeString));
    }
}
