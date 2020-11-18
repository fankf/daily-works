package com.fankf.json.jackson;

import com.fankf.json.Demo;
import com.fankf.bean.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJackson {
    public static void main(String[] args) {
        //parse objectString
        Student student = Demo.getStudent();
        ObjectMapper objectMapper = new ObjectMapper();
        String var1 = null;
        try {
            var1 = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(var1);

        // jackson 必须处理异常
        String studentString = Demo.getStudentString();
        Student student1 = null;
        try {
            student1 = objectMapper.readValue(studentString, Student.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(student1);
    }
}
