package com.fankf.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * fankunfeng
 * 2020-10-21 22:56
 */
public class JedisTest {
    public static void main(String[] args) throws InterruptedException {
//        Jedis jedis = new Jedis("192.168.108.128",6379);
//        jedis.auth("123456");

        Jedis jedis = new Jedis("10.1.2.141",6379);
        jedis.auth("redis-dev");
        System.out.println(jedis.ping());

        // key
        SetParams setParams = new SetParams();
        setParams.nx();
        setParams.ex(5);
        String set = jedis.set("k1", "v1", setParams);
        System.out.println(set+"="+jedis.get("k1"));
        String set1 = jedis.set("k1", "v2", setParams);
        System.out.println(set1+"="+jedis.get("k1"));

        Thread.sleep(5000);
        String set2 = jedis.set("k1", "v2", setParams);
        System.out.println(set2+"="+jedis.get("k1"));

        System.out.println(jedis.keys("*"));

        //string
        System.out.println(jedis.get("k1"));

        //list

        //hash

        //set

        //zset
    }
}
