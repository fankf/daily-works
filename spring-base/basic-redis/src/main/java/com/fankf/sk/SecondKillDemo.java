package com.fankf.sk;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * fankunfeng
 * 2020-10-22 23:27
 */
public class SecondKillDemo {

    /**
     * 秒少
     * 问题1 ： 超卖问题 ，解决方案 Redis 乐观锁  watch
     * 问题2 ： 并发过大，发生连接超时问题   解决方案： Redis连接池控制最大并发数
     * 问题3 ：  连接不会超时，但是抢不完   Lua脚本
     * @param args
     */
    public static void main(String[] args) {

    }

    public Jedis connoct() {
        Jedis jedis = new Jedis("192.168.108.128", 6379);
        jedis.auth("123456");
        return jedis;
    }

    public void doSecondKill(String uid, String prodId) {
        String qtKey = "sk:" + prodId + ":qt";
        String uidKey = "sk:" + prodId + ":usr";
        Jedis jedis = connoct();
        //不能重复强
        if (jedis.sismember(uidKey, uid)) {
            jedis.close();
            return;
        }
        ;

        // 判断库存
        Integer num = Integer.valueOf(jedis.get(qtKey));
        if (num <= 0) {
            jedis.close();
            return;
        }


        // 减库存
//        jedis.decr(qtKey);
//        // 加用户
//        jedis.sadd(uidKey,uid);

        // 乐观锁
        Transaction multi = jedis.multi();
        multi.decr(qtKey);
        multi.sadd(uidKey, uid);

        List<Object> exec = multi.exec();

        if (exec != null && exec.size() > 0){

            System.out.println(uid + "抢购成功");
        }else{
            System.out.println(uid + "抢购失败");

        }

        jedis.close();
    }
}
