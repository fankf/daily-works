package com.fankf.reflect;

import com.fankf.bean.Student0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException {
        Student0 demo = Student0.demo();
        //获取类
        reflect(demo.getClass());
    }

    private static void reflect(Class<?> clazz) throws NoSuchFieldException {
        // 类名
        String name = clazz.getName();

        //获取构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        //获取方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Field declaredField1 = clazz.getDeclaredField("");
        // field
        Field[] declaredFields = clazz.getDeclaredFields();
        Field declaredField = clazz.getDeclaredField("name");
        Field[] fields = clazz.getFields();
        Field field = clazz.getField("age");
        System.out.println();
    }
}
