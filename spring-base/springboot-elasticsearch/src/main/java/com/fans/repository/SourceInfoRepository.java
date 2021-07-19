package com.fans.repository;

import com.fans.bean.SourceInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author fankf
 * @date 2021/6/7 16:47
 * @description
 */
@Repository
public interface SourceInfoRepository extends ElasticsearchRepository<SourceInfo,String> {
}
