package com.fans.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author fankunfeng
 * @date 2022-03-03 19:14:44
 */
@Slf4j
@Data
public class KeyMatchUtil {

    public Set<String> keys;
    public String keywordPath;

    public KeyMatchUtil(String keywordPath) {
        this.keywordPath = keywordPath;

        File file = new File(keywordPath);
        if (!file.exists()) {
            log.error("当前文件读取keyword 失败，路径不对，当前读取路径为：{}", keywordPath);
        }
        File[] files = file.listFiles();
        final Set<String> set = new HashSet<>();
        for (File f : files) {
            try (InputStream in = FileUtils.openInputStream(f)) {
                final InputStreamReader inputStreamReader = new InputStreamReader(in, Charsets.UTF_8);
                final BufferedReader reader = IOUtils.toBufferedReader(inputStreamReader);
                String line = reader.readLine();
                while (line != null) {
                    if (line.contains(",")) {
                        for (String s : line.split(",")) {
                            if (keywordFilter(set, s)) {
                                set.add(s);
                            }
                        }
                    } else {
                        if (keywordFilter(set, line)) {
                            set.add(line);
                        }
                    }

                    line = reader.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.keys = set;
    }

    /**
     * 过滤的三种情况
     * A 已有,B 传参
     * A == B ，B 包含 A 不处理, A 包含 B B 插入A 移除,
     *
     * @param keys
     * @param keyword
     * @return 是否添加关键词
     */
    private static boolean keywordFilter(Set<String> keys, String keyword) {
        boolean flag = true;
        Set<String> removeKeys = new HashSet<>();
        for (String key : keys) {
            if (keyword.contains(key)) {
                return false;
            }
            if (key.contains(keyword)) {
                removeKeys.add(key);
            }
        }
        keys.removeAll(removeKeys);
        return flag;
    }

    /**
     * 添加关键字
     *
     * @param keyword
     * @return true 添加成功 false 添加失败
     */
    public boolean addKeyword(String keyword) {
        if (keywordFilter(getKeys(), keyword)) {
            getKeys().add(keyword);
            writeAppendKeyword(Arrays.asList(keyword));
            return true;
        }
        return false;
    }

    private void writeAppendKeyword(List<String> keywords) {
        // 写入文件
        File file = new File(getKeywordPath() + "append.txt");
        if (!file.exists()) {
            try {
                boolean newFile = file.createNewFile();
                if (newFile) {
                    FileUtils.writeLines(file, Arrays.asList(keywords), true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {

        System.out.println("开始时间：" + LocalDateTime.now());
        String path = "D:\\company";
//        Set<String> keys = new KeyMatchUtil(path).getKeys();
//        System.out.println(keys.size());

        Set<String> keys = new HashSet<>();
        File file2 = new File("D:\\base_data_company_base2.txt");
        File file3 = new File("D:\\base_data_company_base3.txt");
        List<String> list = FileUtils.readLines(file2);
        for (String s : list) {
            if (s.length() > 1) {
//            if (keywordFilter(keys, s)) {
                keys.add(s);
            }
        }
        System.out.println("keys size "+ keys.size());
        FileUtils.writeLines(file3,keys);
        System.out.println("结束时间：" + LocalDateTime.now());
    }
}

