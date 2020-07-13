package com.dxhy.ofdfile.controller;

import com.dxhy.ofdfile.protocol.RESPONSE;
import com.dxhy.ofdfile.protocol.WRITE_OFD_FILE;
import com.dxhy.ofdfile.utils.L5Util;
import com.qq.l5.L5sys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Base64;

/**
 * @author fan
 * @create 2020-06-26 21:16
 * @description
 * @see
 */
@RestController
@Slf4j
public class OfdController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${tx-url.write}")
    private String writeUrl;
    @Value("${tx-url.read}")
    private String readUtl;

    @Value("${l5.modId:64020545}")
    private int modId;
    @Value("${l5.cmdId:131073}")
    private int cmdId;
    @Value("${l5.host:pay.weixin.qq.com}")
    private String host;

    /**
     * 解析文件转换成base64 调用 微信接口 写入数据
     */
    @RequestMapping("/write")
    public RESPONSE insertBean() throws IOException {
//        URL resource = getClass().getClassLoader().getResource("file/1.txt");
//        File file = new File(resource.getPath());
//        FileReader reader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        StringBuffer sb = new StringBuffer();
//        String line = bufferedReader.readLine();
//        while (line != null) {
//            sb.append(line);
//            line = bufferedReader.readLine();
//        }
//        reader.close();
//        bufferedReader.close();

        try {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] encode = encoder.encode("zzzzzzzzzzzzzzzzzzzddddddddddddddddasfasdfas".getBytes("UTF-8"));
            WRITE_OFD_FILE ofdFile = new WRITE_OFD_FILE();
            ofdFile.setInvoice_code("12345678");
            ofdFile.setInvoice_no("123456");
            ofdFile.setOfd_content_base64(new String(encode));
            String name = Thread.currentThread().getId() + "";
            log.info("线程{} ====>>微信上传数据接口 写入的文件数据 {}  ........", name, ofdFile);

            // 调用L5鉴权开始===============================================
            L5Util l5Util = new L5Util();
            L5sys.QosRequest qosRequest = l5Util.get(modId, cmdId);
            if (qosRequest == null) {
                log.error("调用L5获取路由错误，modId:{},cmdId:{}", modId, cmdId);
            }
            if (qosRequest != null) {
                long start = System.currentTimeMillis();
                // 获取L5远程路由的ip和端口
                String httpString = "http://";
                if (443 == qosRequest.hostPort) {
                    httpString = "https://";
                }
                String ipPortUrl = qosRequest.hostIp + ":" + qosRequest.hostPort;
//                String writeFileUrl = "https://pay.weixin.qq.com/index.php/xphp/cinvoicing/dxhyreadofdfile";
                String writeFileUrl = httpString + ipPortUrl + "/index.php/xphp/cinvoicing/dxhywriteofdfile";
                log.info("线程{}，调用微信上传接口地址为：{}", name, writeFileUrl);
                // 设置host请求头信息
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.HOST, host);
                log.info("微信上传数据接口请求头{}:{}", HttpHeaders.HOST, host);
                HttpEntity httpEntity = new HttpEntity(ofdFile, headers);
                RESPONSE response = restTemplate.postForObject(writeFileUrl, httpEntity, RESPONSE.class);
                long end = System.currentTimeMillis();
                log.info("线程{}，调用微信上传接口地址：{}，响应报文:{}", name, response);
                int tcCode = -1;
                if (response != null) {
                    if ("0".equals(response.getReturn_code())) {
                        tcCode = 0;
                    }
                }
                log.info("调用微信更新接口调用结果：tcCode{}", tcCode, writeFileUrl);
                l5Util.ApiRouteResultUpdate(qosRequest, tcCode, (int) (end - start));
                // 调用L5鉴权结束=========================================================
                return response;
            }
        } catch (Exception e) {
            log.error("调用文件上传错误:", e);
        }
        return null;
    }

    /**
     * 写入数据后调用查询接口，展示返回数据
     */
    @RequestMapping("/read/{invoiceCode}/{invoiceNo}")
    public String readWriteResult(@PathVariable String invoiceNo, @PathVariable String invoiceCode) throws UnsupportedEncodingException {
        String readUrl = readUtl + "?invoice_code=" + invoiceCode + "&invoice_no=" + invoiceNo;
        String name = Thread.currentThread().getName();
        log.info("{} ====>> 请求URL {}  ........", name, readUrl);

        RESPONSE response = restTemplate.getForObject(readUrl, RESPONSE.class);
        log.info("{} ====>> ==> 返回 {} ........", name, response);
        if (response == null) {
            return null;
        }
        if (response.getOfd_content_base64() == null) {
            return null;
        }
        Base64.Decoder decode = Base64.getMimeDecoder();
        return new String(decode.decode(response.getOfd_content_base64().getBytes("UTF-8")));
//        return response.getOfd_content_base64();

    }
}
