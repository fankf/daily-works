package com.fankf.reflect;

import com.fankf.base.User;
import com.fankf.bean.Student0;
import org.springframework.util.StringUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IntrospectionException {

        User user = new User();
        User user2 = new User();
        user.setPassword("123");
        user2.setPassword("123");

        System.out.println(compareProperties(user,user2));

        System.out.println(String.valueOf(Double.valueOf("0.090")));

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
    public static boolean compareProperties(Object obj1, Object obj2) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        //为空判断
        if (obj1 == null && obj2 == null) {
            return true;
        } else if (obj1 == null || obj2 == null) {
            return false;
        }

        Class<?> classType = obj1.getClass();
        //如果传入的类型不一样则直接返回false
        //C#中通过CompareProperties<T>中的<T>可以限定传入的类型必须一致，所以不需要该判断
        if (classType != obj2.getClass()) {
            return false;
        }

        Field[] fields = obj1.getClass().getDeclaredFields();//获得所有字段
        for (Field field : fields) {
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), classType);//获得类中字段的属性描述
            Method getMethod = propertyDescriptor.getReadMethod();//从属性描述中获得字段的get方法
            //通过getMethod.invoke(obj)方法获得obj对象中该字段get方法返回的值
            Object invoke = getMethod.invoke(obj1);
            Object invoke2 = getMethod.invoke(obj2);
            if((invoke == null && invoke2 !=null) || (invoke != null && invoke2 ==null)){
                return false;
            }
            if (!invoke.equals(invoke2)) {
                return false;
            }
        }

        return true;
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
        Method setAge = clazz.getMethod("setId", Integer.TYPE);
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
            System.out.println("constructors ==>" + constructor);
        }
        //
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("declaredConstructors ==>" + constructor);
        }
    }
}
