package com.fankf.springmvc;

import com.alibaba.fastjson.JSON;
import com.fankf.springmvc.dao.UserDao;
import com.fankf.springmvc.entity.User;
import com.fankf.springmvc.util.XStremUtil;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Base64;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class SpringMvcApplicationTests {
    public static final Logger log = LoggerFactory.getLogger(SpringMvcApplicationTests.class);

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        User user = new User();
        user.setAge(123);
        user.setUsername("2");
        int insert = userDao.insert(user);
    }

    @Test
    void test() {
        String s = XStremUtil.beanToXmlSk(new FPXT());
        byte[] encode = Base64.getEncoder().encode(s.getBytes());
        COM_INPUT comInput = new COM_INPUT();
        comInput.setID("0118");
        comInput.setDATA(new String(encode));
        String req = XStremUtil.beanToXmlSk(comInput);

        COM_INPUT comInput1 = XStremUtil.xmlToBean(req, COM_INPUT.class);
        System.out.println(comInput1);

//        String post = HttpUtils.httpPost("http://110.83.51.109:10080/350100888888001_0/InvoiceService", req);
//        System.out.println(post);
        String str = "<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                "<COM_OUTPUT><ID>0118</ID><CODE>0000</CODE><MESS>success</MESS><DATA>PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iR0JLIj8+CjxGUFhUPjxPVVRQVVQ+PElEPjAx\n" +
                "MTg8L0lEPjxDT0RFPjAwMDA8L0NPREU+PE1FU1M+c3VjY2VzczwvTUVTUz48REFUQT48TFhTQz45\n" +
                "OTk8L0xYU0M+PFpaTEZTSj4yMDIwLTExLTAzIDE1OjU5OjAwPC9aWkxGU0o+PEpTUFNKPjIwMjAt\n" +
                "MTEtMDQgMTQ6MjU6MjE8L0pTUFNKPjwvREFUQT48L09VVFBVVD48L0ZQWFQ+</DATA></COM_OUTPUT>";

        if (StringUtils.isBlank(str)) {
            log.error(" 纳税人识别号 ： {} 离线税盘查询失败");
        } else {
            COM_OUTPUT comOutput = XStremUtil.xmlToBean(str, COM_OUTPUT.class);
            log.info("离线税盘查询结果：{}", JSON.toJSONString(comOutput));
            if (!"0000".equals(comOutput.getCODE())) {
                log.error("离线税盘查询返回失败！");
            } else {
                byte[] decode = Base64.getMimeDecoder().decode(comOutput.getDATA().getBytes());
                System.out.println(new String(decode));
                FPXT fpxt = XStremUtil.xmlToBean(new String(decode), FPXT.class);

                log.info("查询解析结果：{}", JSON.toJSONString(fpxt));

                SPLXXX splxxx = fpxt.getOUTPUT().getDATA();
                if (splxxx.getLXSC() > 0) {
                }
            }
        }
    }


}
