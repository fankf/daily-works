package com.fans.service;

import com.fans.bean.SourceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

/**
 * @author fankf
 * @date 2021/6/7 16:49
 * @description
 */
@Service
public class SourceInfoServiceImpl {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public SourceInfo queryById(String uuid){
        return elasticsearchTemplate.get(uuid, SourceInfo.class);
    }

    public boolean exist(String uuid){
        return elasticsearchTemplate.exists(uuid,SourceInfo.class);
    }
}
