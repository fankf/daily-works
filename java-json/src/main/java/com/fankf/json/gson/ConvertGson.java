package com.fankf.json.gson;

import com.fankf.json.Demo;
import com.fankf.json.bean.Student;
import com.google.gson.Gson;

public class ConvertGson {
    public static void main(String[] args) {
        // parse string
        Student stu0 = Demo.getStudent();
        Gson gson = new Gson();
        String var0 = gson.toJson(stu0);
        System.out.println(var0);
        // parse object
        String var1 = Demo.getStudentString();
        Student stu1 = gson.fromJson(var1, Student.class);
        System.out.println(stu1);
    }
}
