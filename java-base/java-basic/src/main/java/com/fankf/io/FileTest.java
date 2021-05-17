package com.fankf.io;

import java.io.File;
import java.io.IOException;

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
        File file = new File(basePath);
        if (!file.exists()) {
            //file.mkdir(); mkdir 只能创建一级目录
            boolean mkdirs = file.mkdirs();
            System.out.println("创建文件成功：" + basePath);
        }
        // 创建文件
        File file1 = new File(basePath + fileName);
        if (!file1.exists()) {
            file.createNewFile();
            System.out.println("创建文件成功：" + basePath + fileName);
        }
    }
}
