package com.fankf.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fankf.json.Demo;
import com.fankf.json.bean.Student;

import java.util.List;

public class ConvertFastjson {
    public static void main(String[] args) {
        // bean ,map 和 json相互转换
        convertJavaBean();

        //------------------Map-------------------------
        List<Student> studentList = Demo.getStudentList();
        String list = JSONArray.toJSONString(studentList);
        System.out.println(list);
        //string to array
        JSONArray array = JSON.parseArray(list);
        System.out.println(array);
        //------------------Array------------------------


    }

    private static void convertJavaBean() {
        // parse string
        Student stu0 = Demo.getStudent();
        String var0 = JSON.toJSONString(stu0);
        System.out.println(var0);
        // parse object
        String var1 = Demo.getStudentString();;
        Student stu1 = JSON.parseObject(var1, Student.class);
        System.out.println(stu1);
    }
}
