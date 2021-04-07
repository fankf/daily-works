package com.fankf.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fankunfeng
 * 2021-04-06 15:48
 */
public class BasicTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person();
        p.setId("1");
        p.setName("zhangsan");
        p.setExplain(Arrays.asList("1234444"));
        int[] scores = new int[]{88,77,78,99};
        p.setScores(scores);

        List<Child> childList = new ArrayList<>();
        Child child = new Child();
        child.setName("lihua");
        child.setSex(Sex.FEMALE);
        childList.add(child);
        p.setChildList(childList);
        p.setSex(Sex.MALE);

        Person clone = (Person) p.clone();
        System.out.println("person == " + p);
        // 修改
        clone.setSex(Sex.FEMALE);
        clone.setId("123");
        clone.setName("lisi");
        clone.setExplain("12323");
        scores[0] = 999;
        clone.setScores(scores);
        List<Child> cloneChildList = clone.getChildList();
        for (Child child1 : cloneChildList) {
            child1.setName("child");
            child1.setSex(Sex.MALE);
        }
        clone.setChildList(cloneChildList);
        System.out.println("person == " + p);
        System.out.println("clone  == " + clone);


    }
}
