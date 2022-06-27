package com.fankf;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
class JavaBasicApplicationTests {

    @Test
    void contextLoads() throws IOException {
        String fileToString = FileUtils.readFileToString(new File("C:\\Users\\wengegroup\\Desktop\\forum.txt"));

        File file = new File("D:\\keys.xlsx");
        JSONArray array = JSON.parseArray(fileToString);
        List<Set<String>> list = new ArrayList<>();
        for (Object o : array) {
            JSONObject parseObject = JSON.parseObject(String.valueOf(o));
            for (String s : parseObject.keySet()) {
                Object o1 = parseObject.get(s);
                parseObject = JSON.parseObject(String.valueOf(o1));
                JSONObject mappings = parseObject.getJSONObject("mappings").getJSONObject("properties");
                System.out.println(s);
                System.out.println(mappings.keySet());
                list.add(mappings.keySet());
            }

        }

//        ExcelWriter writer = ExcelUtil.getWriter(file);
//        for (int i = 0; i < list.size(); i++) {
//            writer.setSheet(i);
//            writer.write(list.get(i));
//
//        }
//        writer.close();
    }

}
