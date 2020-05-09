package com.fankf.json;

import com.fankf.json.bean.Student;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static Student getStudent() {
        return new Student("12", "xiaoming", 12);
    }

    public static List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("12", "xiaoming", 12));
        students.add(new Student("13", "xiaoming2", 33));
        return students;
    }

    public static Student[] getStudentArray() {
        Student[] students = new Student[2];
        students[0] = (new Student("12", "xiaoming", 12));
        students[1] = (new Student("13", "xiaoming2", 33));
        return students;
    }

    public static String getStudentString() {
        return "{\"studentNo\":\"12\",\"studentName\":\"xiaoming\",\"studentAge\":12}";
    }


}
