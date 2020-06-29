package com.fankf.springkafka.service;

import java.util.Set;

public interface TopicService {

    /**
     * 返回当前所有队列
     *
     * @return
     */
    Set<String> listTopic();

    /**
     * 删除队列 topic
     * @param topicName
     * @return
     */
    boolean deleteTopic(String topicName);

    /**
     * 创建并返回当前所有队列
     *
     * @param topics
     * @return
     */
    Set<String> createTopics(String[] topics);
}
