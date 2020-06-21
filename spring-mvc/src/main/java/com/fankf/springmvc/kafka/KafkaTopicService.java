package com.fankf.springmvc.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author fan
 * @create 2020-06-21 10:10
 * @description
 * @see
 */
@Component
@Slf4j
public class KafkaTopicService {
    public static final String CLASS_NAME = "(KafkaTopicService)";
    @Autowired
    AdminClient adminClient;

    /**
     * create topic in the cluster
     *
     * @param topicName
     */
    @GetMapping("/create/{topicName}")
    public boolean createTopic(@PathVariable("topicName") String topicName) {
        boolean exist = listAllTopics().stream().allMatch(topic -> topic.equals(topicName));

        if (exist) {
            log.error("{} ==> 此 TOPIC 已存在！", CLASS_NAME);
        }
        NewTopic newTopic = new NewTopic(topicName, 3, (short) 1);
        CreateTopicsResult ret = adminClient.createTopics(Arrays.asList(newTopic));
        Map<String, KafkaFuture<Void>> values = ret.values();
        for (String key : values.keySet()) {
            log.info("{} ==> 创建 topic 返回结果 {} ", CLASS_NAME, values.get(key));
        }
        return true;

    }

    /**
     * print all topics in the cluster
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @GetMapping("/list")
    public Set<String> listAllTopics() {
        ListTopicsOptions options = new ListTopicsOptions();
        options.listInternal(true); // includes internal topics such as __consumer_offsets
        ListTopicsResult topics = adminClient.listTopics(options);
        Set<String> topicNames = new HashSet<>();
        try {
            topicNames = topics.names().get();
            log.info("{} ==> Current topics in this cluster: {} ", CLASS_NAME, topicNames);

        } catch (InterruptedException e) {
            log.error("{} ==> listAllTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        } catch (ExecutionException e) {
            log.error("{} ==> listAllTopics 异常信息：{}", CLASS_NAME, e);
            e.printStackTrace();
        }
        return topicNames;

    }
}
