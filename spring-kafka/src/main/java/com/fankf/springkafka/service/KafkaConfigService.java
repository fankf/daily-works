package com.fankf.springkafka.service;

public interface KafkaConfigService {

    /**
     * 查看队列配置
     * @param topic
     */
    void selectKafkaConfig(String topic);

    /**
     * 更细队列配置
     * @param topic
     */
    void updateKafkaConfig(String topic);
}
