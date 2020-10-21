package com.fankf.test;

import redis.clients.jedis.Jedis;

/**
 * fankunfeng
 * 2020-10-21 22:56
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.108.128",6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());

        // key
        jedis.set("k1","v1");
        jedis.set("k2","v2");
        System.out.println(jedis.keys("*"));

        //string
        System.out.println(jedis.get("k1"));

        //list

        //hash

        //set

        //zset
    }
}
