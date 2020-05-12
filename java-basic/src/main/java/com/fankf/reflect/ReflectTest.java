package com.fankf.reflect;

import com.fankf.bean.Student0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student0 demo = Student0.demo();
        //获取类
        System.out.println("----------class--------------");
        clazz(demo.getClass());
        System.out.println("----------constructor--------------");
        constructor(demo.getClass());
        System.out.println("-----------filed-------------");
        filed(demo.getClass());
        System.out.println("----------method--------------");
        method(demo.getClass());
        //方法，this.class().getmethod().invoke()
        System.out.println("---------doInvoke---------------");
        doInvoke(demo.getClass());
    }

    private static void doInvoke(Class<?> clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method setId = clazz.getMethod("setId", Integer.TYPE);
        setId.invoke(clazz, 10);
        int getId = (int) clazz.getMethod("getId", null).invoke(clazz, null);
        System.out.println(getId);
    }

    private static void clazz(Class<?> clazz) {
        //类名
        String name = clazz.getName();
        System.out.println("className :" + name);
        //classLoad
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println("classLoader :" + classLoader);
    }

    private static void method(Class<?> clazz) throws NoSuchMethodException {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println("methods == >" + method);
        }
        Method setAge = clazz.getMethod("setId",Integer.TYPE);
        System.out.println("method setId == >" + setAge);

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredFields == >" + declaredField);
        }

        Method declaredMethod = clazz.getDeclaredMethod("setId", Integer.TYPE);
        System.out.println("declaredMethod setAge == >" + declaredMethod);
    }

    private static void filed(Class<?> clazz) throws NoSuchFieldException {
        // field
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredFields[] == >" + declaredField);
        }
        Field declaredField = clazz.getDeclaredField("name");
        System.out.println("declaredField ---- >" + declaredField);
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println("filed[] == >" + declaredField);
        }
        Field field = clazz.getField("id");
        System.out.println("filed ---- >" + declaredField);
    }

    private static void constructor(Class<? extends Student0> clazz) {
        //获取构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructors ==>"+constructor);
        }
        //
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("declaredConstructors ==>"+constructor);
        }
    }
}
