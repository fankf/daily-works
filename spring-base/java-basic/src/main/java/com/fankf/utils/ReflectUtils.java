package com.fankf.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 反射相关工具类
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

    public static void copy(Object source, Object target) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();
        Field[] sourceClassFields = sourceClass.getDeclaredFields();
        Field[] targetClassFields = targetClass.getDeclaredFields();

        for (Field targetClassField : targetClassFields) {
            String targetFirstUpper = targetClassField.getName().substring(0, 1).toUpperCase();
            String setName = "set" + targetFirstUpper + targetClassField.getName().substring(1);
            for (Field sourceClassField : sourceClassFields) {
                if (targetClassField.getName().equals(sourceClassField.getName())) {
                    String sourceFirstUpper = sourceClassField.getName().substring(0, 1).toUpperCase();
                    String getName = "get" + sourceFirstUpper + sourceClassField.getName().substring(1);


                    Method getMethod = sourceClass.getMethod(getName);
                    Method setMethod = targetClass.getMethod(setName, sourceClassField.getType());

                    Object invoke = getMethod.invoke(source);
                    if(invoke != null) {
                        setMethod.invoke(target, new Object[]{invoke});
                    }
                    break;

                }
            }
        }
    }


    public static Object invoke(Object object ,String methodName,Object[] params){
        Class<?> objectClass = object.getClass();
        // public 方法 包括父类集成的方法
        Object result = null;
        Method[] methods = objectClass.getMethods();
        for (Method method : methods) {
            if(method.getName().equals(methodName)){
                try {
                    result = method.invoke(object, params);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
