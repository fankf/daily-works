package com.fankf.hutool.core;

import cn.hutool.core.io.FastByteArrayOutputStream;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.file.FileAppender;
import cn.hutool.core.util.HashUtil;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;

/**
 * @author fankf
 * @date 2021/7/8 15:30
 * @description
 */
public class IOTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //流的读写可以总结为从输入流读取，从输出流写出，这个过程我们定义为拷贝。这个是一个基本过程，也是文件、流操作的基础。
        // 字节流读写
        File file = new File("d:/1.txt");
        if(!FileUtil.exist(file)){
            FileUtil.touch(file);
        }
        File file1 = FileUtil.writeBytes("nihao\ndsadsaddsa\nsdasa".getBytes("utf-8"), file);
        List<String> s = FileUtil.readLines(file, Charset.defaultCharset());
        System.out.println(s);

        // 字符流读写 copy
        BufferedInputStream inputStream = FileUtil.getInputStream(file);
        File fileCp = new File("d:/1cp.txt");
        if(!FileUtil.exist(fileCp)){
            FileUtil.touch(fileCp);
        }
        BufferedOutputStream outputStream = FileUtil.getOutputStream(fileCp);
        long copy = IoUtil.copy(inputStream, outputStream);
        System.out.println(copy);
        
        // 文本追加
        FileAppender fileAppender = new FileAppender(file,16,true);
        fileAppender.append("\n1222222222222222222223");
        fileAppender.append("122222222222222222222t");
        fileAppender.append("122222222222222222222z");
        fileAppender.flush();
        IoUtil.close(inputStream);
        IoUtil.close(outputStream);
        List<String> list = FileUtil.readLines(file, "utf-8");
        System.out.println(list);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
