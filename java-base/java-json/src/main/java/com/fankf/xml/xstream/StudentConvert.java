package com.fankf.xml.xstream;

import com.fankf.bean.Student;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.util.Arrays;
import java.util.Iterator;

/**
 * fankunfeng
 * 2020-11-18 22:45
 */
public class StudentConvert implements Converter {

    //对象转换
    @Override
    public void marshal(Object value, HierarchicalStreamWriter writer, MarshallingContext marshallingContext) {
        Student student = (Student) value;
        writer.startNode("studentName");
        writer.setValue(student.getStudentName());
        writer.endNode();
        writer.startNode("studentAge");
        writer.setValue(student.getStudentAge() + "");
        writer.endNode();

        writer.startNode("studentNo");
        writer.setValue(student.getStudentAge()+"");
        writer.endNode();

        writer.startNode("phoneList");
        writer.setValue(student.getPhoneList()+"");
        writer.endNode();
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext unmarshallingContext) {
        Student student = new Student();
        student.setStudentName(reader.getValue());
        reader.moveUp();
        reader.moveDown();
        student.setStudentAge(Integer.parseInt(reader.getValue()));
        reader.moveUp();
        reader.moveDown();
        student.setStudentNo(reader.getValue());
        reader.moveUp();
        reader.moveDown();
        student.setPhoneList(null);
        reader.moveUp();
        return student;
    }

    @Override
    public boolean canConvert(Class aClass) {
        return aClass.equals(Student.class);
    }
}
