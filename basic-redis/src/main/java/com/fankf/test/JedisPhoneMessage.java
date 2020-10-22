package com.fankf.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * fankunfeng
 * 2020-10-21 23:03
 */
public class JedisPhoneMessage {
    public static final Jedis jedis = new Jedis("192.168.108.128", 6379);
    public static final String key = "phone:verify_code:";
    public static final Map<String, String> map = new ConcurrentHashMap<>();

    JedisPhoneMessage() {
    }

    public static void main(String[] args) {
//        String str1 = "123123123";
        String str1 = "";
        String str2 = "1202091";
        start(str1,str2);
    }

    private static void start(String s0, String s1) {
        jedis.auth("123456");
        // 生成6位随机数字 2分钟有效

        if (s1 == "") {
            createNum(s0);
        }

        // 输入验证成功或者失败
        if (s0 == "") {
            String num = jedis.get(key + s0);
            if (s1.equals(num)) {
                jedis.del(s0);
                System.out.println("成功！");
            } else {
                System.out.println(jedis.get(s0));
                if (jedis.get(s0) == null) {
                    jedis.set(s0, "1");
                } else {
                    jedis.incr(s0);
                }
                System.out.println(jedis.get(s0));

            }
        }


        // 每个号码只能输入三次
    }

    private static void createNum(String phonne) {
        Random random = new Random();
        String verifyCode = String.valueOf(random.nextInt(900000) + 100000);
        System.out.println(verifyCode);
        SetParams params = new SetParams();
        params.nx();
        params.ex(10);

        jedis.set(key + phonne, verifyCode, params);
    }
}



