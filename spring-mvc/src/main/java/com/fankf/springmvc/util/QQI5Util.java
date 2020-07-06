package com.fankf.springmvc.util;

import com.qq.l5.L5sys;

public class QQI5Util {


    public static void main(String args[]) {
        L5sys.QosRequest req = new L5sys.QosRequest();
        req.modId = 64020545;
        req.cmdId = 131073;
        float timeout = (float) 0.2;

        L5sys l5sys = new L5sys();

        //普通方式获取路由
        for (int i = 0; i < 10; i++) {
            int ret = l5sys.ApiGetRoute(req, timeout);

            if (ret >= 0) {
                System.out.println("ip:" + req.hostIp + ",port:" + req.hostPort);
                long tm_start = System.currentTimeMillis();
                //todo:call remote service
                int rc = 0;//succ 0,fail <0
                long tm_end = System.currentTimeMillis();
                int tm_used = (int) (tm_end - tm_start);

                l5sys.ApiRouteResultUpdate(req, rc, tm_used);
            } else {
                System.out.println("ret:" + ret);
            }
        }

        System.out.println("---------------------------------------------");
        //一致性hash方式获取路由
        req.modId = 64020545;
        req.cmdId = 131073;
        req.key = 10;

        for (int i = 0; i < 10; i++) {
            int ret = l5sys.ApiGetRoute(req, timeout);

            if (ret >= 0) {
                System.out.println("ip:" + req.hostIp + ",port:" + req.hostPort);
                long tm_start = System.currentTimeMillis();
                //todo:call remote service
                int rc = 0;//succ 0,fail <0
                long tm_end = System.currentTimeMillis();
                int tm_used = (int) (tm_end - tm_start);

                l5sys.ApiRouteResultUpdate(req, rc, tm_used);
            } else {
                System.out.println("ret:" + ret);
            }
        }

        System.out.println("----------------------------------------------");
        //有状态到sid(注意需要下发规则)
        req.modId = 64072129;
        req.cmdId = 0;
        req.key = 10;
        for (int i = 0; i < 10; i++) {
            int ret = l5sys.ApiGetRoute(req, timeout);

            if (ret >= 0) {
                System.out.println("ip:" + req.hostIp + ",port:" + req.hostPort);
                long tm_start = System.currentTimeMillis();
                //todo:call remote service
                int rc = 0;//succ 0,fail <0
                long tm_end = System.currentTimeMillis();
                int tm_used = (int) (tm_end - tm_start);

                l5sys.ApiRouteResultUpdate(req, rc, tm_used);
            } else {
                System.out.println("ret:" + ret);
            }
        }
    }
}


