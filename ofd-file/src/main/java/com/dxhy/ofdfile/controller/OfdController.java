package com.dxhy.ofdfile.controller;

import com.dxhy.ofdfile.protocol.RESPONSE;
import com.dxhy.ofdfile.protocol.WRITE_OFD_FILE;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
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

        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode("zzzzzzzzzzzzzzzzzzzddddddddddddddddasfasdfas".getBytes("UTF-8"));
        WRITE_OFD_FILE ofdFile = new WRITE_OFD_FILE();
        ofdFile.setInvoice_code("12345678");
        ofdFile.setInvoice_no("123456");
        ofdFile.setOfd_content_base64(new String(encode));
        HttpEntity httpEntity = new HttpEntity(ofdFile);
        String name = Thread.currentThread().getName();

        log.info("{} ====>> 写入数据 {}  ........", name, ofdFile);

        RESPONSE response = restTemplate.postForObject(writeUrl, httpEntity, RESPONSE.class);
        log.info("{} ====>> ==> 返回 {} ........", name, response);
        if (response == null) {
            return response;
        }
        return response;

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
