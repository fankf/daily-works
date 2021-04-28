package com.fankf.sign.observer;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 11:16
 * @package com.fankf.sign.observer
 */
@Slf4j
public class DataObeserver extends Observer<DataInterface>{

    @Override
    public void update(String key) {
//        log.info("map 数据 ：{}", JSON.toJSONString(map.values()));
        List<DataInterface> list = map.get(key);
        if(list == null){
            list = new ArrayList<>();
        }
        list.forEach(DataInterface::update);
    }
}
