package com.fankf.poi;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fankunfeng
 * @date 2022-06-11 18:32
 */
public class TxtTest {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\company_hn_202206101817.txt");
        File file2 = new File("C:\\Users\\Administrator\\Desktop\\company_hn_ext.txt");

        Set<String> ex = new HashSet<>();
        List<String> strings = FileUtils.readLines(file, StandardCharsets.UTF_8);
        for (String string : strings) {
            String[] split = string.split("\\|");
            System.out.println(split[1].trim()+"=="+split[2].trim());
            if(split[1].contains(split[2])){
                ex.add(split[1]);
            }
            ex.add(split[2]);
        }
        FileUtils.writeLines(file2,ex);
    }
}
