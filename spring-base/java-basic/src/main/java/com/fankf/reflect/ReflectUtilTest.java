package com.fankf.reflect;

import com.fankf.base.User;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author fans
 * @date 2022/8/9 15:05
 * @description
 */
public class ReflectUtilTest {


    public static void main(String[] args) {
        User user2 = new User();
        LinkedHashMap<Class<?>, Object> paramMaps = new LinkedHashMap<>();
        paramMaps.put(String.class, "1234");
        Object setId = invoke(user2, "setId", paramMaps);
        System.out.println(user2);
        Object getId = invoke(user2, "getId", null);
        System.out.println(getId);
    }

    /**
     * 反射执行方法
     *
     * @param object     执行的对象
     * @param methodName 方法名
     * @param paramsMaps 参数数组
     * @return
     */
    public static Object invoke(Object object, String methodName, LinkedHashMap<Class<?>, Object> paramsMaps) {
        Class<?> objectClass = object.getClass();
        // public 方法 包括父类集成的方法
        Object result = null;
        Method[] methods = objectClass.getMethods();
        for (Method method : methods) {
            // 检验方法名是否相同
            if (method.getName().equals(methodName)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                // 判断是否无参数
                if (parameterTypes.length != 0) {
                    if (parameterTypes.length == paramsMaps.size()) {
                        LinkedList<Class<?>> classes = new LinkedList<>(paramsMaps.keySet());
                        boolean flag = true;
                        // 检验参数类型是否相同
                        for (int i = 0; i < parameterTypes.length; i++) {
                            Class<?> parameterType = parameterTypes[i];
                            Class<?> aClass = classes.get(i);
                            System.out.println("parameterType " + parameterType.getName());
                            System.out.println("aClass " + aClass.getName());
                            if (parameterType != aClass) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            try {
                                Object[] objs = new Object[parameterTypes.length];
                                int i = 0;
                                for (Object obj : paramsMaps.values()) {
                                    objs[i] = obj;
                                    i++;
                                }
                                result = method.invoke(object, objs);
                                break;
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } else {
                    try {
                        result = method.invoke(object);
                        // 跳出遍历
                        break;
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }


            }
        }
        return result;
    }
}
