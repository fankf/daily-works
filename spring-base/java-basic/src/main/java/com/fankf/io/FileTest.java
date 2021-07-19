package com.fankf.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileTest {
    public static final String basePath = "D:/file/";

    public static void main(String[] args) throws IOException {
        mkdir("1");
        delete("1");

    }

    public void search(String fileName){
        File file = new File(basePath + fileName);
        file.list();
    }

    private static void delete(String fileName) {
        File file = new File(basePath + fileName);
        file.delete();
    }

    private static void mkdir(String fileName) throws IOException {
        // 创建文件夹
//        File file = new File(basePath);
//        if (!file.exists()) {
//            //file.mkdir(); mkdir 只能创建一级目录
//            boolean mkdirs = file.mkdirs();
//            System.out.println("创建文件成功：" + basePath);
//        }
//        // 创建文件
//        File file1 = new File(basePath + fileName);
//        if (!file1.exists()) {
//            file.createNewFile();
//            System.out.println("创建文件成功：" + basePath + fileName);
//        }

        File file1 = new File("d:\\1.txt");
//        File file2 = new File("d:\\2.txt");
//        File file3 = new File("d:\\3.txt");
//        List<String> list = FileUtils.readLines(file2, "UTF-8");
//        List<String> list1 = new ArrayList<>();
//        for (String s : list) {
//            list1.add(s.split("\\[")[1]);
//        }
//        FileUtils.writeLines(file3,list1);


//        List<String> stringList = FileUtils.readLines(file1);
//        Set<String> collect = stringList.stream().map(o -> o.split(",")[0].split("：")[1]).collect(Collectors.toSet());
//        System.out.println(collect);
//        System.out.println( YearMonth.now().minusMonths(12)+"=="+YearMonth.now().plusMonths(1));
            StringBuilder sb = new StringBuilder();
            sb.append(123);
        System.out.println(sb.toString());
        sb.setLength(0);
        System.out.println(sb.toString());
        sb.append(123333);
        System.out.println(sb.toString());
    }
}
