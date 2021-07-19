package com.fankf.hutool.core;

import cn.hutool.core.util.EscapeUtil;

/**
 * @author fankf
 * @date 2021/7/8 16:49
 * @description
 */
public class EscapeTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080/info?";
        String param = "a=ddsds&b=你好";
        String escape = EscapeUtil.escape(param);
        String reescape = EscapeUtil.unescape(escape);
        System.out.println(escape+"\n"+reescape);
    }
}
