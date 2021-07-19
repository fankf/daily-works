package com.fankf.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author fankf
 * @date 2021/5/26 16:58
 * @description
 */
@lombok.Data
public class DataInfo {
    @JSONField(name = "code")
    private int code;
    @JSONField(name = "msg")
    private String msg;
    @JSONField(name = "responseTime")
    private String responseTime;
    @JSONField(name = "data")
    private List<Cal> data;

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\wengegroup\\Desktop\\1.txt");
        String string = FileUtils.readFileToString(file, "UTF-8");
        System.out.println(string);
        JSONObject jsonObject = JSON.parseObject(string);
        System.out.println(JSON.toJSONString(jsonObject));
//        Integer t = 0;
        countMap.set(new HashMap<>());
        JSONArray array = (JSONArray) jsonObject.get("data");

        cal(array, 1);
        System.out.println(JSON.toJSONString(countMap.get()));
    }

    public static ThreadLocal<Map<Integer, Integer>> countMap = new ThreadLocal<>();

    public static void cal(JSONArray array, Integer t) {
        Map<Integer, Integer> map = countMap.get();

        Integer count = 0;
        if (map.keySet().size() >= t) {
            count = map.get(t);
        }
//        int key = t;
        System.out.println("t:{},"+t+"key:{}"+t);
        if (count == null) {
            count = 0;
        }
        map.put(t, count);
        for (Object o : array) {
            JSONObject object = (JSONObject) o;
            count += object.getInteger("count");
            if (object.getString("children") != null) {
                t++;
                JSONArray children = JSONArray.parseArray(object.getString("children"));
                cal(children, t);
            }
        }

        countMap.set(map);

    }


}
