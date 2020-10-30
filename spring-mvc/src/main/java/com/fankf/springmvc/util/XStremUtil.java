package com.fankf.springmvc.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;
import com.thoughtworks.xstream.io.xml.XppDriver;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Alan on 2018/7/24.
 */
@Slf4j
public class XStremUtil {


    //创建xStream对象
    private static XStream xStream = new XStream(new XppDriver(new XmlFriendlyNameCoder("_-", "_")));


    public static String beanToXml(Object obj){
        xStream.processAnnotations(obj.getClass());
        String s = xStream.toXML(obj);
        String s1 = s.replaceAll("<interface>","").replaceAll("</interface>","");
        StringBuffer result = new StringBuffer();
        result.append("<?xml version=\"1.0\" encoding=\"utf-8\" ?>");
        result.append("<interface xmlns=\"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.chinatax.gov.cn/tirip/dataspec/interfaces.xsd\" version=\"DZFP1.0\" >");
        result.append(s1);
        result.append("</interface>");
        return result.toString();
    }

    public static String beanToXmlSk(Object obj){
        xStream.processAnnotations(obj.getClass());
        String s1 = xStream.toXML(obj);
        StringBuffer result = new StringBuffer();
        result.append("<?xml version=\"1.0\" encoding=\"GBK\" ?>");
        result.append(s1);
        return result.toString();
    }

    public static String beanToBusinsessXml(Object obj){
        xStream.processAnnotations(obj.getClass());
        String s = xStream.toXML(obj);
        return s;
    }


    public static <T> T xmlToBean(String xml,Class<? extends T> c){
        try{
            //启用注解
            xStream.processAnnotations(c);
            T t = (T)xStream.fromXML(xml);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T xmlToBean(XStream stream, String xml, Class<?> c){
        try{
            //启用注解
            stream.processAnnotations(c);
            T t = (T)stream.fromXML(xml);
            return t;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
