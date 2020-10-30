package com.fankf.xml;

import com.fankf.utils.JaxbUtil;

/**
 * fankunfeng
 * 2020-10-26 10:15
 */
public class XMLTest {
    public static void main(String[] args) {
        String xml = "<?xml version=\"1.0\" encoding=\"GBK\" ?><com.dxhy.order.consumer.model.tax.COM_INPUT>\n" +
                "  <ID>0118</ID>\n" +
                "  <DATA>PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiID8+PGludGVyZmFjZSB4bWxucz0iIiB4bWxuczp4c2k9Imh0dHA6Ly93d3cudzMub3JnLzIwMDEvWE1MU2NoZW1hLWluc3RhbmNlIiB4c2k6c2NoZW1hTG9jYXRpb249Imh0dHA6Ly93d3cuY2hpbmF0YXguZ292LmNuL3RpcmlwL2RhdGFzcGVjL2ludGVyZmFjZXMueHNkIiB2ZXJzaW9uPSJEWkZQMS4wIiA+PGNvbS5keGh5Lm9yZGVyLmNvbnN1bWVyLm1vZGVsLnRheC5GUFhULz48L2ludGVyZmFjZT4=</DATA>\n" +
                "</com.dxhy.order.consumer.model.tax.COM_INPUT>";
        String replace = xml.replace("_", "");
        COMINPUT comoutput = JaxbUtil.converyToJavaBean(replace, COMINPUT.class);
        System.out.println(comoutput);
    }
}
