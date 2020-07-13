package com.dxhy.ofdfile.utils;

import com.qq.l5.L5sys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class L5Util {
    private L5sys l5sys;
    static {
        String property = System.getProperty("java.library.path");
        log.info("系统的library路径为:{},确保l5sys.so文件在上诉某路径下。",property);
    }
    public L5Util(){
        super();
        this.l5sys = new L5sys();
    }

    public L5sys.QosRequest get(int modId, int cmdId){
        try{
            L5sys.QosRequest req = new L5sys.QosRequest();
//        req.modId=64020545;
//        req.cmdId=131073;
            req.modId=modId;
            req.cmdId=cmdId;
            float timeout=(float)0.2;
            //普通方式获取路由
            for(int i=0;i<10;i++) {
                log.info("L5获取远程路由请求报文信息modId:{},cmdId:{}",req.modId,req.cmdId);
                int ret = l5sys.ApiGetRoute(req,timeout);
                log.info("L5获取远程路由响应报文信息：{}",ret);
                if(ret>=0) {
                    log.info("L5获取远程请求的ip：{},端口：{}",req.hostIp,req.hostPort);
                    return req;
                } else {
                    log.error("L5获取远程请求信息错误");
                }
            }
        } catch (Throwable e){
            log.error("L5获取远程请求信息异常",e);
        }

        return null;
    }

    public void ApiRouteResultUpdate(L5sys.QosRequest req ,int rc, int tm_used){
        l5sys.ApiRouteResultUpdate(req,rc,tm_used);
    }
}
