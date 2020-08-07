package com.fankf.springmvc.sf.util;

/**
 * @author fankunfeng
 * @datetime 2020-08-06 16:31
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallExpressServiceTools {
    private static Logger logger = LoggerFactory.getLogger(CallExpressServiceTools.class);

    private static CallExpressServiceTools tools = new CallExpressServiceTools();

    public static CallExpressServiceTools getInstance() {
        synchronized (CallExpressServiceTools.class) {
            if (tools == null) {
                tools = new CallExpressServiceTools();
            }
        }
        return tools;
    }

    public static String callSfExpressServiceByCSIM(String reqURL, String reqXML, String clientCode, String checkword) {
        String result = null;
        String verifyCode = VerifyCodeUtil.md5EncryptAndBase64(reqXML + checkword);
        result = querySFAPIservice(reqURL, reqXML, verifyCode);
        return result;
    }

    public static String querySFAPIservice(String url, String xml, String verifyCode) {
        HttpClientUtil httpclient = new HttpClientUtil();

        if (url == null) {
            url = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
        }

        String result = null;
        try {
            return httpclient.postSFAPI(url, xml, verifyCode);
        } catch (Exception e) {
            logger.warn(" " + e);
        }

        return null;
    }

    public static String packageMsgData(EspServiceCode espServiceCode) {
        String jsonString = "";
        try {
            InputStream is = new FileInputStream(espServiceCode.getPath());
            byte[] bs = new byte[is.available()];
            is.read(bs);
            jsonString = new String(bs);
        } catch (Exception localException) {
        }
        return jsonString;
    }

    public static String getMsgDigest(String msgData, String timeStamp, String md5Key) throws UnsupportedEncodingException {
        String msgDigest = VerifyCodeUtil.md5EncryptAndBase64(URLEncoder.encode(msgData + timeStamp + md5Key, "UTF-8"));

        return msgDigest;
    }
}