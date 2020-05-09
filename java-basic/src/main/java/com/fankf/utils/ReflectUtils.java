package com.fankf.utils;

import java.util.List;

/**
 * 反射相关工具类
 * 只在当前类的方法中，不包括基类
 */
public class ReflectUtils {

    public static boolean containFiled(Class<?> clazz, String method) {
        try {
            clazz.getDeclaredField(method);
        } catch (NoSuchFieldException e) {
            return false;
        }
        return true;
    }

    public static boolean containFileds(Class<?> clazz, List<String> methods) {
        for (String method : methods) {
            try {
                clazz.getDeclaredField(method);
            } catch (NoSuchFieldException e) {
                return false;
            }
        }
        return true;
    }
}
