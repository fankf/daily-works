package com.fankf.sign.prototype;

import java.io.IOException;

/**
 * **************************************
 * <p>
 * 原型模式虽然是创建型的模式，但是与工程模式没有关系，从名字即可看出，
 * 该模式的思想就是将一个对象作为原型，对其进行复制、克隆，产生一个和原对象类似的新对象。
 *
 * @author fankunfeng
 * @datetime 2020-07-23 16:41
 * @package com.fankf.sign.prototype
 * ***************************************
 */
public class Student4Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student4 student4 = new Student4();
        student4.setAge(12);

        Student4 student41 = student4.deepClone();
        System.out.println(student41.getAge());

    }
}
