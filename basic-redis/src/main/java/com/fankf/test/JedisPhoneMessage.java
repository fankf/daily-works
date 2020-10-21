package com.fankf.test;

import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * fankunfeng
 * 2020-10-21 23:03
 */
public class JedisPhoneMessage {
    public static final Jedis jedis = new Jedis("192.168.108.128",6379);
    public static final String key = "phone:128xxxxxx:verify_code";
    JedisPhoneMessage(){}

    public static void main(String[] args) {
        jedis.auth("123456");
        // 生成6位随机数字 2分钟有效
        createNum();
        // 输入验证成功或者失败

        // 每个号码只能输入三次

    }

    private static void createNum() {
        Random random = new Random();
        String verifyCode = String.valueOf(random.nextInt(900000) + 100000);
        System.out.println(verifyCode);
        jedis.setex(key,120,verifyCode);
    }
}
