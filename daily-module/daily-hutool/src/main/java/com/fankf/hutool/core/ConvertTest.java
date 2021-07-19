package com.fankf.hutool.core;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.convert.Converter;
import cn.hutool.core.convert.ConverterRegistry;
import cn.hutool.core.util.CharsetUtil;
import com.fankf.hutool.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author fankf
 * @date 2021/7/8 14:30
 * @description
 */
public class ConvertTest {

    public static final Logger log = LoggerFactory.getLogger(ConvertTest.class);

    /**
     * 1、类型转换
     * @param args
     */
    public static void main(String[] args) {
        Boolean aTrue = Convert.toBool("true");
        log.info("atrue,{}",aTrue);
        int[] strs = {1,2,3,4,5};
        List convert = Convert.convert(List.class, strs);
        System.out.println(convert);
        Boolean aBoolean = Convert.toBool("", false);
        System.out.println(aBoolean);
        // 半角全角转换
        String str = "1,2,3,4,5";
        //全角
        String s = Convert.toSBC(str);
        // 半角
        String s1 = Convert.toDBC(s);
        System.out.println(s +"\n"+s1);

        //16进制（Hex）
        String string = "你好，我目前在北京";
        String s2 = Convert.toHex(string, CharsetUtil.CHARSET_UTF_8);
        String s3 = Convert.hexToStr(s2, CharsetUtil.CHARSET_UTF_8);
        System.out.println(s2+"\n"+s3);

        //unicode
        String s4 = Convert.strToUnicode(string);
        String s5 = Convert.unicodeToStr(s4);
        System.out.println(s4+"\n"+s5);

        // 转换编码
        String s6 = Convert.convertCharset(string, CharsetUtil.UTF_8, CharsetUtil.ISO_8859_1);
        String s7 = Convert.convertCharset(s6, CharsetUtil.ISO_8859_1, CharsetUtil.UTF_8);
        System.out.println(s7.equals(string));


        // 时间转换
        long time = 123231231;
        long l = Convert.convertTime(time, TimeUnit.SECONDS, TimeUnit.HOURS);
        System.out.println(l);

        //金额转换 计数专用
        double money = 123.12;
        String s8 = Convert.digitToChinese(money);
        System.out.println(s8);

    }
}
